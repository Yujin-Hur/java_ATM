package ATM;

public class Account {
    public int userNum;
    public int accountNum; 
    public int password; 
    public double balance; 

   // initialize
   public Account(int userNum, int accountNum, int password, double balance){
       this.userNum = userNum; //list index
       this.accountNum = accountNum;
       this.password = password;
       this.balance = balance;
    }
    public void info(){
        //print info
    }
}

