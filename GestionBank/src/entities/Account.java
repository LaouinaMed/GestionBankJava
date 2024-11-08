package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


public class Account {
	
	 	private static int counter= 1;
	    private Integer id ;
	    private LocalDateTime creationDate ;
	    private Double balance ;
	    private String[] logs = new String[5];
	    private Client owner ;

	    public static int getCounter() { return counter; }
	    public static void setCounter(int counter) { Account.counter = counter; }

	    public Integer getId() { return id; }
	    public void setId(Integer id) { this.id = id; }
	    public void setId(){this.id = counter++ ;}

	    public LocalDateTime getCreationDate() { return creationDate; }

	    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
	    public void setCreationDate() { this.creationDate = LocalDateTime.now(); }
	    
	    
	    public Double getBalance() { return balance; }
	    
	    public void setBalance(Double balance) {
	        if (balance >= 0)
	            this.balance = balance;
	        else
	            this.balance = Double.valueOf(0);
	    }

	    public String[] getLogs() {
	        return logs;
	    }
	    
	    public int getLogsNumber() {
	    	int i = 0;
	    	for(int j = 0 ; j < logs.length ; j++ )
	    	{
	    		if(logs[j] != null)
	    			i++;
	    	}
	    	return i;
	    }

	    public void setLogs(String log) {

	        Date now = new Date();
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	        String dateString = formatter.format(now);

	        log ="["+dateString+"] => "+ log ;
	        for (int i = 0 ; i<logs.length ; i++ )
	        {
	            if(logs[i] == null) {
	                logs[i] = log;
	                break;
	            }
	        }

	    }

	    public Client getOwner() {
	        return owner;
	    }

	    public void setOwner(Client owner) {
	        this.owner = owner;
	    }
	    
	    public Account()
	    {
	        setId();
	        setCreationDate();
	        setBalance(0.0);
	        setLogs("Creation du Compte");

	    }
	    
	    @Override
	    public boolean equals(Object other)
	    {
	        if (other instanceof Account)
	            return this.id.equals(((Account) other).id);
	        return false ;
	    }
	    
	    @Override
	    public String toString()
	    {
	    	
	        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	        //String dateString = formatter.format(creationDate);
		        
	        String accountString = "";
	        accountString +="-------------- Acoount ---------------\n";
	        accountString += "--------------------------------------\n";
	        accountString +="Account id :"+ id + "\n";
	        accountString +="Balance :"+ balance + "\n";
	        
	        accountString += "Created at "+ creationDate+"\n";
	        accountString +="-------------------------------------- \n";
	       
	    return accountString ;
	    }
	    public String showInformation()
	    {
	        String accountString = "";
	        accountString +="-------------- Acoount ---------------\n";
	        accountString +="-------------------------------------- \n";
	        accountString +="Account id :"+ id + "\n";
	        accountString +="Balance :"+balance + "\n";
	        accountString +="Created at "+ creationDate+"\n";
	        accountString +="-------------------------------------- \n";
	        ;
	        if(owner != null)
	            accountString += owner.toString() ;
	        accountString +="------------ Account logs ------------";
	        
	        return accountString;
	    }
}
