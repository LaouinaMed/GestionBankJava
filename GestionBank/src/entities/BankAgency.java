package entities;

public class BankAgency {
	
	private static  int counter = 1;
    private Integer id ;
    private String agencyName ;
    private Integer agencyCapacity = 3 ;
    private Account[] agencyAccount ;
    private Client[] agencyClient ;


    public Integer getId() { return id; }
    public void setId(Integer id) {  this.id = id; }
    public void setId(){ this.id = counter++; }
    
    public String getAgencyName() { return agencyName; }
    public void setAgencyName(String agencyName) { this.agencyName = agencyName; }

    public Integer getAgencyCapacity() {return agencyCapacity; }
    public void setAgencyCapacity(Integer agencyCapacity) { this.agencyCapacity = agencyCapacity;}

    public Account[] getAgencyAccount() { return agencyAccount; }
    public void setAgencyAccount(Account[] agencyAccount) {  this.agencyAccount = agencyAccount; }
    
    
    public boolean setAgencyAccount(Account agencyAccount )
    {
    	for( int i = 0  ; i< this.agencyAccount.length ; i++)
    	{
    		if(this.agencyAccount[i] == null)
    		{
    			this.agencyAccount[i] = agencyAccount;
    			return true;
    		}
    	}
    	return false ;
    }
    
    public Client[] getAgencyClient() {  return agencyClient; }
    
    public void setAgencyClient(Client[] agencyClient) {  this.agencyClient = agencyClient; }
    
    public boolean setAgencyClient(Client agencyClient )
    {
    	for( int i = 0  ; i< this.agencyClient.length ; i++)
    	{
    		if(this.agencyClient[i] == null)
    		{
    			this.agencyClient[i] = agencyClient;
    			return true;
    		}
    	}
    	return false ;
    }
    
   public BankAgency(){
        setId();
        agencyClient = new Client[agencyCapacity];
        agencyAccount = new Account[agencyCapacity*2];

    }
    
    public BankAgency(String agencyName){
        setId();
        setAgencyName(agencyName);
        agencyClient = new Client[agencyCapacity];
        agencyAccount = new Account[agencyCapacity*2];

    }
    
    public String toString() 
    {
    	
    	String BankAgencyString  = "";
    	BankAgencyString +="\n\n-------------------------------------- \n";
    	BankAgencyString += "-------------BankAgency---------------\n";
    	BankAgencyString +="-------------------------------------- \n";
    	BankAgencyString += "BankAgency Id : " + this.id +"\n";
    	BankAgencyString += "BankAgency name : " + this.agencyName +"\n";
    	BankAgencyString += "BankAgency capacity : " + this.agencyCapacity +"\n";
    	BankAgencyString +="-------------------------------------- ";
    	
		   return BankAgencyString;
	}
}
