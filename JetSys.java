/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

import javaapplication2.Modules.ModuleModule.ModuleModule;
import javaapplication2.Modules.TestModule.TestModule;

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
        initModules();
        String hello = "hello";
    }
    
    /**
     * 
     * @param module 
     */
    public void addModule(Module module) {
        moduleList.put(module.getName(), module);
        hookList.put(module.getName(), module.implementedHooks());
        
    }
    
    /**
     * 
     */
    public final void initModules() {
        addModule(new TestModule("testModule"));
        addModule(new ModuleModule("moduleModuel"));
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
