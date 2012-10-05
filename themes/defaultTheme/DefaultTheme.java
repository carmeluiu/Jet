package Jet.themes.defaultTheme;

import java.awt.Container;

import Jet.JetSys.Themeable;
import Jet.Module;
import Jet.JetSys.HookEnabled;

public class DefaultTheme extends Module implements HookEnabled,
													Themeable{

	private DefaultFrame frame;
	
	/**
	 * {@link #frame}'s contentPane
	 */
	private Container pane;
	
	public static String NAME = "defaultTheme";
	public DefaultTheme(String name){
		super(name);
		syst.addHookEnabledListener(this);
	}
	@Override
	public void hookEnabled() {
		System.out.println("in hook");
		syst.setActiveTheme(this);
	}
	@Override
	public void themeMainFrame() {
		frame = new DefaultFrame();
		
		pane = frame.getContentPane();
		
		
		
		frame.showThis();
//		frame.getcon
	}
}
