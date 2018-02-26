package org.wangyt.javase.exception;

public class SecurityException extends BaseException {
	
	private static final long serialVersionUID = 339046296085539408L;
	public static final String EXCODE_USER_PASSWORD_ERROR = "01";
	public static final String EXCODE_USER_LOCKED = "02";
	public static final String EXCODE_LOGIN_NUM_LOCKED = "03";
	public static final String EXCODE_PASSWORD_EXPIRED = "04";
	public static final String EXCODE_FIRST_LOGIN = "05";
	public static final String EXCODE_NO_ROLE = "06";
	public static final String EXCODE_LONG_TIME_NO_LOGIN = "07";

	public SecurityException() {
	}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	public SecurityException(String bundle, String key, Object... values) {
		super(bundle, key, values);
	}

	public SecurityException(Throwable cause, String bundle, String key, Object... values) {
		super(cause, bundle, key, values);
	}

}
