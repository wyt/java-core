package org.wangyt.javase.exception;

public class SecurityRuntimeException extends BusinessException {

	private static final long serialVersionUID = -4890648423094802866L;
	
	public static final String EXCODE_PASSWORD_NO_CHANGE = "07";
	public static final String EXCODE_PASSWORD_LENGTH = "08";
	public static final String EXCODE_PASSWORD_LOWER = "09";
	public static final String EXCODE_PASSWORD_UPPER = "10";
	public static final String EXCODE_PASSWORD_DIGIT = "11";
	public static final String EXCODE_PASSWORD_SPECIAL = "12";

	public SecurityRuntimeException() {
	}

	public SecurityRuntimeException(String message) {
		super(message);
	}

	public SecurityRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityRuntimeException(Throwable cause) {
		super(cause);
	}

	public SecurityRuntimeException(String bundle, String key, Object... values) {
		super(bundle, key, values);
	}

	public SecurityRuntimeException(Throwable cause, String bundle, String key, Object... values) {
		super(cause, bundle, key, values);
	}

}
