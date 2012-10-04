    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;


import java.awt.Component;
import java.awt.Container;
import java.util.Collection;

import duiu.com.core.jetModules.dTheme.DTheme;
import duiu.com.core.jetModules.mgmnt.Mgmnt;
import duiu.com.core.jetModules.tst.Tst;



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
     * 
     */
    public JetSys() { 
        moduleList = new ModuleList();
        hookList = new HookList();
    }
    
    public void bootstrap() {
    	Module.syst = this;
    	
        initModules();

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
    	addModule(new DTheme(DTheme.NAME));
    	addModule(new Mgmnt(Mgmnt.NAME));
//    	addModule(new Tst(Tst.NAME));
    	
    	enableModules(new String[] {DTheme.NAME, Mgmnt.NAME});//});//
    	
    }

    public void enableModules(String[] modules) {
    	for(String name: modules) {
    		Module m = getModule(name);
    		m.setEnabled(true);
    		runHookEnabled(m);
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
    
    public Component render(JetTpl template, Module implementingModule) {
    	TplVars vars = new TplVars();
    	String hookName = constructTplHookName(template.tplName, implementingModule.getName());
    	
    	// Let implementing module add its default vars first.
    	if(listenerlist.isModuleImplementingHook(hookName, implementingModule)){
    		((HookProcessTpl)implementingModule).hookProcessTpl(hookName, vars);
    	}
    	
    	// Let other implementing modules add their vars to the template.
    	runHookProcessTpl(hookName, implementingModule, vars);
    	
    	
    	
    	return template.render(vars);
    }
    
    private String constructTplHookName(String tplName, String moduleName) {
    	return tplHookName + "_" + tplName + "_" + moduleName;
    }
    
    
    
    
    public Themeable getActiveTheme() {
		return activeTheme;
	}

	public void setActiveTheme(Themeable activeTheme) {
		this.activeTheme = activeTheme;
	}

	//  =================== HOOK LISTENERS =========================
    public void addHookModuleEnabledListener(Module m) {
    	listenerlist.add("moduleEnabled", m);
    }
    

    public void addHookEnabledListener(Module m) {
    	listenerlist.add("hookEnabled", m);
    }
    
    public void addHookProcessTpl(String hookName, Module declaringHookModule, Module implementingModule) {
    	
    	String hook = constructTplHookName(hookName, declaringHookModule.getName());
    	listenerlist.add(hook, implementingModule);
    }
    
    

    //  =================== HOOK RUN FUNCTIONS =========================
    /**
     * 
     * @param m
     */
    public void runHookModuleEnabled(Module m){
    	ModuleList mlist = listenerlist.getImplementingModules("moduleEnabled");
    	Collection<Module> c = mlist.values();
    	for(Module module : c) {
    		HookModuleEnabled h = (HookModuleEnabled)module;
    		h.hookModuleEnabled(m);
    	}
    }
    public void runHookEnabled(Module m){
    	ModuleList mlist = listenerlist.getImplementingModules("hookEnabled");
    	if(mlist.containsKey(m.getName())){
        	HookEnabled h = (HookEnabled)m;
        	h.hookEnabled();
    	}
    }
    
    public void runHookProcessTpl(String hookName, Module m, TplVars vars){
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
	
	public interface HookProcessTpl {
		public TplVars hookProcessTpl(String hookName, TplVars vars);
	}
	
	// ========================================================
	
	public interface Themeable{
		public void themeMainFrame();
	}
    
}
