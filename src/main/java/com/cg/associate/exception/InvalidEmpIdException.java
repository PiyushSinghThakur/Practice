package com.cg.associate.exception;

@SuppressWarnings("serial")
public class InvalidEmpIdException extends RuntimeException {
	public InvalidEmpIdException(String msg) {
		super(msg);
	}
}
