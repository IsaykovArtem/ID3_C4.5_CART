package com.company.pojo;

public class GridRow {

	private Entity entity;
	private Integer p1;
	private Integer p2;
	private Double y;

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

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

	@Override
	public String toString() {
		return "GridRow{" +
				"entity=" + entity.toString() +
				", p1=" + p1 +
				", p2=" + p2 +
				", y=" + y +
				'}';
	}
}
