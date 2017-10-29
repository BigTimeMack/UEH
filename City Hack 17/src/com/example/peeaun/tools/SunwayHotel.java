package com.example.peeaun.tools;
import java.util.*;

class SunwayHotel 
{
	int roomNo;
	String pass;

	public SunwayHotel(){
		
	}
	public SunwayHotel(int no, String pass)
	{
		roomNo = no;
		this.pass = pass;
	}
	
	void display()
	{
		System.out.println("You have successfully logged in");
		
	}
	static char[] generatePswd(){
		System.out.println("Your Password");
		String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String chars = "abcdefghjiklmnopqrstuvwxyz";
		String nums = "0123456789";
		String passSymbols = charsCaps + chars + nums;
		Random rnd = new Random();
		char[] password = new char [8];
		for (int i = 0; i <8; i++){
			password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));


		}
		return password;
	}
	public static void main(String[] args) 
	{
		char pass[] = generatePswd();
		System.out.println(pass);
	
	}
}
