package org.example.aoprequestloggingdemo.proxy;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.aoprequestloggingdemo.dto.BaseRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;


@Aspect
@Component
public class LoggingInterceptor {

    @Around("@annotation(org.example.aoprequestloggingdemo.annotation.Logged)")
    public Object processLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = getCurrentRequest();
        // You can use the request object to get information about the request if needed e.g. :
//        request.getHeader("Authorization");
//        request.getMethod();
//        request.getPathInfo();

        BaseRequest requestBody = getRequestBody(joinPoint.getArgs());
        System.out.println(requestBody); // Log the request body
        Object result = joinPoint.proceed();
        System.out.println(result); // Log the response body
        return result;
    }

    private HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();
    }

    private BaseRequest getRequestBody(Object[] args) {
        return Arrays.stream(args)
                .filter(BaseRequest.class::isInstance)
                .map(BaseRequest.class::cast)
                .findFirst()
                .orElseThrow();
    }
}
