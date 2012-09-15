/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

import javaapplication2.Modules.TestModule.TestModule;

/**
 *
 * @author carmel
 */
public class JetSys {
    
    private ModuleList moduleList;
    
    
    public JetSys() {
        initModules();
    }
    
    public void addModule(Module module) {
        moduleList.put(module.getName(), module);
        
    }
    
    public final void initModules() {
        addModule(new TestModule("testModule"));
        
    }
}
