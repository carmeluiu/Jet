/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

import java.util.ArrayList;

/**
 *
 * @author carmel
 */
public class CoreModule extends Module{

    public CoreModule(String name) {
        super(name);
    }
    
    @Override
    public ArrayList implementedHooks() {
        ArrayList hooks = new ArrayList(); 
        hooks.add("menu");
        hooks.add("theme");
        return hooks;
    }
    
    public void hook_menu() {
        
    }
    
}
