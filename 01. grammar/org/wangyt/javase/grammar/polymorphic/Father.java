package org.wangyt.javase.grammar.polymorphic;

/**
 * @author 王永涛
 * 
 * @date 2012-7-8 下午01:57:25
 * 
 * @version v1.0
 * 
 * @Copyright (c) Copyright 2015 WANGYT, All rights reserved.
 * 
 */
public class Father {

	private String familyName = "";
	private String firstName = "";

	public Father() {
		// 打印出this,看看是谁调用了该方法。
		String thisOfName = this.toString();
		String who = thisOfName.substring(thisOfName.lastIndexOf(".") + 1,
				thisOfName.indexOf("@"));
		System.out.println(who + "调用了Father构造方法");
	}

	/** 获取我的兴趣 **/
	public String getInterest() {
		return getMyName() + "喜欢读报纸.";
	}

	/**
	 * 获取"我"的名字
	 */
	public String getMyName() {
		return familyName + " " + firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}