package com.sprhib.init;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

class CORSFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        Set<String> allowedOrigins = new HashSet<String>();
        allowedOrigins.add("http://coursworkdb.nazarkosteckij.com/");
        if(request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
            String originHeader = request.getHeader("Origin");

            if(allowedOrigins.contains(request.getHeader("Origin")))
                response.addHeader("Access-Control-Allow-Origin", originHeader);

            response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.addHeader("Access-Control-Max-Age", "1800");
        }

        filterChain.doFilter(request, response);
    }
}
