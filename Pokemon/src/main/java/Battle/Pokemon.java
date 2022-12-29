package Battle;

import java.util.ArrayList;

import DamageCalc.Attack;
import Elements.Element;

public class Pokemon {
	
	private String name;
	private double hp;
	private double attack;
	private double defense;
	private int speed;
	private int level;
	private String elementType;
	private Attack atkList[];
	private static Element ele = new Element();

	
	public Pokemon() {
		
	}
	
	
	


	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public double getHp() {
		return hp;
	}





	public void setHp(double hp) {
		this.hp = hp;
	}





	public double getAttack() {
		return attack;
	}





	public void setAttack(double attack) {
		this.attack = attack;
	}





	public double getDefense() {
		return defense;
	}





	public void setDefense(double defense) {
		this.defense = defense;
	}





	public int getSpeed() {
		return speed;
	}





	public void setSpeed(int speed) {
		this.speed = speed;
	}





	public int getLevel() {
		return level;
	}





	public void setLevel(int level) {
		this.level = level;
	}






	public String getElementType() {
		return elementType;
	}





	public void setElementType(String elementType) {
		ArrayList<String> allEle = ele.getAllElements();
		String elementToBe = null;
		for(String i: allEle) {
			if(elementType.contentEquals(i)) {
			elementToBe = elementType;
			System.out.println("The element has been set");
			} 
		}
		
		
		this.elementType = elementToBe;
	}





	public Attack[] getAtkList() {
		return atkList;
	}





	public void setAtkList(Attack[] atkList) {
		this.atkList = atkList;
	}





	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", speed="
				+ speed + ", level=" + level + ", elementType=" + elementType + ", atkList=" + atkList + "]";
	}

	
}



	