package ATM;

public class Cash{
    private int Cash1_num = 200;
    private int Cash5_num = 100;

    public void putMoney(){
        Cash1_num += 200;
        Cash5_num += 100;
    }
    public void outMoney(int outCash1,int outCash5){
        Cash1_num -= outCash1;
        Cash5_num -= outCash5;
    };
    public boolean checkMoney(int reqCash1,int reqCash5){
        if (Cash1_num > reqCash1 && Cash5_num > reqCash5)
            return true;
        else
            return false;
    }
}