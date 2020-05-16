package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import excelGeneration.excelGenerate;
import model.add_criminal;
public class userInput {

	Scanner sc =new Scanner(System.in);
	List<add_criminal> lists = new ArrayList<add_criminal>();
	List<add_criminal> nlist = new ArrayList<add_criminal>();
	
	add_criminal ac = new add_criminal();
	
	public void input_detail() throws IOException {
		
		System.out.println(" Enter Criminal name  : ");
		String name = sc.nextLine();
		ac.setCriminal_name(name);
		
		System.out.println(" Enter Criminal dob  : ");
		String dob = sc.nextLine();
		ac.setCriminal_dob(dob);
		
		System.out.println(" Enter Criminal Address  : ");
		String addr = sc.nextLine();
		ac.setCriminal_addr(addr);
		
		System.out.println(" Enter Criminal Crime  : ");
		String crime = sc.nextLine();
		ac.setCriminal_crime(crime);
		
		System.out.println(" Enter Criminal Punishment  : ");
		 String punish = sc.nextLine();
		ac.setCriminal_punishment(punish);
		
		System.out.println(" Enter Criminal id  : ");
		int id = sc.nextInt();
		ac.setCriminal_id(id);
		
		
		
		System.out.println(" Enter Criminal weight  : ");
		int weight = sc.nextInt();
		ac.setCriminal_weight(weight);		
		
	}
	
	public void call_excel_gen() throws IOException {
		lists = listOperation.addCriminal(ac);	
		excelGenerate gen =new excelGenerate();
		gen.createExcel(lists);
	}
	
	public void del_cri() throws IOException, InterruptedException {	
		lists = listOperation.removeRecord();	
		excelGenerate gen =new excelGenerate();
		gen.delete(lists);
	}
	
	public void call_update_excel_gen() throws IOException, InterruptedException {
		lists = listOperation.updateCriminal(ac);		
		excelGenerate gen =new excelGenerate();
		gen.updateExcel(lists);
	}
	
	public void output() throws InterruptedException {
		System.out.println(" Criminal name  : "+ ac.getCriminal_name());
		Thread.sleep(1000);
		System.out.println(" Criminal dob  : "+ ac.getCriminal_dob());
		Thread.sleep(1000);
		System.out.println(" Criminal address  : "+ ac.getCriminal_addr());
		Thread.sleep(1000);
		System.out.println(" Criminal id  : "+ ac.getCriminal_id());
		Thread.sleep(1000);
		System.out.println(" Criminal Punishment  : "+ ac.getCriminal_punishment());
		Thread.sleep(1000);
		System.out.println(" Criminal weight  : "+ ac.getCriminal_weight());
		Thread.sleep(1000);
		System.out.println(" Criminal Crime  : "+ ac.getCriminal_crime());
	}
	

}
