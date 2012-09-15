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
public class Module implements Moduleable{
    
    /**
     * Module's unique name
     */
    private String name;
    
    /**
     * Module's state
     */
    private boolean enabled;
    
    public Module(String name) {
        this.name = name;
        enabled = false;
    }
    
    /**
     * 
     * @return 
     *   String The name of the module
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter
     * @param name
     *   String the name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArrayList implementedHooks() {
        return null;
    }
}
