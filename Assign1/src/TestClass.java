import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		
		char[] alphabet = new char[26]; 	
		float start, finish, timeElapsed;
		
		Scanner scanIn = new Scanner(System.in);  //takes user input from the console
		
		alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); //filling array with letters of alphabet
		
		System.out.println("Type alphabet in order, hitting enter between characters");
		System.out.println("Forward or backwards? (f/b)");

		while(true) { 			//ensures f or b is selected without just exiting program if user doesn't input either
			
			char whichWay = scanIn.next().charAt(0); //scans to see if f or b input into console
		
			if(whichWay == 'f') { 			//forward alphabet selected
				start = System.nanoTime();
				
				for(int i=0; i<=25;) {
					char newLetter = scanIn.next().charAt(0);
					
					if(newLetter==alphabet[i] && i<25) {
						
						System.out.printf("%c correct:  Now type %c ", newLetter, alphabet[i+1]);
						i++;
					}	
					
					
					else if(newLetter==alphabet[i] && i==25) {
						
						System.out.printf("%c correct: Congratulations \n", newLetter);
						i++;
					}
					
				}
				break; //ends while loop
			}
			
			else if(whichWay == 'b') { //backwards alphabet selected
				start = System.nanoTime();
				
				for(int i=25; i>=0;) {
					
					char newLetter = scanIn.next().charAt(0);
					
					if(newLetter==alphabet[i] && i>0) {
						
						System.out.printf("%c correct:  Now type %c ", newLetter, alphabet[i-1]);
						i--;
					}	
					
					else if(newLetter==alphabet[i] && i==0) {
						
						System.out.printf("%c correct: Congratulations \n", newLetter);
						i--;
					}
				}
				break;	//ends while loop
			}
			
			else { //re-checks for f or b if not found
				System.out.println("Error please enter f or b");	
			}
		}
		
		finish = System.nanoTime(); //records time at which user enters final letter, i.e. 'a' or 'z' 
		timeElapsed = finish - start;
		System.out.printf("Time elapsed: %.3f  seconds", timeElapsed/1000000000); //time is recorded in nanoseconds, dividing timeElapsed to convert to seconds
	}

}
