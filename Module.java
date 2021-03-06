/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

import java.util.ArrayList;

/**
 *
 */
public class Module implements Moduleable{
    
	public static JetSys syst;
	
    /**
     * Module's unique name
     */
    private String name;
    
    /**
     * Module's state
     */
    private boolean enabled;
    
    /**
     * The system object
     */
    public JetSys sys;
    
    /**
     * 
     * @param name 
     */
    public Module(String name) {
    	syst.addModule(this);
        this.name = name;
        enabled = false;
    }
    
    public Module(){
    	
    }

    /**
     * 
     * @return 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 
     * @param enabled 
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 
     * @return 
     */
    public JetSys getSys() {
        return sys;
    }

    /**
     * 
     * @param sys 
     */
    public void setSys(JetSys sys) {
        this.sys = sys;
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
