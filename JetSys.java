    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;


import java.awt.Component;
import java.awt.Container;
import java.util.Collection;

import Jet.Modules.context.Context;
import Jet.themes.defaultTheme.DefaultTheme;

//import duiu.com.core.jetModules.dTheme.DTheme;
//import duiu.com.core.jetModules.mgmnt.Mgmnt;
//import duiu.com.core.jetModules.tst.Tst;



/**
 *
 */
public class JetSys {
    
	protected HookListenerList listenerlist = new HookListenerList();
	
    /**
     * 
     */
    private ModuleList moduleList;
    
    /**
     * 
     */
    private HookList hookList;
    
    private Themeable activeTheme;
    
    private String tplHookName = "HookProcessTpl";
    
    /**
     * Main Jet System Object
     */
    public JetSys() { 
        moduleList = new ModuleList();
        hookList = new HookList();
    }
    
    public void bootstrap() throws Exception {
    	Module.syst = this;
    	
        initModules();

        if(activeTheme == null) {
        	throw new Exception("No Active Theme provided");
        }
    	((Themeable)activeTheme).themeMainFrame();
    }
    
    /**
     * 
     * @param module 
     */
    public void addModule(Module module) {
        moduleList.put(module.getName(), module);
        hookList.put(module.getName(), module.implementedHooks());
        module.setSys(this);
        
    }
    
    /**
     * 
     */
    public final void initModules() {
    	
    	// add Jet's required modules
    	addModule(new Context(Context.NAME));
    	
    	// enable Jet's required modules
    	enableModules(new String[] {Context.NAME});
    	
    	addModule(new DefaultTheme(DefaultTheme.NAME));
//    	addModule(new DTheme(DTheme.NAME));
//    	addModule(new Mgmnt(Mgmnt.NAME));
//    	addModule(new Tst(Tst.NAME));
    	
    	enableModules(new String[] {DefaultTheme.NAME});//});//
    	
    }
    
    public void addDefaultModules() {
    	
    }

    public void enableModules(String[] modules) {
    	for(String name: modules) {
    		Module m = getModule(name);
    		m.setEnabled(true);
    		hookEnabled(m);
    	}
    }
    
    /**
     * 
     * @param name
     *   String Module's name
     * @return 
     *   Module The module.
     */
    public Module getModule(String name){
        return moduleList.get(name);
    }
    
    /**
     * Tell {@link #JetSys()} to render a {@link #Jet.JetTpl}
     * @param template
     * @param implementingModule
     * @return
     */
    public Component render(JetTpl template, Module implementingModule) {
    	TplVars vars = new TplVars();
    	String hookName = constructTplHookName(template.getName(), implementingModule.getName());
    	
    	// Let implementing module add its default vars first.
    	if(listenerlist.isModuleImplementingHook(hookName, implementingModule)){
    		((HookProcessTpl)implementingModule).hookProcessTpl(hookName, vars);
    	}
    	
    	// Let other implementing modules add their vars to the template.
    	hookProcessTpl(hookName, implementingModule, vars);
    	
    	
    	
    	return template.render(vars);
    }
    
    /**
     * Construct the name of a tplHook.
     * tplHook is the hook name to register with 
     * {@link #addHookProcessTpl(String, Module)}. This hook-name, like any other
     * hook-name must be unique. 
     * The uniqueness of this hook-name is achieved by using the 
     * <code>moduleName</code> in the string.
     * 
     * @param tplName
     *   The Template name.
     *   Use {<code>tplName</code>Tpl} as the structure of the name of the class that 
     *   implements this template.
     * @param moduleName
     *   The name of a module.
     *   This is what makes the hook name unique. By concatenating the tplName 
     *   (which can be any string) followed by a '_' and the moduleName (which
     *   must be unique).
     * @return
     *   The hook name.
     */
    public String constructTplHookName(String tplName, String moduleName) {
    	return tplHookName + "_" + tplName + "_" + moduleName;
    }
    
    
    
    /**
     * Get the active theme.<br>
     * 
     * The {@link #activeTheme} is the module that controls the rendering of 
     * the current menu item
     * 
     * @return
     *   The active <code>Themeable<code/> {@link #Module}.
     */
    public Themeable getActiveTheme() {
		return activeTheme;
	}

	public void setActiveTheme(Themeable activeTheme) {
		this.activeTheme = activeTheme;
	}
	
	public void echo(String msg) {
		System.out.println(msg);
	}

	//  =================== HOOK LISTENERS =========================
	/**
	 * Add a hook listener for {@link #hookEnabled(Module)}
	 * 
	 * @param m
	 *   The module that runs this hook.
	 */
    public void addHookModuleEnabledListener(Module m) {
    	listenerlist.add("moduleEnabled", m);
    }
    

    /**
     * Add a hook listener for hookEnabled.
     * 
     * @param m
     *   The module that runs this hook.
     */
    public void addHookEnabledListener(Module m) {
    	listenerlist.add("hookEnabled", m);
    }
    
    /**
     * Use {@link #addHookProcessTpl(String, Module)} instead
     * @param hookName
     * @param declaringHookModule
     * @param implementingModule
     */
    public void addHookProcessTpl(String hookName, Module declaringHookModule, Module implementingModule) {
    	
    	String hook = constructTplHookName(hookName, declaringHookModule.getName());
    	listenerlist.add(hook, implementingModule);
    }
    
    /**
     * Add a hook listener for {@link #hookProcessTpl(String, Module, TplVars)}
     * Must implements {@link HookProcessTpl};
     * 
     * @param hookName
     *   The unique name of this hook. 
     *   Consider using {@link #constructTplHookName(String, String)} for 
     *   constructing a unique hook name.
     * @param implementingModule
     *   The implementing Module
     */
    public void addHookProcessTpl(String hookName, Module implementingModule){
    	listenerlist.add(hookName, implementingModule);
    }
    

    

    //  =================== HOOK RUN FUNCTIONS =========================
    /**
     * 
     * @param m
     */
    public void hookModuleEnabled(Module m){
    	ModuleList mlist = listenerlist.getImplementingModules("moduleEnabled");
    	Collection<Module> c = mlist.values();
    	for(Module module : c) {
    		HookModuleEnabled h = (HookModuleEnabled)module;
    		h.hookModuleEnabled(m);
    	}
    }
    
    /**
     * 
     * @param m
     */
    public void hookEnabled(Module m){
    	ModuleList mlist = listenerlist.getImplementingModules("hookEnabled");
    	
    	if(mlist != null && mlist.containsKey(m.getName())){
        	HookEnabled h = (HookEnabled)m;
        	h.hookEnabled();
    	}
    }
    
    /**
     * 
     * @param hookName
     * @param m
     * @param vars
     */
    public void hookProcessTpl(String hookName, Module m, TplVars vars){
    	ModuleList mlist = listenerlist.getImplementingModulesExclude(hookName, new String[] {m.getName()});
    	for(Module module : mlist.values()){
    		((HookProcessTpl)module).hookProcessTpl(hookName, vars);
    	}
    }

    //  =================== HOOK INTERFACES =========================
	public interface HookModuleEnabled{
		public void hookModuleEnabled(Module m);
	}

	public interface HookEnabled{
		public void hookEnabled();
	}
	
	/**
	 * Interface for implementing {@link #hookProcessTpl(String, TplVars)}
	 * 
	 * @see JetSys#hookProcessTpl(String, Module, TplVars)
	 * @see JetSys#addHookProcessTpl(String, Module)
	 */
	public interface HookProcessTpl {
		public TplVars hookProcessTpl(String hookName, TplVars vars);
	}
	
	// ========================================================
	
	public interface Themeable{
		public void themeMainFrame();
	}
    
}
