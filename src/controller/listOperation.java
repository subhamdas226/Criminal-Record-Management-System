package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.add_criminal;

public class listOperation {
	
	static List<add_criminal> lists = new ArrayList <add_criminal>();
	static List<add_criminal> nlist = new ArrayList <add_criminal>();
	
	//-------------ADD LIST---------------------------------------------------------------
	public static List<add_criminal> addCriminal(add_criminal ac) {
		lists.add(ac);
		return lists;
		
	}
	
	//--------------UPDATE LIST------------------------------------------------------------
	public static List<add_criminal> updateCriminal(add_criminal ac) {
		nlist.add(ac);
		return nlist;
		
	}

	//--------------DELETE LIST-------------------------------------------------------------
	public static List<add_criminal> removeRecord() throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		System.out.println("Delete Record by ID");
		Thread.sleep(1000);
		System.out.println("Enter Criminal ID : ");
		int criminal_id = sc.nextInt();
		
		for(add_criminal ac : lists) {
				if(ac.getCriminal_id()==criminal_id) {
					lists.remove(ac);
					System.out.println("Successfully Removed.");
					}
				else {
					System.out.println(" Criminal ID not matched !");			
				}			
		}
		return lists;
	}
}
