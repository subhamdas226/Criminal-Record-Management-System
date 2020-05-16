package controller;


import java.util.regex.*;
public class validation {
	String email;
	String pass;
	
	public validation(String admin_id, String admin_pass) {
		super();
		this.email = admin_id;
		this.pass = admin_pass;
	}
	
	public boolean checkAdminDetails() {
		boolean valid_pass = Pass();
		boolean valid_email = Email();
		if((valid_pass ==true) && (valid_email == true)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean Email() {
		
		String email_regex = "admin123@gmail.com";
		boolean e = Pattern.compile(email_regex).matcher(this.email).matches();
		
		if(e == true) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean Pass() {
		
		String pass_val =  "12345";
		boolean pass = Pattern.compile(pass_val).matcher(this.pass).matches();
		
		if(pass == true ) {
			return true;
		}
		else {
			return false;
		}
	}
}

