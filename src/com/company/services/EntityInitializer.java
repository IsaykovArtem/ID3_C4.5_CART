package com.company.services;

import com.company.pojo.Entity;
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
}
