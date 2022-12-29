package Battle;

import DamageCalc.Attack;

public class initiation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 
		Pokemon charzard = new Pokemon();
		charzard.setAttack(6);
		charzard.setDefense(4);
		charzard.setElementType("Fire");
		charzard.setHp(1500);
		charzard.setLevel(10);
		charzard.setName("Charzard");
		charzard.setSpeed(4);
		charzard.setElementType("Fire");
		
		Attack fireBall = new Attack("FireBall", 3, "Fire");
		Attack flameThrower = new Attack("FlameThrower", 4, "Fire");
		Attack[] charzardAtkList = {fireBall, flameThrower};
		charzard.setAtkList(charzardAtkList);
		
		System.out.println(charzard.toString());
		
		Pokemon blastoid = new Pokemon();
		blastoid.setAttack(4);
		blastoid.setDefense(7);
		blastoid.setElementType("Water");
		blastoid.setHp(1500);
		blastoid.setLevel(10);
		blastoid.setName("Blastoid");
		blastoid.setSpeed(2);
		blastoid.setElementType("Water");
		
		Attack waterGun = new Attack("WaterGun", 3, "Water");
		Attack hydroPump = new Attack("HydroPump", 5, "Water");
		Attack[] blastoidAtkList = {waterGun, hydroPump};
		blastoid.setAtkList(blastoidAtkList);
		
		System.out.println(blastoid.toString());
		
		BattleStart fireVsWater = new BattleStart(charzard, blastoid);
		
		try {
			fireVsWater.beginBattle();
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}
