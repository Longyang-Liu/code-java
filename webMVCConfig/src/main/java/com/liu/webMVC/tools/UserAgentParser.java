package com.liu.webMVC.tools;

import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

import java.util.HashMap;
import java.util.Map;

public class UserAgentParser {

    public static Map<String, String> parseUserAgent(String userAgentString) {
        // 使用 UserAgentUtils 解析User-Agent字符串
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);

        // 获取浏览器信息
        String browserName = userAgent.getBrowser().getName();
        Version browserVersion = userAgent.getBrowserVersion();
        String browserVersionString = browserVersion != null ? browserVersion.getVersion() : "Unknown";

        // 获取操作系统信息
        String operatingSystem = userAgent.getOperatingSystem().getName();

        Map<String, String> map = new HashMap<>();
        map.put("browserName", browserName);
        map.put("browserVersion", browserVersionString);
        map.put("operatingSystem", operatingSystem);
        return map;
    }
}

