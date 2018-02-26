package org.wangyt.javase.enumeration.test1;

/**
 * 定义一个枚举,将成绩划分为A,B,C,D,E 五个等级。
 * 
 * @author WANG YONG TAO
 * 
 */
public enum Grade {
	
	/**
	 * A <=> A() <==> public static final Grade A = new Grade()
	 */
	A(), B, C, D, E;

	private Grade() {
	}
}

/**
 * JDK1.5之前的做法(枚举没出现之前)
 */
/*class Grade(){
    private Grad(){}
    public static final Grade A = new Grad();
    public static final Grade B = new Grad();
    public static final Grade C = new Grad();
    public static final Grade D = new Grad();
    public static final Grade E = new Grad();
}*/
