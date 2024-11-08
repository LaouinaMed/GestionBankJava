package controller;
import java.util.Scanner;

import Users.Admin;
import Users.User;
import entities.BankAgency;
import service.*;
public class Main {
	
	
	public static void afficherMenuCrud()
	{
		System.out.println("\n***************************************");
		System.out.println("Menu :                                   ");
		System.out.println("Creation d'un compte             : 1             ");
		System.out.println("Creation d'un client             : 2             ");
		System.out.println("Lier un client avec un compte    : 3             ");
		System.out.println("Chercher un compte               : 4             ");
		System.out.println("Chercher un client               : 5             ");
		System.out.println("Modification du compte           : 6             ");
		System.out.println("Modification du compte           : 7             ");
		System.out.println("Suppression du compte            : 8             ");
		System.out.println("Suppression d'un client          : 9             ");
		//System.out.println("Verser vers un compte    : 6             ");
		//System.out.println("Retirer dans compte      : 7             ");
		//System.out.println("Effectuer un virement    : 8             ");
		
		System.out.println("Pour sortir  de la session       : 0             ");
		System.out.println("*****************************************");
	}
	
	public static void afficherMenuTrasction()
	{
		System.out.println("\n***************************************");
		System.out.println("Menu Transaction :                                   ");
		System.out.println("Session Admin            : 1             ");
		System.out.println("Verser vers un compte    : 2             ");
		System.out.println("Retirer dans compte      : 3             ");
		System.out.println("Effectuer un virement    : 4             ");
		
		System.out.println("Pour sortir              : 0             ");
		System.out.println("*****************************************");
	}
	
	public static void main(String[] args) 
	{
		BankAgency BA = new BankAgency("BankX");
		BankService BS = new BankService();
		BS.SetBankAgency(BA);
		
		Admin admin = new Admin(BS);
		User u = new User();
		
		
		
		Scanner sc = new Scanner(System.in);
		int op; 
		int op2; 
		int test;
		do
		{
			 test = 0;
			afficherMenuTrasction();
			System.out.print("\nOption : ");
			op = sc.nextInt();
			//System.out.println("\n");
			String username1;
			String password1;
			
			switch(op) {
			
				case 1:
					do
					{
						
						if(test == 0)
						{
							test = 1;
							System.out.print("\nusername : ");
							username1 = sc.next();
						
							System.out.print("\npassword : ");
							password1 = sc.next();
							
							System.out.print("\n");
							
							
							if(admin.authentification(username1, password1) )
							{
								System.out.println("*********************************");
								System.out.println("********* Session Admin *********");
								System.out.println("*********************************\n");
								
							}
						
							else 
							{
								System.out.println("!!!!!!!!! username ou password incorrecrte !!!!!!!!!");
								break;
							}
						}
						
							afficherMenuCrud();
							System.out.print("\nOption : ");
							op2 = sc.nextInt();
							System.out.println("\n");
						
						switch(op2) {
						
							case 1:
								if(admin.getBankService().creerEtAjouterCompte()) 
								{
									System.out.println("\n[le compte a ete cree]\n");
									u.SetBankAgency(admin.getBankService().getBankAgency());
								}
								else 
									{
									System.out.println("\n[le compte n'a pas ete cree]\n");
									}
							break;
							

							case 2:
								if(admin.getBankService().creerEtAjouterClient()) System.out.println("\n[le client a ete cree]\n");
								else System.out.println("\n[le client n'a pas ete cree]\n");
							break;
							
							case 3:
								Scanner sc1 =new Scanner(System.in);
								System.out.print("\nEntrer Id du compte : ");
								int idCompte1 = sc1.nextInt();
								System.out.print("\nEntrer Id du client : ");
								int idclient1 = sc1.nextInt();
								
								
								if(admin.getBankService().lierCompteAuClient(idclient1, idCompte1)) System.out.println("\n[le client a  ete lie a son compte]\n");
								else System.out.println("\n[le client n'a pas ete  lie a son compte]\n");
							break;

							case 4:
								Scanner sc2 =new Scanner(System.in);
								System.out.print("\nEntrer Id du compte : ");
								int idCompte2 = sc2.nextInt();
								
								
								
								if(admin.getBankService().chercherCompteObjet(idCompte2) != null) 
								{
									System.out.println(admin.getBankService().chercherCompteObjet(idCompte2));
									System.out.print("\nConsulter les details du compte  1/0 : " );
									int x = sc2.nextInt();
									System.out.println("\n");
									if(x == 1)  admin.getBankService().consulterDetailCompte(idCompte2);
									else break;
								}
								else System.out.println("\n[le compte n'existe pas]\n");
							break;
							
							
							case 5:
								Scanner sc3 =new Scanner(System.in);
								System.out.print("\nEntrer Id du client : ");
								int idClient3 = sc3.nextInt();
								
								
								
								if(admin.getBankService().chercherClientObjet(idClient3) != null) 
								{
									System.out.println(admin.getBankService().chercherClientObjet(idClient3));
									System.out.print("\nConsulter les details du compte  1/0 : " );
									int x = sc3.nextInt();
									System.out.println("\n");
									if(x == 1)  admin.getBankService().consulterDetailClient(idClient3);
									else break;
								}
								else System.out.println("\n[le client n'existe pas]\n");
							break;
							
							
							case 6:
								Scanner sc4 =new Scanner(System.in);
								System.out.print("\nEntrer Id du compte : ");
								int idClient4 = sc4.nextInt();
								
								if( admin.getBankService().modifierCompte(idClient4)) System.out.println("\n[le compte a ete modofier]\n");
								else System.out.println("\n[le compte n'a pas ete cree]\n");
							break;
							
							
							case 7:
								Scanner sc5 =new Scanner(System.in);
								System.out.print("\nEntrer Id du compte : ");
								int idClient5 = sc5.nextInt();
								
								if(admin.getBankService().modifierClient(idClient5)) System.out.println("\n[le client a ete modifier]\n");
								else System.out.println("\n[le compte n'a pas ete modifier]\n");
							break;
							
							
							case 8:
								Scanner sc6 =new Scanner(System.in);
								System.out.print("\nEntrer Id du compte : ");
								int idClient6 = sc6.nextInt();
								
								if(admin.getBankService().supprimerCompte(idClient6)) System.out.println("\n[le compte a ete supprimer]\n");
								else System.out.println("\n[le compte n'a pas ete supprimer]\n");
							break;	
							
							
							case 9:
								Scanner sc7 =new Scanner(System.in);
								System.out.print("\nEntrer Id du compte : ");
								int idClient7 = sc7.nextInt();
								
								if(admin.getBankService().supprimerClient(idClient7)) System.out.println("\n[le client a ete supprimer]\n");
								else System.out.println("\n[le clinet n'a pas ete supprimer]\n");
							break;	
							
							
						}
					
					}while( op2 != 0 );
				break;
				
				case 2:
					
					Scanner sc7 =new Scanner(System.in);
					System.out.print("\nEntrer Id du compte : ");
					int idClient7 = sc7.nextInt();
					System.out.print("\nEntrer le montant : ");
					Double montant1 = sc7.nextDouble();
					if( u.verser(montant1 , idClient7 ) ) 
					{
						System.out.println("\n[le verssement a ete effectue]\n");
						//u.SetBankAgency(admin.getBankService().getBankAgency());
					}
					else System.out.println("\n[le verssement n'a pas ete effectue]\n");
				break;
				
				case 3:
					
					Scanner sc8 =new Scanner(System.in);
					System.out.print("\nEntrer Id du compte : ");
					int idClient8 = sc8.nextInt();
					System.out.print("\nEntrer le montant : ");
					Double montant2 = sc8.nextDouble();
					if( u.retirer(montant2 , idClient8 ) ) 
					{
						System.out.println("\n[le retiremment a ete effectue]\n");
						//u.SetBankAgency(admin.getBankService().getBankAgency());
					}
					else System.out.println("\n[le retirement n'a pas ete effectue]\n");
				break;
				
				
				case 4:
					
					Scanner sc9 =new Scanner(System.in);
					System.out.print("\nEntrer Id1 du compte : ");
					int idClient9 = sc9.nextInt();
					
					System.out.print("\nEntrer Id2 du compte : ");
					int idClient10 = sc9.nextInt();
					
					System.out.print("\nEntrer le montant : ");
					Double montant3 = sc9.nextDouble();
					if( u.virement(montant3, idClient9, idClient10))  
					{
						System.out.println("\n[le virement a ete effectue]\n");
						//u.SetBankAgency(admin.getBankService().getBankAgency());
					}
					else System.out.println("\n[le le virement n'a pas ete effectue]\n");
				break;
				
				case 0 :
					System.out.println("Fin du programme");
				break;
			}
			
		}while(op != 0 );
	}
}	
	


