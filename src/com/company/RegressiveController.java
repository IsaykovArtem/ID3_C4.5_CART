package com.company;

import com.company.pojo.Entity;
import com.company.pojo.GridError;
import com.company.pojo.GridRow;
import com.company.services.FillGrid;
import com.company.services.Helper;
import com.company.services.SplittingService;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Arrays;

public class RegressiveController {

	private Integer stepCounter = 0;
	private SplittingService splittingService = new SplittingService();
	private Helper helper = new Helper();
	private FillGrid fillGrid = new FillGrid();

	private ArrayList<String> steps = new ArrayList<>();

	private ArrayList<ArrayList<DefaultMutableTreeNode>> hierarchyOfNodes = new ArrayList<>();

	public RegressiveController (ArrayList<Entity> entities, DefaultMutableTreeNode root) {
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
			DefaultMutableTreeNode newFather;
			stepCounter++;

			ArrayList<GridRow> gridRows = fillGrid.generateGrid(entities);
			ArrayList<GridError> errors = fillGrid.generateGridError(gridRows);
			Integer index = helper.getSmallerError(errors);
			ArrayList<ArrayList<Entity>> lists = splittingService.regressiveSplitting(entities, errors.get(index));
			newFather = this.getNewDefaultMutableTreeNode(father, errors.get(index));
			for (ArrayList listOfEntities : lists) {
				recursiveLoop(newFather, listOfEntities);
			}
		} else {
			String str = "";
			for (Entity entity : entities) {
				str += entity.toStringShort();
			}
			hierarchyOfNodes.add(new ArrayList<>(Arrays.asList(father, new DefaultMutableTreeNode(str))));
		}
	}

	private DefaultMutableTreeNode getNewDefaultMutableTreeNode (DefaultMutableTreeNode father, GridError smallerError) {

		String str = smallerError.getDescription();
		DefaultMutableTreeNode newFather = new DefaultMutableTreeNode(str);
		str = "" + "Step: " + stepCounter + ". " + str;
		steps.add(str);
		hierarchyOfNodes.add(new ArrayList<>(Arrays.asList(father, newFather)));
		return newFather;
	}

}
