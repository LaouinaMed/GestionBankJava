package entities;

public class Bank {
	
	private BankAgency[] banks = new BankAgency[10];
	
	
	
	public void setBanks(BankAgency[] banks)
	{
		this.banks = banks;
	}
	
	public boolean setBanks(BankAgency b)
	{
		for( int i = 0  ; i<banks.length ; i++)
		{
			
			if(banks[i] == null)
			{
				banks[i] = b;
				return true;
			}
		}
		return false ;
	}
	
	public BankAgency[] getBanks()
	{
		return banks;
	}
	
	
	public Bank() {}
	

}
