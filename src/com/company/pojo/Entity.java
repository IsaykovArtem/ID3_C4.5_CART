package com.company.pojo;

import com.company.pojo.enumAttribute.FirstAttribute;
import com.company.pojo.enumAttribute.FourthAttribute;
import com.company.pojo.enumAttribute.OutputAttribute;
import com.company.pojo.enumAttribute.SecondAttribute;

import java.util.Objects;

public class Entity {

	private int number;
	private FirstAttribute firstAttribute;
	private SecondAttribute secondAttribute;
	private Integer thirdAttribute;
	private FourthAttribute fourthAttribute;
	private Integer fifthAttribute;
	private OutputAttribute outputAttribute;

	public Integer getNumber ( ) {
		return number;
	}

	public void setNumber (Integer number) {
		this.number = number;
	}

	public FirstAttribute getFirstAttribute ( ) {
		return firstAttribute;
	}

	public void setFirstAttribute (FirstAttribute firstAttribute) {
		this.firstAttribute = firstAttribute;
	}

	public SecondAttribute getSecondAttribute ( ) {
		return secondAttribute;
	}

	public void setSecondAttribute (SecondAttribute secondAttribute) {
		this.secondAttribute = secondAttribute;
	}

	public Integer getThirdAttribute ( ) {
		return thirdAttribute;
	}

	public void setThirdAttribute (Integer thirdAttribute) {
		this.thirdAttribute = thirdAttribute;
	}

	public FourthAttribute getFourthAttribute ( ) {
		return fourthAttribute;
	}

	public void setFourthAttribute (FourthAttribute fourthAttribute) {
		this.fourthAttribute = fourthAttribute;
	}

	public Integer getFifthAttribute ( ) {
		return fifthAttribute;
	}

	public void setFifthAttribute (Integer fifthAttribute) {
		this.fifthAttribute = fifthAttribute;
	}

	public OutputAttribute getOutputAttribute ( ) {
		return outputAttribute;
	}

	public void setOutputAttribute (OutputAttribute outputAttribute) {
		this.outputAttribute = outputAttribute;
	}

	@Override
	public String toString ( ) {
		return "Entity{" +
				"number=" + number +
				", firstAttribute=" + firstAttribute +
				", secondAttribute=" + secondAttribute +
				", thirdAttribute=" + thirdAttribute +
				", fourthAttribute=" + fourthAttribute.getNum() +
				", fifthAttribute=" + fifthAttribute +
				", outputAttribute=" + outputAttribute +
				'}';
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entity entity = (Entity) o;
		return firstAttribute == entity.firstAttribute &&
				secondAttribute == entity.secondAttribute &&
				thirdAttribute.equals(entity.thirdAttribute) &&
				fourthAttribute == entity.fourthAttribute &&
				fifthAttribute.equals(entity.fifthAttribute);
	}

	@Override
	public int hashCode ( ) {
		return Objects.hash(firstAttribute, secondAttribute, thirdAttribute, fourthAttribute, fifthAttribute);
	}
}
