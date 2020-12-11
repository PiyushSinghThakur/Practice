package com.cg.associate.exception;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends RuntimeException {
		public EmployeeNotFoundException(String msg) {
			super(msg);
		}
	}

