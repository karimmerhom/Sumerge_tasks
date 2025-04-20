package com.example.task_1.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class ValidationHeaderFilter extends OncePerRequestFilter {

    private static final List<String> EXCLUDED_PATH_PREFIXES = List.of(
            "/api/courses/view",                        // handles /view, /view/{id}, /view?page=1, etc.
            "/swagger-ui",                 // swagger UI paths
            "/swagger-ui.html",
            "/v3/api-docs",
            "/swagger-resources",
            "/webjars"
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

        boolean isExcluded = EXCLUDED_PATH_PREFIXES.stream()
                .anyMatch(path::startsWith);

        if (isExcluded) {
            filterChain.doFilter(request, response);
            return;
        }

        String validationHeader = request.getHeader("x-validation-report");

        if ("true".equalsIgnoreCase(validationHeader)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Missing or invalid 'x-validation-report' header");
        }
    }
}
