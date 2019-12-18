package com.company;

import com.company.gui.GuiTree;
import com.company.pojo.Entity;
import com.company.pojo.GridRow;
import com.company.services.EntityInitializer;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class StartLogic {

	public static void invokeGUI (ArrayList<ArrayList<DefaultMutableTreeNode>> hierarchyOfNodes, String algorithm, DefaultMutableTreeNode root) {
		new GuiTree(hierarchyOfNodes, algorithm).invokeGUI(root);
	}

	public void startBuildTrees (Boolean isID3, Boolean isC45, Boolean isCART, Boolean isRegressiveCART) {

		EntityInitializer entityInitializer = new EntityInitializer();
		ArrayList<Entity> entities = entityInitializer.initEntities(CustomIntegerAttributeInterface.NUMBER_OF_ENTITIES);
//		entities.forEach(entity -> System.out.println(entity.toString()));
		DefaultMutableTreeNode root;
		Integer steps1 = 0;
		Integer steps2 = 0;
		Integer steps3 = 0;
		Integer steps4 = 0;
		if (isID3) {
			root = new DefaultMutableTreeNode("ROOT");
			Controller controller = new Controller(entities, CustomIntegerAttributeInterface.algorithmID3, root);
			invokeGUI(controller.getHierarchyOfNodes(), CustomIntegerAttributeInterface.algorithmID3, root);
			steps1 = controller.getStepCounter();
		}
		if (isC45) {
			root = new DefaultMutableTreeNode("ROOT");
			Controller controller = new Controller(entities, CustomIntegerAttributeInterface.algorithmC45, root);
			invokeGUI(controller.getHierarchyOfNodes(), CustomIntegerAttributeInterface.algorithmC45, root);
			steps2 = controller.getStepCounter();
		}
		if (isCART) {
			root = new DefaultMutableTreeNode("ROOT");
			Controller controller = new Controller(entities, CustomIntegerAttributeInterface.algorithmCART, root);
			invokeGUI(controller.getHierarchyOfNodes(), CustomIntegerAttributeInterface.algorithmCART, root);
			steps3 = controller.getStepCounter();
		}
		if (isRegressiveCART) {
			root = new DefaultMutableTreeNode("ROOT");
			ArrayList<Entity> entitiesRegressive = entityInitializer.initRegressiveEntities(CustomIntegerAttributeInterface.NUMBER_OF_ENTITIES);
			entitiesRegressive.forEach(entity -> System.out.println(entity.toString()));
			ArrayList<GridRow> gridRows = entityInitializer.generateGrid();
			gridRows.forEach(row -> System.out.println(row.toString()));
//			Controller controller = new Controller(entities, CustomIntegerAttributeInterface.algorithmCART, root);
//			invokeGUI(controller.getHierarchyOfNodes(), CustomIntegerAttributeInterface.algorithmCART, root);
//			steps4 = controller.getStepCounter();
		}
		System.out.println("Шагов ID3 = " + steps1);
		System.out.println("Шагов C4.5 = " + steps2);
		System.out.println("Шагов CART = " + steps3);
		System.out.println("Шагов CART регрессионное дерево = " + steps4);

//		ArrayList<String> steps = controller.getSteps();
//		for (String step : steps) {
//			System.out.println(step);
//		}
	}
}
