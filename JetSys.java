/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

import java.util.HashMap;

/**
 *
 * @author carmel
 */
public class JetSys {
    
//    private HashMap moduleList;
    
    public JetSys() {
        
    }
    
    public void addModule(Moduleable module) {
        module.implementedHooks();
    }
}
