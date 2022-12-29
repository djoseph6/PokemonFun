package Elements;

import java.util.ArrayList;


public class Element {
	
	public  ArrayList<String> allElements;
	
		public Element(){
			String[] elements = {"Fire", "Water", "Grass"};
			ArrayList<String> elements1 = new ArrayList<String>();
				for(String a:elements) {
					elements1.add(a);
				}
		this.allElements = elements1; 
			
	}

		public ArrayList<String> getAllElements() {
			return allElements;
		}
	

}
