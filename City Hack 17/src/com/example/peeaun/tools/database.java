package com.example.peeaun.tools;
import java.sql.*;
import java.util.*;
public class database {
	static SunwayHotel SunwayHotel = new SunwayHotel();
	
public static void main(String[] args) throws Exception{}

//	Class.forName("com.mysql.jdbc.Driver");
//	
//	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
//	Statement stment = conn.createStatement();
//	
//	for(int num = 1; num <=20; num++){
//		int available = 1;
//		String command =  "insert into hotel (HotelNumber,Availability,Password) values ("+num+",'"+available+"',"+"'null')";
//		stment.executeUpdate(command);
//		}		
//	}
	public database(){}
	
	void booking(boolean confirm) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
		Statement stment = conn.createStatement();
		String select =  "select * from hotel";
		ResultSet rs =  stment.executeQuery(select);
	while (rs.next()){
		if(rs.getInt("Availability")==1){
			int roomNo = rs.getInt("HotelNumber");
			
			char[] password = SunwayHotel.generatePswd();
			String pass="";
			for (int len=0; len< password.length; len++)
			{
				pass+= password[len];
			}
				System.out.println(pass);
				
			System.out.println("Your room number is "+ roomNo);
			//String update = "update 'hotel' set 'Availability' = " + 0 + ",'Password' =" + pass+ " where 'HotelNumber' = " +roomNo  ;
			stment.executeUpdate("UPDATE `hotel` SET `Availability`="+0 +",`Password`='"+ pass+ "' WHERE `HotelNumber`="+ roomNo);
			break;
		}
	}
	}
	void checkOut(int num)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
		Statement stment = conn.createStatement();
		int roomNo =num;
		stment.executeUpdate("UPDATE `hotel` SET `Availability`="+1 +",`Password`= 'null'  WHERE `HotelNumber`=" + roomNo);
	}
	boolean verify(int num, String str) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
		Statement stment = conn.createStatement();
		Scanner scan = new Scanner(System.in);
		int roomNo = num;
		String password = str;
		int counter = 1;
		boolean verification = false;
		String select = "SELECT * FROM `hotel` WHERE HotelNumber ="+ roomNo;
		ResultSet rs =  stment.executeQuery(select);
		System.out.println("starting verify");
		
		do{
			if (rs.next()){
				if(rs.getString("Password").equals(password)){
				verification = true;
				System.out.println("Check-out complete");
				break;
			}else{
				while(counter<3){
				System.out.println("Wrong Password");
				counter ++;
				password = scan.nextLine();
				if(rs.getString("Password").equals(password)){
					verification = true;
					System.out.println("verify yes");
					break;
				}else{
					continue;
					}
				}
					System.out.println("Please proceed to the counter for assistance");
					break;
				}
			}else{
			System.out.println("The room is currently not using.");
		}
		
	}while(!rs.next());
		return verification;
	}
}