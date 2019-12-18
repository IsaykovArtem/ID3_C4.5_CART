package com.company.gui;

import com.company.StartLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartForm extends JFrame {
	private JButton startButton;
	private JCheckBox ID3CheckBox;
	private JCheckBox C45CheckBox;
	private JCheckBox CARTCheckBox;
	private JCheckBox regressiveCARTCheckBox;
	private JPanel startPanel;

	public StartForm ( ) {
		add(startPanel);
		setTitle("Добро пожаловать!");
		setSize(400, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				Boolean isID3 = ID3CheckBox.isSelected();
				Boolean isC45 = C45CheckBox.isSelected();
				Boolean isCART = CARTCheckBox.isSelected();
				Boolean isRegressiveCART = regressiveCARTCheckBox.isSelected();

				StartLogic startLogic = new StartLogic();
				startLogic.startBuildTrees(isID3, isC45, isCART, isRegressiveCART);
			}
		});
	}
}
