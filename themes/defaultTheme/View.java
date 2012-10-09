package Jet.themes.defaultTheme;

import Jet.Module;

public class View {

	private Controller controller ;
	
	public View(Module module){
		controller = new Controller(module, this);
	}
}
