package com.company;

import com.company.pojo.Entity;
import com.company.pojo.GridRow;
import com.company.pojo.digitalAttribute.FifthAttributeInterface;
import com.company.pojo.digitalAttribute.ThirdAttributeInterface;
import com.company.services.Helper;
import com.company.services.SplittingService;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RegressiveController {

	private Integer stepCounter = 0;
	private SplittingService splittingService = new SplittingService();
	private Helper helper = new Helper();

	private CustomIntegerAttributeInterface thirdAttribute = new ThirdAttributeInterface();
	private CustomIntegerAttributeInterface fifthAttribute = new FifthAttributeInterface();

	private ArrayList<String> steps = new ArrayList<>();

	private ArrayList<ArrayList<DefaultMutableTreeNode>> hierarchyOfNodes = new ArrayList<>();

	public RegressiveController (ArrayList<Entity> entities, ArrayList<GridRow> rows, DefaultMutableTreeNode root) {
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

		if (entities.size() != 1) {

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
