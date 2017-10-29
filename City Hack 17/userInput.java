import java.util.*;
public class userInput 
{
	public static void main(String[] args) 
	{
		database database = new database();
		
		char book;
		Scanner scan= new Scanner(System.in);
		System.out.println("Do you wish to book a room? Press Y for yes or N for no.");
		book = scan.next().charAt(0);
		
		if(book = Y || book = y){
			database.booking(true);
		}
		
		
		
	}
}
