package org.wangyt.javase.grammar.abstractclass;

/**
 * 抽象类
 * 
 * @author wangyt
 * 
 */
public abstract class Animal
{
	private String zhonglei = "四肢动物";

	public Animal()
	{
		System.out.println(this);
	}

	public String getZhonglei()
	{
		return zhonglei;
	}

	public void setZhonglei(String zhonglei)
	{
		this.zhonglei = zhonglei;
	}
	
	/** 抽象方法 */
	abstract void abstractMethod();
}
