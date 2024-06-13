package edu.poly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class SessionService {
	@Autowired
	private HttpSession session;
	
	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}

	public <T> T get(String name, T defaultValue) {
		T value = (T) session.getAttribute(name);
		return value != null ? value : defaultValue;
	}
	
	public void remove(String name) {
		session.removeAttribute(name);
	}
}
