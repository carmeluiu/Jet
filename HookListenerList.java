package Jet;

import java.util.ArrayList;
import java.util.HashMap;

public class HookListenerList{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, ModuleList> hooks;
	
	private HashMap<String, ArrayList<Object>> gHooks;
	
	public HookListenerList() {
		hooks = new HashMap<String, ModuleList>();
		gHooks = new HashMap<String, ArrayList<Object>>();
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
	
	public void addTogHooks(String hookName, Object hook){
		ArrayList<Object> hooksList;
		if(gHooks.containsKey(hookName)){
			hooksList = gHooks.get(hookName);
		}
		else{
			hooksList = new ArrayList<Object>();
		}
		hooksList.add(hook);
		gHooks.put(hookName, hooksList);
	}
	
	public ArrayList<Object> getImplementingHooks(String hookName){
		return gHooks.get(hookName);
	}
	
	
	
	public ModuleList getImplementingModules(String hookName) {
		return hooks.get(hookName);
	}
	
	public ModuleList getImplementingModulesExclude(String hookName, String[] excludeModules){
		ModuleList ml = getImplementingModules(hookName);
		for (String moduleName : excludeModules){
			if(ml != null && ml.containsKey(moduleName)){
				ml.remove(moduleName);
			}
		}
		
		return ml;
	}
	
	/**
	 * 
	 * @param hookName
	 * @param m
	 * @return
	 */
	public boolean isModuleImplementingHook(String hookName, Module m) {
		ModuleList ml = getImplementingModules(hookName);
		boolean result = false;
		if(ml != null) {
			result = ml.containsKey(m.getName());
		}
		return result;
		
	}
	
	
	
}
