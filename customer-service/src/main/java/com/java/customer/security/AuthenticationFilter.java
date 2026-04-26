package com.java.customer.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String token = req.getHeader("Authorization");

		// If no token → block request
		if (token == null || !token.startsWith("Bearer ")) {
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			res.getWriter().write("Missing or invalid Authorization header");
			return;
		}

		// Token is valid format → continue
		chain.doFilter(request, response);
	}
}
