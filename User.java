package ATM;

import java.util.*;

public class User {
    static ArrayList<Account>userDB = new ArrayList<>();
    private int idxAccount; //curr_account
   
    public void createAccount(){
        Account master = new Account(0,0,0,0);
        Account account1 = new Account(1,1002,1234,0);
        Account account2 = new Account(2,1003,5678,0);
        userDB.add(master);
        userDB.add(account1);
        userDB.add(account2);
    }
    public void checkAccount(int accountNum){
        // id, password check
        // idxAccount = i;
    }

    public void getAccount(){

    }
    public void updateAccount(int money){
        userDB.get(idxAccount).balance += money;
    }
    
}
