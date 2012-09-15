/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jet;

/**
 *
 * @author carmel
 */
public class Module {
    
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
}
