package runnableApp;

import java.util.ArrayList;
import java.util.List;

//synchronize agar thread urut
public class SyncThread {
	private List<String> list; //= new ArrayList<String>();
	public SyncThread() {
		list = new ArrayList<String>();
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		list.add("Test4");
		list.add("Test5");
		list.add("Test6");
	}
	public void printList() {
		synchronized(list){
			for(int i = 0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
			
		}
	}
}
