package com.company.services;

import com.company.pojo.Entity;
import com.company.pojo.GridRow;
import com.company.pojo.digitalAttribute.FifthAttributeInterface;
import com.company.pojo.digitalAttribute.ThirdAttributeInterface;
import com.company.pojo.enumAttribute.FirstAttribute;
import com.company.pojo.enumAttribute.FourthAttribute;
import com.company.pojo.enumAttribute.OutputAttribute;
import com.company.pojo.enumAttribute.SecondAttribute;

import java.util.ArrayList;
import java.util.Random;

public class EntityInitializer {

	private Random rand = new Random();
	private FirstAttribute[] first = FirstAttribute.values();
	private SecondAttribute[] second = SecondAttribute.values();
	private ThirdAttributeInterface third = new ThirdAttributeInterface();
	private FifthAttributeInterface fifth = new FifthAttributeInterface();
	private FourthAttribute[] fourth = FourthAttribute.values();
	private OutputAttribute[] output = OutputAttribute.values();

	public ArrayList<Entity> initEntities (Integer number) {
		ArrayList<Entity> entities = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			Entity entity = new Entity();
			entity.setNumber(i);
			entity.setFirstAttribute(first[rand.nextInt(first.length)]);
			entity.setSecondAttribute(second[rand.nextInt(second.length)]);
			entity.setThirdAttribute(rand.nextInt(third.getMax() + 1 - third.getMin()) + third.getMin());
			entity.setFourthAttribute(fourth[rand.nextInt(fourth.length)]);
			entity.setFifthAttribute(rand.nextInt(fifth.getMax() + 1 - fifth.getMin()) + fifth.getMin());
			entity.setOutputAttribute(output[rand.nextInt(output.length)]);

			entities.add(entity);
		}
		return entities;
	}

	public ArrayList<Entity> initRegressiveEntities (Integer number) {
		ArrayList<Entity> entities = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			Entity entity = new Entity();
			entity.setNumber(i);
			entity.setFirstAttribute(first[rand.nextInt(first.length)]);
			entity.setSecondAttribute(second[rand.nextInt(second.length)]);
			entity.setThirdAttribute((rand.nextInt(third.getMax() + 1 - third.getMin()) + third.getMin()) / 5 * 5);
			entity.setFourthAttribute(fourth[rand.nextInt(fourth.length)]);
			entity.setFifthAttribute((rand.nextInt(fifth.getMax() + 1 - fifth.getMin()) + fifth.getMin()) / 50 * 50);

			entities.add(entity);
		}
		return entities;
	}

	public ArrayList<GridRow> generateGrid ( ) {
		// F(x,y) = (cos((x^2+y^2)/20))/(1+(x^2+y^2)/100)
		ArrayList<GridRow> rows = new ArrayList<>();
		int min1 = third.getMin();
		int min2 = fifth.getMin();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 6; j++) {
				GridRow gr = new GridRow();
				gr.setP1(min1);
				gr.setP2(min2);
				gr.setY((Math.cos(((min1 ^ 2) + (min2 ^ 2)) / 20.0)) / (1 + (((min1 ^ 2) + (min2 ^ 2)) / 100.0)));
				rows.add(gr);
				min2 += 50;
			}
			min2 = fifth.getMin();
			min1 += 5;
		}

		return rows;
	}
}
