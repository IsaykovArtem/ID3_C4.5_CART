package com.company.pojo.digitalAttribute;

import com.company.CustomIntegerAttributeInterface;

public class FifthAttributeInterface implements CustomIntegerAttributeInterface {
	private Integer min = 500;
	private Integer max = 800;

	public Integer getMin ( ) {
		return min;
	}

	public Integer getMax ( ) {
		return max;
	}

}
