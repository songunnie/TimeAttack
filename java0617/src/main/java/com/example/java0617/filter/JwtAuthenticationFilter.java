package com.example.java0617.filter;

import com.example.java0617.util.JwtTokenProvider;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getTokenFromRequest(request);

            if (JwtTokenProvider.validateToken(token)) {
                String userId = JwtTokenProvider.getUserIdFromToken(token);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId, null, null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHoder.getContext().setAuthentication(authentication);
            } else {
                request.setAttribute("unauthorization", "인증 실패");
            }
        } catch (Exception e) {
            System.out.println("인증 예외 발생");
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        Cookie token = WebUtils.getCookie(request, "token");

        return token.getValue();
    }
}
