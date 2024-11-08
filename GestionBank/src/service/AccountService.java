package service;
import  entities.*;
import  service.*;

public class AccountService {
	
	
	private BankAgency bankAgency ;
	
	public AccountService() {}

	
	public void SetBankAgency(BankAgency bankAgency)
	{
		this.bankAgency = bankAgency;
	}
	
	public BankAgency getBankAgency()
	{
		return bankAgency;
		
	}
	
	public boolean chercherCompte( int id)
	{
		if( this.getBankAgency() != null)
		{
			for(int i = 0 ; i < this.getBankAgency().getAgencyAccount().length ; i++)
			{
				if(this.getBankAgency().getAgencyAccount()[i] != null && this.getBankAgency().getAgencyAccount()[i].getId() == id)
					return true;
			}
		}
		
		return false;
	}
	
	
	public Account chercherCompteObjet( int id)
	{
		for(int i = 0 ; i < this.getBankAgency().getAgencyAccount().length ; i++)
		{
			if(this.getBankAgency().getAgencyAccount()[i] != null && this.getBankAgency().getAgencyAccount()[i].getId() == id)
				return this.getBankAgency().getAgencyAccount()[i];
		}
		return null;
	}
	
	
	public boolean verser(Double montant , int id)
	{
		if(this.chercherCompte(id) && montant > 0 && this.chercherCompteObjet(id).getLogsNumber() < 5)
		{
		
			this.chercherCompteObjet(id).setBalance(this.chercherCompteObjet(id).getBalance() + montant);
			this.chercherCompteObjet(id).setLogs("a eu un versement");
			return true;
		}
		return false;
	}
	
	
	public boolean retirer(double montant, int id)
	{
		if(this.chercherCompte(id) && montant > 0 && this.chercherCompteObjet(id).getLogsNumber() < 5)
		{
			
			
			this.chercherCompteObjet(id).setBalance(this.chercherCompteObjet(id).getBalance() - montant);
			this.chercherCompteObjet(id).setLogs("a fait retierement");
			return true;
		}
		
		 return false;
	}

	public boolean virement(Double montant , int id1 , int id2)
	{
		if(this.chercherCompte(id1) && this.chercherCompte(id2) && montant > 0)
		{
			if(this.chercherCompteObjet(id1).getBalance() >= montant && this.chercherCompteObjet(id1).getLogsNumber() < 5)
			{
				this.chercherCompteObjet(id1).setBalance(this.chercherCompteObjet(id1).getBalance() - montant);
				this.chercherCompteObjet(id1).setLogs("a fait retierement");
				this.chercherCompteObjet(id2).setBalance(this.chercherCompteObjet(id2).getBalance() + montant);
				return true;
			}
			
		return false;
		}
		return false;
	}
}