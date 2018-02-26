package org.wangyt.javase.exception03;

/**
 * @author wangyt
 */
public class BusinessExecption extends RuntimeException
{
	private static final long serialVersionUID = -8695080570014342567L;

	public BusinessExecption()
	{
		super();
	}

	public BusinessExecption(String message)
	{
		super(message);
	}

	public BusinessExecption(String message, Throwable cause)
	{
		super(message, cause);
	}

	public BusinessExecption(Throwable cause)
	{
		super(cause);
	}
}
