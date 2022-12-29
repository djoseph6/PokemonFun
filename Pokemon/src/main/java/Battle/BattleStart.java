package Battle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import DamageCalc.Attack;
import Elements.Element;

public class BattleStart {

	Pokemon contender;
	Pokemon challenger;
	Random rand;
	static Scanner scan;
	static int turnCounter;

	public BattleStart(Pokemon a, Pokemon b) {
		super();
		this.contender = a;
		this.challenger = b;
	}
	
	public void beginBattle() throws InterruptedException {
		System.out.println(contender.getName()+" and "+challenger.getName()+" are about to battle!");
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Who will attack first?!");
		rand = new Random();
		scan = new Scanner(System.in);
		
		System.out.println("Heads or Tails");
		String option = scan.nextLine();
		String decision = determineFirstAttack(option);
		
		Pokemon firstAtker;
		Pokemon secondAtker;
		if(option.equals(decision)) {
			firstAtker = contender;
			secondAtker = challenger;
		} else {
			firstAtker = challenger;
			secondAtker = contender;
		}
		
		battleLoop(firstAtker,secondAtker);
		
	}
	
	public void battleLoop(Pokemon attackingFirst, Pokemon attackingSecond) throws InterruptedException {
		while(attackingFirst.getHp()>0 && attackingSecond.getHp()>0) {
		while(attackingFirst.getHp()>0 && attackingSecond.getHp()>0 && turnCounter==0) {
			
			
			System.out.println("It's "+ attackingFirst.getName()+"'s turn!");
			System.out.println("You can Fight or you can Run!");
			String option1 = scan.next();
			
			switch(option1) {
			case "Run" :
				System.out.println(attackingFirst.getName() +" Ran Away!");
				attackingFirst.setHp(-1);		
				break;
			case "Fight" :
				System.out.println("What attack do you want to do?");
				Attack[] atkPokemonAttacks = attackingFirst.getAtkList();
				for(Attack a: atkPokemonAttacks) {
					System.out.println(a.getAttackName());
					}
				String atkOption = scan.next();
				
				for(Attack b: atkPokemonAttacks) {
					if(b.getAttackName().equalsIgnoreCase(atkOption)) {
						System.out.println("Ok! "+ attackingFirst.getName()+ " does "+b.getAttackName()+"!");
						double damageDone = calcDamage(attackingFirst, b, attackingSecond);
						attackingSecond.setHp(attackingSecond.getHp() - damageDone);
						System.out.println(attackingSecond.getName() +" HP is now: " + attackingSecond.getHp());
						turnCounter++;
						TimeUnit.SECONDS.sleep(3);
					} 
					
				}
				
			}
				
		}
		
		while(attackingFirst.getHp()>0 && attackingSecond.getHp()>0 && turnCounter==1) {
			
		
			System.out.println("It's "+ attackingSecond.getName()+"'s turn!");
			System.out.println("You can Fight or you can Run!");
			String option1 = scan.next();
			
			switch(option1) {
			case "Run" :
				System.out.println(attackingSecond.getName() +" Ran Away!");
				attackingFirst.setHp(-1);		
				break;
			case "Fight" :
				System.out.println("What attack do you want to do?");
				Attack[] atkPokemonAttacks = attackingSecond.getAtkList();
				for(Attack a: atkPokemonAttacks) {
					System.out.println(a.getAttackName());
					}
				String atkOption = scan.next();
				
				for(Attack b: atkPokemonAttacks) {
					if(b.getAttackName().equalsIgnoreCase(atkOption)) {
						System.out.println("Ok! "+ attackingSecond.getName()+ " does "+b.getAttackName()+"!");
						double damageDone = calcDamage(attackingSecond, b, attackingFirst);
						attackingFirst.setHp(attackingFirst.getHp() - damageDone);
						System.out.println(attackingFirst.getName() +" HP is now: " + attackingFirst.getHp());
						turnCounter--;
						TimeUnit.SECONDS.sleep(3);
					} 
					
				}
				
			}
				
		}
		
		if(attackingFirst.getHp() <= 0) {
			System.out.println("The battle is over! " +attackingSecond.getName()+ " Won!");
		}
		
		if(attackingSecond.getHp() <= 0) {
			System.out.println("The battle is over! " +attackingFirst.getName()+ " Won!");
		}
		}
	}
	
	public String determineFirstAttack(String option) {
		String theDecision = null;
		double randomNum = Math.random(); 
			if(randomNum < 0.5 ) {
				if(option == "Heads") {
					System.out.println("Heads won");
				} if(option == "Tails" ) {
					System.out.println("Sorry, Heads won");
				}
				theDecision =  "Heads";
			} 
			
			if(randomNum > 0.5) {
				if(option == "Tails") {
					System.out.println("Tails won");
				} if (option == "Heads") {
					System.out.println("Sorry, Tails won");
				}
				theDecision = "Tails";
			}
			return theDecision;
		}
		

	public double calcDamage(Pokemon pokemonAtk, Attack attack, Pokemon pokemonDef) {
			double fullDamage = pokemonAtk.getAttack() * attack.getDamage();
			boolean critHit = weaknessTrue(attack, pokemonDef);
				if(critHit) {
					System.out.println("That was a critical hit!");
					fullDamage *= 2;
				}
			
			
			return fullDamage;
		
	}
	
	public boolean weaknessTrue(Attack atk, Pokemon pokemonDef) {
		boolean weakness = false;
		String atkElement = atk.getAtkElement();
		String pokeElement = pokemonDef.getElementType();
		
		switch(atkElement) {
		case "Fire" :
			String fireWeakness = "Grass";
			if(pokeElement.equalsIgnoreCase(fireWeakness)) {
				weakness = true;
			}
		case "Water" :
			String waterWeakness = "Fire";
			if(pokeElement.equalsIgnoreCase(waterWeakness)) {
				weakness = true;
			}
		}
		
		return weakness;
		
	}
	
	
	
}
