    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

import GUI.CGui2;
import JetModules.webService.WebService;
import Sys.Sys;
import client.Client;


/**
 *
 * @author carmel
 */
public class JetSys {
    
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
//    	addModule(new Client("client"));
//    	new Client("client");

    	addModule(new CGui2("cgui2"));
    	addModule(new Client("client"));
    	addModule(new Sys("sys"));
    	addModule(new WebService("webService"));
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
}
