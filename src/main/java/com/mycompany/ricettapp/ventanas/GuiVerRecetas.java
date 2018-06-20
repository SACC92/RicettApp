package com.mycompany.ricettapp.ventanas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class GuiVerRecetas extends JFrame {	
	
	private PanelJlist panelList;
	
	public GuiVerRecetas(String title) throws HeadlessException {
		
                super(title);
		this.panelList = new PanelJlist();
		this.setContentPane(panelList);
		
		
		this.setLocationRelativeTo(null);
		this.setSize(550, 550);
                setResizable(false);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
                
                
                
                
                
	}



}
