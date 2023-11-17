package com.liu.webMVC.tools;

import com.jthinking.common.util.ip.IPInfo;
import com.jthinking.common.util.ip.IPInfoUtils;
import com.liu.webMVC.domain.SysRequestLog;
import com.liu.webMVC.mapper.SysRequestLogMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static com.liu.webMVC.tools.DateUtil.getNowTime;
import static com.liu.webMVC.tools.UserAgentParser.parseUserAgent;

public  class RequestUtils {

    public static void getClientInfo(HttpServletRequest request, Integer responseCode) {

        SysRequestLog sysRequestLog = new SysRequestLog();
        String remoteIP = getIpAddr(request);
        sysRequestLog.setIp(remoteIP);
        getLocalAddressById(remoteIP, sysRequestLog);
        String requestURI = request.getRequestURI();
        sysRequestLog.setRequestUrl(requestURI);
        String userAgent = request.getHeader("user-agent");
        Map<String, String> stringStringMap = parseUserAgent(userAgent);
        sysRequestLog.setBrowserName(stringStringMap.get("browserName"));
        sysRequestLog.setBrowserVersionString(stringStringMap.get("browserVersion"));
        sysRequestLog.setOperatingSystem(stringStringMap.get("operatingSystem"));
        sysRequestLog.setRequestTime(getNowTime());
        sysRequestLog.setResponseCode(responseCode);
        insertSysRequestLLog(sysRequestLog);
    }

    // 请求数据入库
    public static void insertSysRequestLLog(SysRequestLog sysRequestLog){
        SpringUtils.getBean(SysRequestLogMapper.class).insert(sysRequestLog);
    }

    /**
     * 获取IP地址方法
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = null;
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(',') > 0) {
                ip = ip.substring(0, ip.indexOf(','));
            }
        }
        return ip;
    }

    /**
     * 根据ip地址获取地理位置
     */
    public static void getLocalAddressById(String ip, SysRequestLog sysRequestLog){
        IPInfo ipInfo = IPInfoUtils.getIpInfo(ip);
        System.out.println("dfsfds");
        System.out.println(ip);
        System.out.println(ipInfo.getCountry()); // 国家中文名称
        System.out.println(ipInfo.getProvince()); // 中国省份中文名称
        System.out.println(ipInfo.getAddress()); // 详细地址
        System.out.println(ipInfo.getIsp()); // 互联网服务提供商
        System.out.println(ipInfo.isOverseas()); // 是否是国外
        System.out.println(ipInfo.getLat()); // 纬度
        System.out.println(ipInfo.getLng()); // 经度

        sysRequestLog.setLat(ipInfo.getLat());
        sysRequestLog.setLng(ipInfo.getLng());
    }
}
