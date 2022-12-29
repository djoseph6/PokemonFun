package DamageCalc;

import java.util.ArrayList;

import Elements.Element;

public class Attack {

	
	 String attackName;
	 double damage;
	 String atkElement;
	 String description;
	private static Element ele;
	
	
	
	

	public Attack(String attackName, double damage, String atkElement) {
		super();
		this.attackName = attackName;
		this.damage = damage;
		this.atkElement = atkElement;
	}



	public String getAttackName() {
		return attackName;
	}



	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}



	public String getAtkElement() {
		return atkElement;
	}



	public void setAtkElement(String atkElement) {
		ArrayList<String> allEle = ele.getAllElements();
		String elementToBe = null;
		for(String i: allEle) {
			if(atkElement.contentEquals(i)) {
			elementToBe = atkElement;
			System.out.println("The element has been set");
			} 
		this.atkElement = atkElement;
		}
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	


	public double getDamage() {
		return damage;
	}



	public void setDamage(double damage) {
		this.damage = damage;
	}



	@Override
	public String toString() {
		return "Attack [attackName=" + attackName + ", atkElement=" + atkElement + ", description=" + description + "]";
	}
	
	
}
