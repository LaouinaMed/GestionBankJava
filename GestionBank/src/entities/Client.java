package entities;

import java.time.LocalDateTime;

public class Client {
	private static int counter = 1;
    private Integer id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String tel ;
    private String identity;
    private Account[] accounts = new Account[2];

    public String getIdentity() { return identity; }
    public void setIdentity(String identity) { this.identity = identity; }

    
    public static int getCounter() { return counter; }
    public static void setCounter(int counter) { Client.counter = counter; }


    public Integer getId() {  return id; }
    public void setId() { this.id = counter++ ; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public Account[] getAccounts() {
        return accounts;
    }

    public boolean setAccounts(Account account)
    {
        for( int i = 0  ; i<accounts.length ; i++)
        {
            if(accounts[i] == null)
            {
                accounts[i] = account ;
                return true ;
            }
        }
        return false ;
    }
    
    public Client()
    {
        setId();
    }
    
    public Client(String fn , String ln )
    {
        setId();
        setFirstName(fn);
        setLastName(ln);
    }

    @Override
    public boolean equals(Object other)
    {
        if (other instanceof Client)
            return this.id.equals(((Client) other).id);
        return false ;
    }
    @Override
    public String toString()
    {
        String clientString  = "";
        clientString +="------------ Account owner -----------\n";
        clientString +="--------------------------------------\n";
        clientString +="Account id :"+ id + "\n";
        clientString +="first name :"+firstName + "\n";
        clientString += "last name  "+lastName +"\n";
        clientString += "email  "+(email==null ? "Empty":email) +"\n";
        clientString += "identity  "+(identity==null ? "Empty":identity) +"\n";
        clientString +="--------------------------------------\n";

 

        return clientString  ;
    }
}
