package Jet;

import java.util.HashMap;

public class HookListenerList{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, ModuleList> hooks;
	
	public HookListenerList() {
		hooks = new HashMap<String, ModuleList>();
	}
	
	public void add(String hookName, Module m) {
		ModuleList ml;
		if(hooks.containsKey(hookName)){
			ml = hooks.get(hookName);
//			ml.put(m.getName(), m);
		}
		else {
			ml = new ModuleList();
		}
		ml.put(m.getName(), m);
		hooks.put(hookName, ml);
	}
	
	public ModuleList getImplementingModules(String hookName) {
		return hooks.get(hookName);
	}
	
	
	
}
