package com.company.pojo;

public class GridRow {

	private Integer p1;
	private Integer p2;
	private Double y;
	private Double f1;
	private Double f2;
	private Double e;

	public Integer getP1 ( ) {
		return p1;
	}

	public void setP1 (Integer p1) {
		this.p1 = p1;
	}

	public Integer getP2 ( ) {
		return p2;
	}

	public void setP2 (Integer p2) {
		this.p2 = p2;
	}

	public Double getY ( ) {
		return y;
	}

	public void setY (Double y) {
		this.y = y;
	}

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

	@Override
	public String toString ( ) {
		return "GridRow{" +
				"p1=" + p1 +
				", p2=" + p2 +
				", y=" + y +
				", f1=" + f1 +
				", f2=" + f2 +
				", e=" + e +
				'}';
	}
}
