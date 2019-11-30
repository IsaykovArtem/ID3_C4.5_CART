package com.company;

import com.company.pojo.Entity;
import com.company.pojo.digitalAttribute.FifthAttributeInterface;
import com.company.pojo.digitalAttribute.ThirdAttributeInterface;
import com.company.services.Helper;
import com.company.services.SplittingService;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Controller {

	private Integer stepCounter = 0;
	private SplittingService splittingService = new SplittingService();
	private Helper helper = new Helper();

	private CustomIntegerAttributeInterface thirdAttribute = new ThirdAttributeInterface();
	private CustomIntegerAttributeInterface fifthAttribute = new FifthAttributeInterface();
	private String algorithm;
	private DefaultMutableTreeNode root;

	private ArrayList<String> steps = new ArrayList<>();

	private ArrayList<ArrayList<DefaultMutableTreeNode>> hierarchyOfNodes = new ArrayList<>();

	public Controller (ArrayList<Entity> entities, String algorithm, DefaultMutableTreeNode root) {
		this.algorithm = algorithm;
		this.root = root;
		recursiveLoop(root, entities);
	}

	public ArrayList<String> getSteps ( ) {
		return steps;
	}

	public Integer getStepCounter ( ) {
		return stepCounter;
	}

	public ArrayList<ArrayList<DefaultMutableTreeNode>> getHierarchyOfNodes ( ) {
		return hierarchyOfNodes;
	}

	private void recursiveLoop (DefaultMutableTreeNode father, ArrayList<Entity> entities) {

		if (!helper.isOnlySingleClass(entities)) {
			DefaultMutableTreeNode newFather;
			stepCounter++;

			ArrayList<ArrayList<Entity>>[] lists = null;
			Double[] gainS = null;

			switch (algorithm) {
				case CustomIntegerAttributeInterface.algorithmID3:
					lists = splittingService.listsOfEntityInitializer(entities);
					gainS = helper.listsOfGainSInitializer(entities, lists);
					break;
				case CustomIntegerAttributeInterface.algorithmC45:
					lists = splittingService.listsOfEntityInitializer(entities);
					gainS = helper.listsOfGainRatioSInitializer(entities, lists);
					break;
				case CustomIntegerAttributeInterface.algorithmCART:
					lists = splittingService.listsOfEntityInitializerBinary(entities);
					gainS = helper.listsOfCARTGeneralIndicators(entities, lists);
					break;
			}

			Integer index;
			try {
				index = helper.findMaxInformationGain(gainS);
			} catch (Exception e) {
				boolean isAllEquals = true;
				Entity entityFirst = entities.get(0);
				for (Entity entity : entities) {
					if (!entity.equals(entityFirst)) {
						isAllEquals = false;
						break;
					}
				}
				if (isAllEquals) {
					hierarchyOfNodes.add(new ArrayList<>(Arrays.asList(father, new DefaultMutableTreeNode(entities.toString()))));
					System.out.println("WARNING! ALL ENTITIES ARE EQUALS!");
					System.out.println(entities.toString());
					System.out.println("WARNING!");
					return;
				} else {
					Random rand = new Random();
					if (rand.nextBoolean()) {
						index = 1;
					} else index = 4;
				}
			}
			System.out.println("Max - " + (index + 1) + " attribute");
			System.out.println("________________________________");

			if (algorithm.equals(CustomIntegerAttributeInterface.algorithmCART)) {
				newFather = this.indexSwitcherBinary(index, father, entities);
			} else {
				newFather = this.indexSwitcher(index, father, entities);
			}

			for (ArrayList<Entity> list : lists[index]) {
				if (!list.isEmpty()) {
					recursiveLoop(newFather, list);
				}
			}
		} else {
			hierarchyOfNodes.add(new ArrayList<>(Arrays.asList(father, new DefaultMutableTreeNode(entities.toString()))));
		}
	}

	private DefaultMutableTreeNode indexSwitcher (Integer index, DefaultMutableTreeNode father, ArrayList<Entity> entities) {
		String str = "";
		switch (index) {
			case 0:
				str = "Attribute " + (index + 1) + ". ( стрелок (1-5) )";
				break;
			case 1:
				str = "Attribute " + (index + 1) + ". ( нарезной, гладкий )";
				break;
			case 2:
				str = "Attribute " + (index + 1) + ". ( [50, 95] middle ) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, thirdAttribute, 2);
				break;
			case 3:
				str = "Attribute " + (index + 1) + ". ( {100, 150, 200} )";
				break;
			case 4:
				str = "Attribute " + (index + 1) + ". ( [500, 800] middle ) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, fifthAttribute, 2);
				break;
			case 5:
				str = "Attribute 3. ( [50, 95] left less) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, thirdAttribute, 1);
				break;
			case 6:
				str = "Attribute 3. ( [50, 95] left more) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, thirdAttribute, 3);
				break;
			case 7:
				str = "Attribute 5. ( [500, 800] left less) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, fifthAttribute, 1);
				break;
			case 8:
				str = "Attribute 5. ( [500, 800] left more) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, fifthAttribute, 3);
				break;
		}
		DefaultMutableTreeNode newFather = new DefaultMutableTreeNode(str);
		str = "" + "Step: " + stepCounter + ". " + str;
		steps.add(str);
		hierarchyOfNodes.add(new ArrayList<>(Arrays.asList(father, newFather)));
		return newFather;
	}

	private DefaultMutableTreeNode indexSwitcherBinary (Integer index, DefaultMutableTreeNode father, ArrayList<Entity> entities) {
		String str = "";
		switch (index) {
			case 0:
				str = "Attribute 3. ( [50, 95] left less) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, thirdAttribute, 1);
				break;
			case 1:
				str = "Attribute 3. ( [50, 95] middle ) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, thirdAttribute, 2);
				break;
			case 2:
				str = "Attribute 3. ( [50, 95] left more) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, thirdAttribute, 3);
				break;
			case 3:
				str = "Attribute 5. ( [500, 800] left less) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, fifthAttribute, 1);
				break;
			case 4:
				str = "Attribute 5. ( [500, 800] middle) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, fifthAttribute, 2);
				break;
			case 5:
				str = "Attribute 5. ( [500, 800] left more) Separator = " + splittingService.getSeparatorValueFromIntegerAttribute(entities, fifthAttribute, 3);
				break;
			case 6:
				str = "Attribute 1. ( стрелок 1 )";
				break;
			case 7:
				str = "Attribute 1. ( стрелок 2 )";
				break;
			case 8:
				str = "Attribute 1. ( стрелок 3 )";
				break;
			case 9:
				str = "Attribute 1. ( стрелок 4 )";
				break;
			case 10:
				str = "Attribute 1. ( стрелок 5 )";
				break;
			case 11:
				str = "Attribute 2. ( нарезной )";
				break;
			case 12:
				str = "Attribute 2. ( гладкий )";
				break;
			case 13:
				str = "Attribute 4. ( 100 )";
				break;
			case 14:
				str = "Attribute 4. ( 150 )";
				break;
			case 15:
				str = "Attribute 4. ( 200 )";
				break;
		}
		DefaultMutableTreeNode newFather = new DefaultMutableTreeNode(str);
		str = "" + "Step: " + stepCounter + ". " + str;
		steps.add(str);
		hierarchyOfNodes.add(new ArrayList<>(Arrays.asList(father, newFather)));
		return newFather;
	}
}
