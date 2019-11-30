package com.company.pojo.digitalAttribute;

import com.company.CustomIntegerAttributeInterface;

public class ThirdAttributeInterface implements CustomIntegerAttributeInterface {
	private Integer min = 50;
	private Integer max = 95;

	public Integer getMin ( ) {
		return min;
	}

	public Integer getMax ( ) {
		return max;
	}

}
