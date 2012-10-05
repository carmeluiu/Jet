package Jet.Modules.context;

import Jet.HookListenerList;
import Jet.Module;
import Jet.ModuleList;

public class Context extends Module {

	private HookListenerList listenerList = new HookListenerList();
	public static String NAME = "context";
	public Context(String name){ 
		super(name);
	}
	
	

	//  =================== HOOK LISTENERS =========================
	
	public void addHookContextListener(Module module){
		listenerList.add("hookContext", module);
	}
    //  =================== HOOK RUN FUNCTIONS =========================
	public void hookContext(){
		ModuleList mlist = listenerList.getImplementingModules("hookContext");
		
		if(mlist != null){
			for(Module module : mlist.values()){
				((HookContext)module).hookContext();
			}
		}
	}
    //  =================== HOOK INTERFACES =========================
	
	public interface HookContext{
		public ContextItem hookContext();
	}
}
