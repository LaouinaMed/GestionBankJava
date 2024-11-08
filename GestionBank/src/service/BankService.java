package service;
import  entities.*;
import  service.*;
import java.util.*;

public class BankService {
	
	private BankAgency bankAgency ;
	//private AccountService accountsBankAgency;
	
	public BankService() {}
	
	public void SetBankAgency(BankAgency bankAgency)
	{
		this.bankAgency = bankAgency;
	}
	
	public BankAgency getBankAgency()
	{
		return bankAgency;
		
	}
	
	public boolean chercherCompte2( int id)
	{
		for(int i = 0 ; i < this.getBankAgency().getAgencyAccount().length ; i++)
		{
			if(this.getBankAgency().getAgencyAccount()[i] != null && this.getBankAgency().getAgencyAccount()[i].getId() == id)
				return true;
		}
		return false;
	}
	
	
	public boolean chercherClient( int id)
	{
		for(int i = 0 ; i < this.getBankAgency().getAgencyClient().length ; i++)
		{
			if(this.getBankAgency().getAgencyClient()[i] != null && this.getBankAgency().getAgencyClient()[i].getId() == id)
				return true;
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
	
	public Client chercherClientObjet( int id)
	{
		for(int i = 0 ; i < this.getBankAgency().getAgencyClient().length ; i++)
		{
			if(this.getBankAgency().getAgencyClient()[i] != null && this.getBankAgency().getAgencyClient()[i].getId() == id)
				return this.getBankAgency().getAgencyClient()[i];
		}
		return null;
	}
	
	
	public boolean creerEtAjouterCompte()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n[Creation du compte]\n");
		
		System.out.print("Solde : ");
		Double solde = sc.nextDouble();
		
		Account c1 = new Account();
		c1.setBalance(solde);
		
		if( !(chercherCompte2( c1.getId() ) ) )
		{
			for(int i = 0 ; i<this.getBankAgency().getAgencyAccount().length ; i++)
			{
				if(this.getBankAgency().getAgencyAccount()[i] == null)
				{
					this.getBankAgency().setAgencyAccount(c1);
					return true;
				}
			}
		}
		return false;
		
	}
	
	

	
	public boolean creerEtAjouterClient()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\n[Creation du client]\n");
		
		System.out.print("FirstName : ");
		String fn = sc.next();
		
		System.out.print("LastName : ");
		String ln = sc.next();
		
		System.out.print("Email : ");
		String email = sc.next();
		
		System.out.print("Tel : ");
		String tel = sc.next();
		
		System.out.print("CIN : ");
		String cin = sc.next();
		
		Client client1 = new Client(fn,ln);
		client1.setEmail(email);
		client1.setIdentity(cin);
		client1.setTel(tel);
		
		if( !(chercherClient(client1.getId())) )
		{
			for(int i = 0 ; i < this.getBankAgency().getAgencyClient().length ; i++)
			{
				if(this.getBankAgency().getAgencyClient()[i] == null)
				{
					this.getBankAgency().setAgencyClient(client1);
					return true;
				}
			}
		}
		return false;
		
	}
	
	public boolean lierCompteAuClient (int idClient, int idCompte)
	{
		if(chercherClient(idClient))
		{
			if(chercherCompte2(idCompte))
			{
				if(this.chercherClientObjet(idClient).setAccounts(this.chercherCompteObjet(idCompte)))
				{
					this.chercherCompteObjet(idCompte).setOwner(this.chercherClientObjet(idClient));
					return true;
				}
					
				else return false;
			}
			return false;
		}
		
		return false;	
	}
	
	
	public void consulterDetailCompte(int id)
	{
		if(this.chercherCompte2(id))
		{
			System.out.println(this.getBankAgency());
			System.out.println(this.chercherCompteObjet(id).showInformation());
			for(int i = 0 ; i < this.chercherCompteObjet(id).getLogsNumber() ; i++)
			{
				System.out.print("--------------------------------------\n");
				System.out.println("\nLog "+ (i+1) +" : "+ this.chercherCompteObjet(id).getLogs()[i]);
			}	
		}	
		else System.out.println("Compte n'existe pas");
	}
	
	
	public void consulterDetailClient(int id)
	{
		if(this.chercherClient(id))
		{
			System.out.println(this.getBankAgency());
			System.out.println(this.chercherClientObjet(id));
			for(int i = 0 ; i < this.chercherClientObjet(id).getAccounts().length ; i++)
			{
				if(this.chercherClientObjet(id).getAccounts()[i] != null)
				{
					
					System.out.println(this.chercherClientObjet(id).getAccounts()[i]);
				}
				
			}	
		}
		
		else System.out.println("Client n'existe pas");
	}
	
	
	public boolean modifierCompte(int id)
	{
		if(this.chercherCompte2(id))
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("\n[Modification du compte]\n");
			System.out.print("Solde : ");
			Double solde = sc.nextDouble();
			this.chercherCompteObjet(id).setBalance(solde);
			return true;
		}
		return false;
	}
	
	
	public boolean modifierClient(int id)
	{
		if(this.chercherClient(id))
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("\n[Modification du client]\n");
			System.out.print("FirstName : ");
			String fn = sc.next();
			
			System.out.print("LirstName : ");
			String ln = sc.next();
			
			System.out.print("Email : ");
			String email = sc.next();
			
			System.out.print("Tel : ");
			String tel = sc.next();
			
			System.out.print("CIN : ");
			String cin = sc.next();
			this.chercherClientObjet(id).setFirstName(fn);
			this.chercherClientObjet(id).setLastName(ln);
			this.chercherClientObjet(id).setEmail(email);
			this.chercherClientObjet(id).setTel(tel);
			this.chercherClientObjet(id).setIdentity(cin);
			return true;
		}
		return false;
	}
	
	public boolean supprimerClient( int id )
	{
		if(this.chercherClient(id))
		{
			for(int i = 0 ; i < this.getBankAgency().getAgencyClient().length ; i++)
			
				if(this.getBankAgency().getAgencyAccount()[i] != null && this.getBankAgency().getAgencyClient()[i].getId() == id)
				{ 
					for(int z = 0 ;z < this.getBankAgency().getAgencyClient()[i].getAccounts().length; z++) 
					{
						if(this.getBankAgency().getAgencyClient()[i].getAccounts()[z] != null)
						{
							this.supprimerCompte(this.getBankAgency().getAgencyClient()[i].getAccounts()[z].getId());
						}
					}
				}
			
				for(int i = 0 ; i < this.getBankAgency().getAgencyClient().length ; i++)
				{
					for(int j = i ; j < this.getBankAgency().getAgencyClient().length-1 ;j++)
					{
						if(this.getBankAgency().getAgencyClient()[j+1] != null)
						{
							this.getBankAgency().getAgencyClient()[j] = this.getBankAgency().getAgencyClient()[j+1];
						}
						else this.getBankAgency().getAgencyClient()[j] = null;
					}	
				}
					
				
				return true;
			}
			
		return false;
	}
	
	public boolean supprimerCompte( int id)
	{
		if(this.chercherCompte2(id))
		{
			for(int i = 0 ; i < this.getBankAgency().getAgencyAccount().length ; i++)
			{
				if( this.getBankAgency().getAgencyAccount()[i] != null && this.getBankAgency().getAgencyAccount()[i].getId() == id )
				{
					for(int j = i ; j < this.getBankAgency().getAgencyAccount().length-1 ; j++)
					{
						if(this.getBankAgency().getAgencyAccount()[j+1] != null )
						{
							this.getBankAgency().getAgencyAccount()[j] = this.getBankAgency().getAgencyAccount()[j+1];
							
						}
						else this.getBankAgency().getAgencyAccount()[j] = null;
							
					}
					
				}
			}
			
			if(this.getBankAgency().getAgencyClient() != null)
			{
				for(int i = 0 ; i < this.getBankAgency().getAgencyClient().length ; i++)
				{
					if(this.getBankAgency().getAgencyClient()[i] != null)
					{
						for(int j = 0 ; j < this.getBankAgency().getAgencyClient()[i].getAccounts().length ; j++)
						{
							if( this.getBankAgency().getAgencyClient()[i].getAccounts()[j] != null && this.getBankAgency().getAgencyClient()[i].getAccounts()[j].getId() == id)
							{
								if(j == 0)
								{
									this.getBankAgency().getAgencyClient()[i].getAccounts()[j] = this.getBankAgency().getAgencyClient()[i].getAccounts()[j+1];
									this.getBankAgency().getAgencyClient()[i].getAccounts()[j+1] = null;
								}
								
								else
									this.getBankAgency().getAgencyClient()[i].getAccounts()[j] = null;
									
							}
						}
					}
					
				}
			}
		
			return true;
		}
		return false;
	}
	
	
	
}
