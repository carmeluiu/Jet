package Jet.themes.defaultTheme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Jet.Module;

public class Controller implements ActionListener{

	private Module module;
	
	private View view;
	
	public Controller(DefaultTheme module){
		this.module = module;
	}
	
	public Controller(Module module, View view) {
		this.module = module;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
