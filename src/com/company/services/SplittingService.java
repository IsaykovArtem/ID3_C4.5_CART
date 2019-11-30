package com.company.services;

import com.company.CustomIntegerAttributeInterface;
import com.company.pojo.Entity;
import com.company.pojo.digitalAttribute.FifthAttributeInterface;
import com.company.pojo.digitalAttribute.ThirdAttributeInterface;
import com.company.pojo.enumAttribute.FirstAttribute;
import com.company.pojo.enumAttribute.FourthAttribute;
import com.company.pojo.enumAttribute.SecondAttribute;

import java.util.ArrayList;

public class SplittingService {

	private CustomIntegerAttributeInterface thirdAttribute = new ThirdAttributeInterface();
	private CustomIntegerAttributeInterface fifthAttribute = new FifthAttributeInterface();

	public ArrayList<ArrayList<Entity>>[] listsOfEntityInitializer (ArrayList<Entity> entities) {
		ArrayList<ArrayList<Entity>>[] arrayLists = new ArrayList[9];
		arrayLists[0] = this.splittingListByFirstAttribute(entities);
		arrayLists[1] = this.splittingListBySecondAttribute(entities);
		arrayLists[2] = this.splittingListByIntegerAttribute(entities, thirdAttribute, 2);
		arrayLists[3] = this.splittingListByFourthAttribute(entities);
		arrayLists[4] = this.splittingListByIntegerAttribute(entities, fifthAttribute, 2);
		arrayLists[5] = this.splittingListByIntegerAttribute(entities, thirdAttribute, 1);
		arrayLists[6] = this.splittingListByIntegerAttribute(entities, thirdAttribute, 3);
		arrayLists[7] = this.splittingListByIntegerAttribute(entities, fifthAttribute, 1);
		arrayLists[8] = this.splittingListByIntegerAttribute(entities, fifthAttribute, 3);
		return arrayLists;
	}

	public ArrayList<ArrayList<Entity>>[] listsOfEntityInitializerBinary (ArrayList<Entity> entities) {
		int arraySize = FirstAttribute.values().length +
				SecondAttribute.values().length +
				3 + // Third attribute (left, middle, right)
				FourthAttribute.values().length +
				3;  // Fifth attribute (left, middle, right)
		ArrayList<ArrayList<Entity>>[] arrayLists = new ArrayList[arraySize];
		arrayLists[0] = this.splittingListByIntegerAttribute(entities, thirdAttribute, 1);
		arrayLists[1] = this.splittingListByIntegerAttribute(entities, thirdAttribute, 2);
		arrayLists[2] = this.splittingListByIntegerAttribute(entities, thirdAttribute, 3);
		arrayLists[3] = this.splittingListByIntegerAttribute(entities, fifthAttribute, 1);
		arrayLists[4] = this.splittingListByIntegerAttribute(entities, fifthAttribute, 2);
		arrayLists[5] = this.splittingListByIntegerAttribute(entities, fifthAttribute, 3);
		int i = 6;
		for (FirstAttribute first : FirstAttribute.values()) {
			arrayLists[i] = this.splittingListByFirstAttributeBinary(entities, first);
			i++;
		}
		for (SecondAttribute second : SecondAttribute.values()) {
			arrayLists[i] = this.splittingListBySecondAttributeBinary(entities, second);
			i++;
		}
		for (FourthAttribute fourth : FourthAttribute.values()) {
			arrayLists[i] = this.splittingListByFourthAttributeBinary(entities, fourth);
			i++;
		}
		return arrayLists;
	}

	private ArrayList<ArrayList<Entity>> splittingListByFirstAttribute (ArrayList<Entity> entities) {
		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();
		for (int i = 0; i < FirstAttribute.values().length; i++) {
			listOfGroupEntities.add(i, new ArrayList<>());
		}
		for (Entity entity : entities) {
			switch (entity.getFirstAttribute()) {
				case стрелок1:
					listOfGroupEntities.get(0).add(entity);
					break;
				case стрелок2:
					listOfGroupEntities.get(1).add(entity);
					break;
				case стрелок3:
					listOfGroupEntities.get(2).add(entity);
					break;
				case стрелок4:
					listOfGroupEntities.get(3).add(entity);
					break;
				case стрелок5:
					listOfGroupEntities.get(4).add(entity);
					break;
			}
		}
//		System.out.println("Split by 1st attribute");
//		for (ArrayList list: listOfGroupEntitise) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}

	private ArrayList<ArrayList<Entity>> splittingListBySecondAttribute (ArrayList<Entity> entities) {
		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();
		for (int i = 0; i < SecondAttribute.values().length; i++) {
			listOfGroupEntities.add(i, new ArrayList<>());
		}
		for (Entity entity : entities) {
			switch (entity.getSecondAttribute()) {
				case нарезной:
					listOfGroupEntities.get(0).add(entity);
					break;
				case гладкий:
					listOfGroupEntities.get(1).add(entity);
					break;
			}
		}
//		System.out.println("Split by 2nd attribute");
//		for (ArrayList list: listOfGroupEntities) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}

	private ArrayList<ArrayList<Entity>> splittingListByIntegerAttribute (ArrayList<Entity> entities, CustomIntegerAttributeInterface customIntegerAttributeInterface, Integer part) {
		Integer separator = getSeparatorValueFromIntegerAttribute(entities, customIntegerAttributeInterface, part);

		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();
		listOfGroupEntities.add(new ArrayList<>());
		listOfGroupEntities.add(new ArrayList<>());

		if (ThirdAttributeInterface.class.equals(customIntegerAttributeInterface.getClass())) {
			for (Entity entity : entities) {
				if (entity.getThirdAttribute() <= separator) {
					listOfGroupEntities.get(0).add(entity);
				} else listOfGroupEntities.get(1).add(entity);
			}
		} else if (FifthAttributeInterface.class.equals(customIntegerAttributeInterface.getClass())) {
			for (Entity entity : entities) {
				if (entity.getFifthAttribute() <= separator) {
					listOfGroupEntities.get(0).add(entity);
				} else listOfGroupEntities.get(1).add(entity);
			}
		}
//		for (ArrayList list: listOfGroupEntities) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}

	private ArrayList<ArrayList<Entity>> splittingListByFourthAttribute (ArrayList<Entity> entities) {
		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();
		for (int i = 0; i < FourthAttribute.values().length; i++) {
			listOfGroupEntities.add(i, new ArrayList<>());
		}
		for (Entity entity : entities) {
			switch (entity.getFourthAttribute()) {
				case first:
					listOfGroupEntities.get(0).add(entity);
					break;
				case second:
					listOfGroupEntities.get(1).add(entity);
					break;
				case third:
					listOfGroupEntities.get(2).add(entity);
					break;
			}
		}
//		System.out.println("Split by 4th attribute");
//		for (ArrayList list: listOfGroupEntities) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}

	public Integer getSeparatorValueFromIntegerAttribute (ArrayList<Entity> entities, CustomIntegerAttributeInterface customIntegerAttributeInterface, Integer part) {
		Integer sum = 0;
		if (ThirdAttributeInterface.class.equals(customIntegerAttributeInterface.getClass())) {
			for (Entity entity : entities) {
				sum += entity.getThirdAttribute();
			}
		} else if (FifthAttributeInterface.class.equals(customIntegerAttributeInterface.getClass())) {
			for (Entity entity : entities) {
				sum += entity.getFifthAttribute();
			}
		}
		switch (part) {
			case 1:
				return (int) ((sum / entities.size()) / 1.2);
			case 3:
				return (int) ((sum / entities.size()) * 1.2);
			case 2:
			default:
				return sum / entities.size();

		}
	}

	private ArrayList<ArrayList<Entity>> splittingListByFirstAttributeBinary (ArrayList<Entity> entities, FirstAttribute firstAttribute) {
		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();

		listOfGroupEntities.add(0, new ArrayList<>());
		listOfGroupEntities.add(1, new ArrayList<>());

		for (Entity entity : entities) {
			if (entity.getFirstAttribute().equals(firstAttribute)) {
				listOfGroupEntities.get(0).add(entity);
			} else {
				listOfGroupEntities.get(1).add(entity);
			}
		}
//		System.out.println("Split by 1st attribute ^ " + firstAttribute.toString());
//		for (ArrayList list: listOfGroupEntities) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}

	private ArrayList<ArrayList<Entity>> splittingListBySecondAttributeBinary (ArrayList<Entity> entities, SecondAttribute secondAttribute) {
		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();

		listOfGroupEntities.add(0, new ArrayList<>());
		listOfGroupEntities.add(1, new ArrayList<>());

		for (Entity entity : entities) {
			if (entity.getSecondAttribute().equals(secondAttribute)) {
				listOfGroupEntities.get(0).add(entity);
			} else {
				listOfGroupEntities.get(1).add(entity);
			}
		}
//		System.out.println("Split by 2nd attribute ^ " + secondAttribute.toString());
//		for (ArrayList list: listOfGroupEntities) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}

	private ArrayList<ArrayList<Entity>> splittingListByFourthAttributeBinary (ArrayList<Entity> entities, FourthAttribute fourthAttribute) {
		ArrayList<ArrayList<Entity>> listOfGroupEntities = new ArrayList<>();

		listOfGroupEntities.add(0, new ArrayList<>());
		listOfGroupEntities.add(1, new ArrayList<>());

		for (Entity entity : entities) {
			if (entity.getFourthAttribute().equals(fourthAttribute)) {
				listOfGroupEntities.get(0).add(entity);
			} else {
				listOfGroupEntities.get(1).add(entity);
			}
		}
//		System.out.println("Split by 4th attribute ^ " + fourthAttribute.toString());
//		for (ArrayList list: listOfGroupEntities) {
//			System.out.println("NEW LIST!!!!");
//			list.forEach(entity -> System.out.println(entity.toString()));
//		}
		return listOfGroupEntities;
	}
}
