package edu.ycp.casino.shared;

import java.util.Random;
import java.util.Scanner; 

import edu.ycp.casino.shared.cardgame.poker.Pot;


public class Roulette {
	private static int [] wheel; 
	private static Random generator;
	private Pot p;
	private BetType btype; 


	private enum SlotColor {
		RED, BLACK;
	}


	public Roulette(){
		wheel = new int[38]; 
		p = new Pot(); 
		generator = new Random(); 
		for(int i = 0; i < 37; i++){
			wheel[i] =  i; 
		}
	}

	public int spinWheel(){
		int val = generator.nextInt(37);
		return wheel[val]; 
	}

	public SlotColor getColor(int val){
		if(val%2 == 0){
			return SlotColor.BLACK; 
		}
		else{
			return SlotColor.RED; 
		}
	}

	public void placeBet(int amt, BetType b){
		p.add(amt); 
		btype = b; 
	}

	public Boolean checkWin(BetType b, int betNumber, int wheelNumber){
		Boolean win = false;
		SlotColor color = getColor(wheelNumber); 

		if(b == BetType.NUM_MATCH && betNumber == wheelNumber){
			win = true; 
		}

		if(b == BetType.BLACK && color == SlotColor.BLACK){
			win = true; 
		}

		if(b == BetType.RED && color == SlotColor.RED){
			win = true; 
		}

		if(b == BetType.FIRST_TWELVE && wheelNumber < 13){
			win = true; 
		}

		else{
			if(b == BetType.MIDDLE_TWELVE && wheelNumber < 25){
				win = true; 
			}
			else {
				if(b == BetType.LAST_TWELVE && wheelNumber < 37){
					win = true; 
				}
			}
		}

		if(b == BetType.ZERO && wheelNumber == 0){
			win = true; 
		}

		return win; 
	}

	public int getPayout(int bet, BetType b){
		int payout = 0; 

		if(b == BetType.NUM_MATCH){
			payout = bet*37; 
		}

		if(b == BetType.BLACK || b == BetType.RED){
			payout = bet*2; 
		}

		if(b == BetType.FIRST_TWELVE || b == BetType.MIDDLE_TWELVE || b == BetType.LAST_TWELVE){
			payout = bet*3; 
		}

		return payout; 
	}


	public void play(Player p){
		int betAmount;
		int type; 
		int numToBet=0;
		int wheelNum; 
		int winnings;
		BetType b = null;
		Boolean gameLoop = true; 

		while(gameLoop == true){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Please select a bet amount: ");
			betAmount = keyboard.nextInt();
			p.getWallet().takeBet(betAmount); 

			System.out.println("Please select a bet type:");
			System.out.println("1. Red \n2. Black \n3. First 12 \n4. Mid 12 \n5. Last 12 \n6. Number"); 
			type = keyboard.nextInt(); 

			if(type == 6){
				System.out.println("Please enter a num to bet"); 
				numToBet = keyboard.nextInt();
				b = BetType.NUM_MATCH; 
			}

			if(type == 1){
				b = BetType.RED; 
			}
			if(type == 2){
				b = BetType.BLACK; 
			}
			if(type == 3){
				b = BetType.FIRST_TWELVE; 
			}
			if(type == 4){
				b = BetType.MIDDLE_TWELVE; 
			}
			if(type == 5){
				b = BetType.LAST_TWELVE; 
			}

			placeBet(betAmount, b); 

			wheelNum = spinWheel();

			System.out.printf("The wheel landed on %d", wheelNum);

			if(checkWin(b, numToBet, wheelNum) == true){
				winnings = getPayout(betAmount, b); 
				p.addBalance(winnings);

				System.out.printf("Congrats, you won %d dollars!", winnings); 
			}
			else{
				winnings = 0; 
				System.out.printf("Sorry, you won %d dollars", winnings); 
			}

			System.out.print("Play again?: ");
			System.out.print("1. Yes\n2. No"); 
			
			if(keyboard.nextInt() == 2){
				gameLoop = false; 
			}
		}
	}
}
