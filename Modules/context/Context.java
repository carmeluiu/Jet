package Jet.Modules.context;

import Jet.HookListenerList;
import Jet.Module;
import Jet.ModuleList;

public class Context extends Module {

	/**
	 * List of context items
	 */
	private ContextItemList itemList = new ContextItemList();
	
	/**
	 * List to keep the hook implementing modules.
	 */
	private HookListenerList listenerList = new HookListenerList();
	
	/**
	 * Module name.
	 */
	public static String NAME = "context";
	
	/**
	 * 
	 * @param name
	 */
	public Context(String name){ 
		super(name);
	}
	
	/**
	 * 
	 * @param menuName
	 * @return
	 */
	public String constructContextHookName(String menuName) {
		return "contextHook_" + menuName;
	}
	
	/**
	 * Get a {@link ContextLink} object.
	 * 
	 * @param item
	 *   The {@link ContextItem} that defines this menu item
	 * @return
	 *   {@link ContextLink} object.
	 */
	public ContextLink getContextLink(ContextItem item){
		
		return new ContextLink(item, this);
	}
	

	//  =================== HOOK LISTENERS =========================
	
	/**
	 * Add listener for {@link #hookContext()}
	 * 
	 * @param module
	 *   The implementing module.
	 */
	public void addHookContextListener(Module module){
		listenerList.add("hookContext", module);
	}
	
	/**
	 * Add a listener for {@link #hookContextChanged(String)}
	 * 
	 * @param hook
	 *   The {@link ContextItem} unique name. (i.e 'admin/jet')
	 * @param module
	 *   Implementing module.
	 */
	public void addHookContextChanged(String hook, Module module) {
		listenerList.add(hook, module);
	}
    //  =================== HOOK RUN FUNCTIONS =========================
	
	/**
	 * Collect context items from modules into {@code itemList}
	 */
	public void hookContext(){
		ModuleList mlist = listenerList.getImplementingModules("hookContext");
		
		if(mlist != null){
			for(Module module : mlist.values()){
				ContextItem[] items = ((HookContext)module).hookContext();
				for (int i = 0 ; i < items.length ; i++){
					items[i].setModule(module);
					itemList.put(items[i].getUniqueName(), items[i]);
					
				}
			}
		}
	}
	
	/**
	 * Notify Modules that implement {@link HookContextChanged} and 
	 * added themselves with 
	 */
	public void hookContextChanged(String contextHook){
		
	}
    //  =================== HOOK INTERFACES =========================
	
	/**
	 * Interface for {@link #hookContext()}
	 * 
	 * @see Context#addHookContextListener(Module)
	 *
	 */
	public interface HookContext{
		public ContextItem[] hookContext();
	}
	
	/**
	 * 
	 *
	 */
	public interface HookContextChanged{
		public void hookContextChanged(String contextHook);
	}
}
