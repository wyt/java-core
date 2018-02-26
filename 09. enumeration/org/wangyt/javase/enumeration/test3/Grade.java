package org.wangyt.javase.enumeration.test3;

/**
 * 抽象方法在枚举中的应用场合。
 * 
 * @author WANG YONG TAO
 * 
 */
public enum Grade {
	
	/**
	 * 构造枚举实例，通过这种方式实现定义的抽象方法getValueLevel
	 */
	A("[100,90]") {
		public String getValueLevel() {
			return "优秀";
		}
	},
	B("(90,80]") {
		public String getValueLevel() {
			return "良好";
		}
	},
	C("(80,70]") {
		public String getValueLevel() {
			return "一般";
		}
	},
	D("(70,60]") {
		public String getValueLevel() {
			return "较差";
		}
	},
	E("(60,0]") {
		public String getValueLevel() {
			return "不及格";
		}
	};

	private String value;

	private Grade(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	/**
	 * 得到分数的等级,在构造枚举实例的时候需要实现该抽象方法。
	 * 
	 * @return
	 */
	public abstract String getValueLevel();
}