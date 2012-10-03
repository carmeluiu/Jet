    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;


import java.util.Collection;

import GUI.CGui2;
import JetModules.webService.WebService;
import Sys.Sys;
import client.Client;


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

    	addModule(new CGui2("cgui2"));
    	addModule(new WebService("webService"));
    	addModule(new Client("client"));
    	addModule(new Sys("sys"));
    	String[] modules = {"webService", "cgui2", "client", "sys"};
    	enableModules(modules);
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
    
    
    //  =================== HOOK LISTENERS =========================
    public void addHookModuleEnabledListener(Module m) {
    	listenerlist.add("moduleEnabled", m);
    }
    

    public void addHookEnabledListener(Module m) {
    	listenerlist.add("hookEnabled", m);
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

    //  =================== HOOK INTERFACES =========================
	public interface HookModuleEnabled{
		public void hookModuleEnabled(Module m);
	}

	public interface HookEnabled{
		public void hookEnabled();
	}
    
}
