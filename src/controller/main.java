package controller;

import java.io.*;
import java.util.*;
import model.*;
public class main {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		main m =new main();
		boolean success = m.start();
		if(success ==true) {
			System.out.println("Succesfully Login! ");
			System.out.println("---------------------");
			Thread.sleep(1000);


			int exit = 5;
			int answer;
			
			userInput in =new userInput();
			Thread.sleep(1000);
			do {
				System.out.println("Enter number for operation you want to perform: \n 1. Create Criminal Record"
				 +"\n 2. Update Criminal Record \n 3. View Criminal Record \n 4. Delete criminal record \n 5. exit ");
				try {
				answer = sc.nextInt();
			} catch (NumberFormatException e) {
			    
				answer = -1;
			}
				if(answer == 1) {
					//System.out.println(" Call add ");
					
						in.input_detail();
						
						in.call_excel_gen();
						
						
					
				}
				else if(answer == 2) {
					//System.out.println(" Call update ");
					in.input_detail();
					//a.call_excel_gen();
					in.call_update_excel_gen();
					
				}
				else if(answer == 3) {
					//System.out.println(" Printing Criminal Record ");
					in.output();
				}
				else if(answer == 4) {
					//System.out.println(" Call delete ");
					
					in.del_cri();
					
					//a.output();
					
				}
				else {
					System.out.println(" Logout ");
				}
			}
			while(answer !=exit);
			System.out.println("Application terminating...");
				
			
				
			}
		
	}
	public boolean start() throws InterruptedException {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("---Enter your Admin credentials --- ");
		Thread.sleep(1000);
		System.out.println("Enter your Admin Id : ");
		String admin_id = sc.nextLine();
		System.out.println("Enter your Admin Password : ");
		String admin_pass = sc.nextLine();
		
		validation chk =new validation(admin_id, admin_pass);
		boolean adminValidation = chk.checkAdminDetails();
		if (adminValidation == true) {
			
			return true;
		}
		else {
			System.out.println(" Admin credentials didn't match! ");
			return start();
		}
	}


}