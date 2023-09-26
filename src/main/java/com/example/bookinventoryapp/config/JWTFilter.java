package com.example.bookinventoryapp.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.GenericFilterBean;
import java.util.Date;
import java.io.IOException;

public class JWTFilter extends GenericFilterBean {
    public static final String BEARER = "Bearer";
    public static final String AUTHORIZATION="Authorization";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String authorization = request.getHeader(AUTHORIZATION);
        if(authorization==null || !authorization.startsWith(BEARER)){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Auth Header is Missing");
        }
        else{
            String token = authorization.substring(7);
            System.out.println(token);
            try{
                Claims claims = Jwts.parser()
                        .setSigningKey("testkey")
                        .parseClaimsJws(token)
                        .getBody();
                Date expiration = claims.getExpiration();
                Date now = new Date();
                if (expiration != null && expiration.before(now)) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.getWriter().println("Token has expired, please login again");
                } else {
                    request.setAttribute("claims", claims);
                    filterChain.doFilter(request, response);
                }
            }
            catch (Exception e){
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().println("Token Not Valid");
            }
        }
    }
}
