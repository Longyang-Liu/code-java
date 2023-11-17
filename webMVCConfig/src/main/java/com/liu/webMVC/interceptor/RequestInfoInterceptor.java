package com.liu.webMVC.interceptor;

import com.liu.webMVC.domain.SysRequestLog;
import com.liu.webMVC.mapper.SysRequestLogMapper;
import com.liu.webMVC.tools.SpringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static com.liu.webMVC.tools.DateUtil.getNowTime;
import static com.liu.webMVC.tools.RequestUtils.getClientInfo;
import static com.liu.webMVC.tools.UserAgentParser.parseUserAgent;

@Component
public class RequestInfoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理之后调用，可以获取响应结果
        System.out.println("Response status: " + response.getStatus());
        getClientInfo(request, response.getStatus());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在请求完成之后调用，可以进行一些清理工作
    }
}

