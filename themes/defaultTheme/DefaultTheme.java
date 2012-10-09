package Jet.themes.defaultTheme;

import java.awt.Component;
import java.awt.Container;

import Jet.JetSys;
import Jet.JetSys.HookProcessTpl;
import Jet.JetSys.Themeable;
import Jet.Module;
import Jet.JetSys.HookEnabled;
import Jet.TplVars;
import Jet.themes.defaultTheme.templates.DefaultContent;
import Jet.themes.defaultTheme.templates.DefaultHeader;
import Jet.themes.defaultTheme.templates.PageTpl;

public class DefaultTheme extends Module implements HookEnabled,
													Themeable,
													HookProcessTpl{

	private DefaultFrame frame;
	
	/**
	 * {@link #frame}'s contentPane
	 */
	private Container pane;
	
	private Component header, content, sidebarLeft, sidebarRight;
	
	private View view;
	
	public static String NAME = "defaultTheme";
	
	public DefaultTheme(String name){
		super(name);
		syst.addHookEnabledListener(this);
		
		syst.addHookProcessTpl(syst.constructTplHookName(PageTpl.NAME, NAME), this);
	}
	
	/**
	 * Implements {@link JetSys#hookEnabled()}
	 */
	@Override
	public void hookEnabled() {
		System.out.println("in hook");
		syst.setActiveTheme(this);
		
		view = new View(this);
	}
	
	/**
	 * Jet requires this function to make sure we have a frame at the minimum.
	 */
	@Override
	public void themeMainFrame() {
		frame = new DefaultFrame();
		
		pane = frame.getContentPane();
		
		/**
		 * Pass this module to give it the chance to add default values 
		 * to the TplVars vars hashmap
		 */
		syst.render(new PageTpl(pane), this);
		
		frame.showThis();
//		frame.getcon
	}

	/**
	 * Implements {@link HookProcessTpl}
	 */
	@Override
	public TplVars hookProcessTpl(String hookName, TplVars vars) {
		syst.echo(hookName  + " is invoked");
		if(!vars.containsKey("header")){
			vars.put("header", new DefaultHeader());
		}
		if(!vars.containsKey("content")){
			vars.put("content", new DefaultContent());
		}
		syst.echo(vars.toString());
		
		return null;
	}

	public Component getHeader() {
		return header;
	}

	public void setHeader(Component header) {
		this.header = header;
	}

	public Component getContent() {
		return content;
	}

	public void setContent(Component content) {
		this.content = content;
	}

	public Component getSidebarLeft() {
		return sidebarLeft;
	}

	public void setSidebarLeft(Component sidebarLeft) {
		this.sidebarLeft = sidebarLeft;
	}

	public Component getSidebarRight() {
		return sidebarRight;
	}

	public void setSidebarRight(Component sidebarRight) {
		this.sidebarRight = sidebarRight;
	}
	
//	public interface 
	
	
}
