package com.company.services;

import com.company.pojo.Entity;
import com.company.pojo.GridError;
import com.company.pojo.GridRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FillGrid {

	public ArrayList<GridRow> generateGrid (ArrayList<Entity> entities) {
		// F(x,y) = (cos((x^2+y^2)/20))/(1+(x^2+y^2)/100)
		ArrayList<GridRow> rows = new ArrayList<>();
		for (Entity entity : entities) {
			GridRow gr = new GridRow();
			gr.setEntity(entity);
			gr.setP1(entity.getThirdAttribute());
			gr.setP2(entity.getFifthAttribute());
			gr.setY((Math.cos(((entity.getThirdAttribute() ^ 2) + (entity.getFifthAttribute() ^ 2)) / 20.0)) /
					(1 + (((entity.getThirdAttribute() ^ 2) + (entity.getFifthAttribute() ^ 2)) / 100.0)));
			rows.add(gr);
		}
		return rows;
	}


	public ArrayList<GridError> generateGridError (ArrayList<GridRow> rows) {
		ArrayList<GridError> errors = new ArrayList<>();
		Collections.sort(rows, Comparator.comparing(r -> r.getEntity().getThirdAttribute()));
		for (int i = 0; i < rows.size(); i++) {
			if (i == 0 || !rows.get(i).getP1().equals(rows.get(i - 1).getP1())) {
				Integer f1count = 0;
				Integer f2count = 0;
				Double y1 = 0.0;
				Double y2 = 0.0;
				Double e1 = 0.0;
				Double e2 = 0.0;
				GridError ge = new GridError();
				for (GridRow gridRows : rows) {
					if (gridRows.getP1() <= rows.get(i).getP1()) {
						f1count++;
						y1 += gridRows.getY();
					} else {
						f2count++;
						y2 += gridRows.getY();
					}
				}
				if (f2count != 0) {
					ge.setF1(1.0 / f1count * y1);
					ge.setF2(1.0 / f2count * y2);
					for (GridRow row : rows) {
						if (row.getP1() <= rows.get(i).getP1()) {
							e1 += Math.pow(row.getY() - ge.getF1(), 2);
						} else {
							e2 += Math.pow(row.getY() - ge.getF2(), 2);
						}
					}
					ge.setE(e1 + e2);
					ge.setSeparator(rows.get(i).getP1());
					ge.setAttribute("thirdAttribute");
					ge.setDescription("ThirdAttribute <= " + rows.get(i).getP1());
					errors.add(ge);
				}
			}
		}

		Collections.sort(rows, Comparator.comparing(r -> r.getEntity().getFifthAttribute()));
		for (int i = 0; i < rows.size(); i++) {
			if (i == 0 || !rows.get(i).getP2().equals(rows.get(i - 1).getP2())) {
				Integer f1count = 0;
				Integer f2count = 0;
				Double y1 = 0.0;
				Double y2 = 0.0;
				Double e1 = 0.0;
				Double e2 = 0.0;
				GridError ge = new GridError();
				for (GridRow gridRows : rows) {
					if (gridRows.getP2() <= rows.get(i).getP2()) {
						f1count++;
						y1 += gridRows.getY();
					} else {
						f2count++;
						y2 += gridRows.getY();
					}
				}
				if (f2count != 0) {
					ge.setF1(1.0 / f1count * y1);
					ge.setF2(1.0 / f2count * y2);
					for (GridRow row : rows) {
						if (row.getP2() <= rows.get(i).getP2()) {
							e1 += Math.pow(row.getY() - ge.getF1(), 2);
						} else {
							e2 += Math.pow(row.getY() - ge.getF2(), 2);
						}
					}
					ge.setE(e1 + e2);
					ge.setSeparator(rows.get(i).getP2());
					ge.setAttribute("fifthAttribute");
					ge.setDescription("FifthAttribute <= " + rows.get(i).getP2());
					errors.add(ge);
				}
			}
		}
		return errors;
	}
}
