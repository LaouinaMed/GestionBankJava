package Users;
import java.util.Scanner;

import entities.Account;
import entities.BankAgency;
import entities.Client;
import service.*;

public class Admin extends User {
	
	private  String userename ="admin";
	private  String password ="admin";
	
	private BankService bankService;
	
	public Admin(BankService bankService)
	{
		super();
		this.bankService = bankService;
	}
	
	public BankService getBankService() { return bankService;}
	
	public String getUserName() {return userename; }
	public String getPassword() {return password; }
	
	public boolean authentification(String userename1 , String password1 ) {
		
		if(this.getUserName().equals(userename1) && this.getPassword().equals(password1)) return true;
		
		return false;
		
	}
	
	/*
	@Override
    public boolean equals(Object other)
    {
        if (other instanceof Admin)
            return this.userename.equals(((Admin) other).userename);
        return false ;
    }
	*/

	public static void main(String[] args) {
		
	
	/*	
		User u = new User();
		//u.SetBankAgency(admin.getBankService().getBankAgency());
		
		//u.verser(500.0, 1);
		u.SetBankAgency(admin.getBankService().getBankAgency());
		admin.verser(155.0, 1);
		System.out.println(u.getBankAgency().getAgencyAccount()[0]);
		//System.out.println(admin.getBankService().getBankAgency().getAgencyAccount()[0]);
*/
	}
}
