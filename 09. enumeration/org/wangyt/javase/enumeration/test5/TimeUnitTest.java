package org.wangyt.javase.enumeration.test5;

import org.junit.Test;

public class TimeUnitTest {

	@Test
	public void testDefaultTime2Millis() {
		// 把1秒转换成毫秒
		System.out.println(TimeUnit.SECOND.defaultTime2Millis(1));
		// 把1分钟转换成毫秒
		System.out.println(TimeUnit.MINUTE.defaultTime2Millis(1));
	}

}
