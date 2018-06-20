package com.mycompany.ricettapp.ventanas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class GuiRecetas extends JFrame {	
	
	private PanelJlist panelList;
	
	public GuiRecetas(String title) throws HeadlessException {
		super(title);
		this.panelList = new PanelJlist();
		this.setContentPane(panelList);
		
		
		this.setLocationRelativeTo(null);
		this.setSize(550, 550);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());

		this.setVisible(true);
	}



}
