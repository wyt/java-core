package org.wangyt.javase.cl.test01;

import java.util.Scanner;

/**
 * 启动虚拟机进程javaw.exe 使之不退出。
 * 
 * 因为要等待输入，(*∩_∩*)
 * 
 * @author WANG YONG TAO
 *
 */
@SuppressWarnings("all")
public class JavaExe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		System.out.println(str);
	}

}
