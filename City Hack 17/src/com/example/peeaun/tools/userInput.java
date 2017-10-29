package com.example.peeaun.tools;
import java.util.Scanner;
public class userInput {
	public static boolean validate(){
		Scanner scan = new Scanner(System.in);
		boolean respond = false;
		boolean result = true;
		do{
			char input = scan.next().charAt(0);
			if (input == 'y' ||input== 'Y'){
				result = true;
				respond = true;
			}else if (input =='n'||input =='N'){
				result = false;
				respond = true;
			}else{
				System.out.println("Please enter a valid input!");
			}
		}while(!respond);
		return result;
	}
	
	public static void main(String[] args) throws Exception{
		database database = new database();
		Scanner scan= new Scanner(System.in);
		int check;
		char cont;
		boolean quit=false;
		
		do{
		System.out.println("Do you wish to check-in or check-out? Press 1 for check-in, 2 for check-out and 3 to quit.");
		check= scan.nextInt();
		
		if(check==1)
		{
			boolean stop= false;
			do{
				
			System.out.println("Do you wish to book a room? Press Y for yes or N for no.");
			if(validate()){
				database.booking(true);
			}else{
			System.out.println("Have a good day.");
				}
			System.out.println("Do you wish to continue? Yes or no");
			if(!validate()){
				stop=true;
				break;
			}	
		}while(!stop);
			
		}
		if (check==2)
		{
			 boolean stop= false;
					do{
						
			System.out.println("When would you like to check-out? Press Y for yes and N for no.");
			if(validate())
			{
				System.out.println("What is your room numnber?");
				int no =  scan.nextInt();
				scan.nextLine();
				System.out.println("What is your password?");
				String pass = scan.nextLine();
				if(database.verify(no, pass)){
					database.checkOut(no);
					}else {
				System.out.println("You didn't not check out.");
					}
				System.out.println("Do you wish to continue? Yes or No?");
				if(!validate()){
					stop = true;
					break;
				}
			}
			}while(!stop);
		}
					
		if(check==3){
			System.out.println("Program ended.");
			quit= true;
		}
	}while(!quit);
				
	}
}