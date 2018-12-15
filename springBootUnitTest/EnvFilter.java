package com.example.demo.springBootUnitTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class EnvFilter extends  OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String id = httpServletRequest.getHeader("EnvId");
        String envName = httpServletRequest.getHeader("EnvName");
        logger.info("=========================={},{}"+id+envName);
        if(id.equals("1") && envName.equals("SYS")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }else {
            logger.error("==================Roads lead you!===============================");
        }
    }
}
