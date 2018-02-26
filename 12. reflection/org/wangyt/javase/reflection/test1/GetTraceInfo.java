package org.wangyt.javase.reflection.test1;

/**
 * 得到运行的类名，方法名，所在行号。
 * 
 * @author WANG YONG TAO
 * 
 * @since 2012-7-21 上午09:14:37
 * 
 */
@SuppressWarnings("all")
public class GetTraceInfo {
	
	public static void main(String[] args) {
		System.out.println(GetTraceInfo.getTraceInfo());
	}

	public static String getTraceInfo() {
		StringBuffer sb = new StringBuffer();
		// 提供编程访问由 printStackTrace() 输出的堆栈跟踪信息
		StackTraceElement[] stacks = new Throwable().getStackTrace();

		int stacksLen = stacks.length;

		for (int i = 0; i < stacksLen; i++) {
			System.out.println(
					stacks[i].getClassName() + "," + stacks[i].getMethodName() + "," + stacks[i].getLineNumber());
		}

		sb.append("class: ").append(stacks[1].getClassName())//
				.append("; method: ").append(stacks[1].getMethodName())//
				.append("; number: ").append(stacks[1].getLineNumber());

		return sb.toString();
	}
	
}
