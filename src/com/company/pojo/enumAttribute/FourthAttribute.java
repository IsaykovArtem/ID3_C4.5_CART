package com.company.pojo.enumAttribute;

public enum FourthAttribute {
	first(100),
	second(150),
	third(200);

	private int num;

	FourthAttribute (int num) {
		this.num = num;
	}

	public int getNum ( ) {
		return num;
	}
}
