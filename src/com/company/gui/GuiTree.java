package com.company.gui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class GuiTree extends JFrame {

	private ArrayList<ArrayList<DefaultMutableTreeNode>> hierarchyOfNodes;
	private String algorithm;
	private JTree tree;


	public GuiTree (ArrayList<ArrayList<DefaultMutableTreeNode>> hierarchyOfNodes, String algorithm) {
		this.algorithm = algorithm;
		this.hierarchyOfNodes = hierarchyOfNodes;
	}


	public void invokeGUI (DefaultMutableTreeNode root) {
		for (ArrayList<DefaultMutableTreeNode> parentChildren : hierarchyOfNodes) {
			parentChildren.get(0).add(parentChildren.get(1));
		}
		this.setTitle(algorithm);
		tree = new JTree(root);
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		add(tree);
		this.add(new JScrollPane(tree));

		this.setSize(700, 700);
		this.setVisible(true);
	}
}