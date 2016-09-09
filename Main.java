package assignment;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		System.out.println("+***************************************************+"
						+ "\n+                                                   +"
						+ "\n+        Welcome to the DIT948 Calculator           +"
						+ "\n+                                                   +"
						+ "\n+***************************************************+");
		Scanner input = new Scanner(System.in);
/** V A R I A B L E S */			
		System.out.print("Please enter the operator to use (’+’, ’-’, ’x’, ’/’) or press ’q’ to quit:   ");
		int fv, sv, res;															//first number, second number, result
		int a, b, c, d, e, f, g, h;													//two digits of first number(a,b), two of the second(c,d), four of result (e,f,g,h)
		int carry;
		boolean neg = false;														//remembers if the result should be negative
		char op = input.next().charAt(0);
		while (op!='q'&& op!='+' && op!='-' && op!='/' && op!='x'){
			System.out.print("Invalid input, try again:   ");
					op = input.next().charAt(0);
		}
		System.out.print("Please enter the first value:   ");
		fv = input.nextInt();
		while (fv < 1 || fv > 99){
			System.out.print("Invalid input, try again:   ");
					fv = input.nextInt();
		}
		System.out.print("Please enter the second value:   ");
		sv = input.nextInt();
		while (sv < 0 || sv > 99){
			System.out.print("Invalid input, try again:   ");
					sv = input.nextInt();
		}
		while(op!='q'){
/** A D D I T I O N */ //Ludvig
			if (op == '+') {
				b = fv % 10; // The last digits from the two values are seperated
				 d = sv % 10;
				 int bd = (b + d); // The last digits are added
				 carry = (bd > 9) ? 1 : 0; // If the last two digits add up to a two-digit number, 1 is carried
				 bd %= 10; // the last digit from bd is extracted
				 a = fv / 10; // The first digits from the two values are separated
				 c = sv / 10;
				 int ac = a + c + carry; // The digits are added and if a 1 was carried, it's added
				 res = ac * 10 + bd; // The final result is produced
				 System.out.println("The sum is " + res); // The result is printed
				}
/** M U L T I P L I C A T I O N */ //Ludvig
			else if (op == 'x') {
				b = fv % 10; // the last digit from the first value is separated
				a = fv / 10; // the first digit from the first value is separated
				b *= sv;
				a = (a * sv) * 10;
				h = (b % 10) + (a % 10); // The last digits are added
				carry = (h > 9) ? 1 : 0; // If the last two digits add up to a two-digit number, 1 is carried
				h %= 10; // the last digit from h is extracted
				g = (( b / 10 ) % 10) + ((a / 10) % 10) + carry; //The next two digits are added, if a 1 is carried, it's added
				carry = (g > 9) ? 1 : 0; // If the last two digits add up to a two-digit number, 1 is carried
				g %= 10; // the last digit from h is extracted
				f = (( b / 100 ) % 10) + ((a / 100) % 10) + carry; //The next two digits are added, if a 1 is carried, it's added
				carry = (f > 9) ? 1 : 0; // If the last two digits add up to a two-digit number, 1 is carried
				f %= 10; // the last digit from h is extracted
				e = (( b / 1000) % 10) + ((a / 1000) % 10) + carry; //The last two digits are added, if a 1 is carried, it's added
				carry = (e > 9) ? 1 : 0; // If the last two digits add up to a two-digit number, 1 is carried
				e %= 10; // the last digit from h is extracted
				res = h + g * 10 + f * 100 + e * 1000;
				System.out.println("The product is " + res);
			}
/** S U B T R A C T I O N */ //Snezhina R.
			else if (op == '-') {
				if (sv>fv){															//sv always being the smaller of the two
					neg = true;														//the result  will be negative if this if is used
					int t = sv;
					sv = fv;
					fv = t;
				}																	//determining the digits each of them has
				if (String.valueOf(sv).length()==2){ 								//both have two digits (since fv can't be smaller)
					a = Character.getNumericValue(String.valueOf(fv).charAt(0));	//each number gets a variable for every digit it has
					b = Character.getNumericValue(String.valueOf(fv).charAt(1));
					c = Character.getNumericValue(String.valueOf(sv).charAt(0));
					d = Character.getNumericValue(String.valueOf(sv).charAt(1));
					if (d > b){														//carries on a part of the next digit where needed
						b +=10;
						a--;
					}
					h = b - d;														//the last digit of result is found
					g = a - c;														//the first digit of result is found
					res = Integer.parseInt(String.valueOf(g)+String.valueOf(h));	//adding the two digits together for res - could also be done with g*10+h
					if(neg==true){res=0-res;}										//if the bool value neg remembers that the numbers have been switched, i.e. sv>fv, then the result is negative
					System.out.println("The difference is "+res+".");
				}else{
					if (String.valueOf(fv).length()==2){ 							// fv has two digits, sv has one, same principle, but c is skipped
						a = Character.getNumericValue(String.valueOf(fv).charAt(0));
						b = Character.getNumericValue(String.valueOf(fv).charAt(1));
						d = Character.getNumericValue(String.valueOf(sv).charAt(0));
						if (d > b){
							b +=10;
							a--;
						}
						h = b - d;
						res = Integer.parseInt(String.valueOf(a)+String.valueOf(h));
						if(neg==true){res=0-res;}
						System.out.println("The difference is "+res+".");
					}else{ 															// both have just one digit
						b = Character.getNumericValue(String.valueOf(fv).charAt(0));
						d = Character.getNumericValue(String.valueOf(sv).charAt(0));
						h = b - d;
						res = h;
						if(neg==true){res=0-res;}
						System.out.println("The difference is "+res+".");
					}
				}
			} 
/** D I V I S I O N */
			else if (op == '/') {
//A bunch of variables only related to division
				System.out.print("How many numbers would you like after the decimal symbol?   ");
				int dec = input.nextInt();
				int z;																//prints the digits after the decimal symbol
				int r = 0;															//remainder variable 	
				if (String.valueOf(fv).length()==2){										//division in the case of fv being two digits
					a = Character.getNumericValue(String.valueOf(fv).charAt(0));			//a is the first (left) digit
					res = a/sv;																//result is either 0 (if a<sv), or the remainder-division-result of a/sv
					r = a - res*sv;															//remainder is found the oldschool way (result*sv+remainder=a
					b = Integer.parseInt(String.valueOf(r)+String.valueOf(fv).charAt(1));	//b is the second (right) digit or the remainder of a/sv as a first digit, and fv's second digit as second
					res = Integer.parseInt(String.valueOf(res)+String.valueOf(b/sv));		//result is the old res, with a second digit of the "new" res - b/sv
					if(String.valueOf(res).length()==2){									//remainder for the entire division
						r = b - Character.getNumericValue(String.valueOf(res).charAt(1))*sv;
						}else{
						r = b - Character.getNumericValue(String.valueOf(res).charAt(0))*sv;
						}
					if (dec>0){
						System.out.print(res+",");											//if the user doesn't want a decimal answer, the program prints a remainder division result
						for (int i = 1; i<dec; i++){										//the loop prints exactly the number of decimal numbers the user requested
							r=r*10;															//a zero is added at the end of the remainder from the main division
							z=r/sv;
							System.out.print(z);											//prints the current digit after the decimal
							r=r - z * sv;													//finds the new remainder
						}{																	//block that provides more accurate approximation of the last digit of a decimal number
						r=r*10;																//by looking at the digit that would come after it
						z=r/sv;
						r=r-z*sv;
						r=r*10;
						int z1=r/sv;
						if(z1>=5){z++;}}
						System.out.print(z+".");
					}
					else{System.out.println("The quotinent is "+res + " with a remainder ("+r+").");}			//prints a remainder result if the user requested so
				}
				else{
					a = Integer.parseInt(String.valueOf(r)+String.valueOf(fv).charAt(0));	//same principle as two-digit division, just skips the second (right) digit and goes straight to decimal/remainder
					res = a/sv;
					r = a - Character.getNumericValue(String.valueOf(res).charAt(0))*sv;
					if (dec>0){
						System.out.print("The quotinent is "+res+",");
						for (int i = 1; i<dec; i++){
							r=r*10;
							z=r/sv;
							System.out.print(z);
							r=r - z * sv;
						}{
						r=r*10;
						z=r/sv;
						r=r-z*sv;
						r=r*10;
						int z1=r/sv;
						if(z1>=5){z++;}}
						System.out.print(z+".");
					}
					else{System.out.println("The quotinent is "+res + " with a remainder ("+r+").");}
				}
			}else if (op == 'q') {
				System.out.println("Goodbye!");
				System.exit(0);
			}else {
				System.out.println("\nI don't think that operator was a valid one. Try again?");
			}
			System.out.print("\nWant to do it again? Please enter the operator to use (’+’, ’-’, ’x’, ’/’) or press ’q’ to quit:   ");
			op = input.next().charAt(0);
		}
		System.out.println("Goodbye!");
		System.exit(0);
		input.close();
	}	
}
