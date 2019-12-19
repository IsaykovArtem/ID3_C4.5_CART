package com.company.pojo;

public class GridError {

	private String description;
	private String attribute;
	private Integer separator;
	private Double f1;
	private Double f2;
	private Double e;

	public Double getF1 ( ) {
		return f1;
	}

	public void setF1 (Double f1) {
		this.f1 = f1;
	}

	public Double getF2 ( ) {
		return f2;
	}

	public void setF2 (Double f2) {
		this.f2 = f2;
	}

	public Double getE ( ) {
		return e;
	}

	public void setE (Double e) {
		this.e = e;
	}

	public String getAttribute ( ) {
		return attribute;
	}

	public void setAttribute (String attribute) {
		this.attribute = attribute;
	}

	public Integer getSeparator ( ) {
		return separator;
	}

	public void setSeparator (Integer separator) {
		this.separator = separator;
	}

	public String getDescription ( ) {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	@Override
	public String toString ( ) {
		return "GridError{" +
				"description='" + description + '\'' +
				", attribute='" + attribute + '\'' +
				", separator=" + separator +
				", f1=" + f1 +
				", f2=" + f2 +
				", e=" + e +
				'}';
	}
}
