package javaATM;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.util.Scanner;

public class main {
   
    static Scanner input = new Scanner(System.in);

    static ATM atm = new ATM(); 
    static DataBase DB = new DataBase(); 
    static String id;
    static int password;
   
    public static void main(String[] args) {
        while(true)
       {System.out.print("계좌번호를 입력하세요 : ");
       Scanner input = new Scanner(System.in);
       String accountnum = input.next();
       
       if(DB.checkingId(accountnum)) {
          id = accountnum;
          int a = 0;
          int b = 0;
          int one_num = 0;
          int five_num = 0;
          long check = 0;
          System.out.print("계좌 비밀 번호를 입력하세요 : ");
          int password = input.nextInt();
          if(DB.matchingPassword(id, password))
          {   
             while(b==0)
             {   
               
             System.out.print("\n-----------------------------------------------------------------------------------------\n");
             System.out.print("\n수행할 작업을 선택하세요 \n 1번 : 잔고 조회, 2번 : 입금, 3번 : 출금 4번 : 종료: \n ==> ");
             int num = input.nextInt();
             switch(num) {
             
             case 1:
                System.out.printf("잔액 조회 서비스입니다.\n해당 계좌의 잔액은 : %d원 입니다!\n",DB.getBalance(id));
                break;
                
             case 2:
                System.out.printf("입금할 금액을 입력해주세요 : ");
                long cash = input.nextLong();
                while(a == 0)
                {
                  System.out.printf("입금 할 만원권의 갯수를 입력해주세요: ");
                  one_num = input.nextInt(); 
                  System.out.printf("입금 할 오만원권의 갯수를 입력해주세요: ");
                  five_num = input.nextInt();
                  check = cash - ((long)one_num*10000+(long)five_num*50000);
                if(check != 0)
                {
                   System.out.printf("입금 할 지폐에 오류가 있습니다.\n");
                }
                else
                {
                   a = 1;
                }
                }
                ATM.one = ATM.one+one_num;
                ATM.five = ATM.five+five_num;
                ATM.Deposit(DB, id,cash);
                
                
                System.out.printf("입금이 완료되었습니다.\n해당 계좌의 잔액은 : %d원 입니다!\n",DB.getBalance(id));
                
                break;
             case 3:
                a=0;
                System.out.printf("출금할 금액을 입력해주세요 : ");
                long minus = input.nextLong();
                while(a == 0)
                {
                  System.out.printf("출금 할 만원권의 갯수를 입력해주세요: ");
                  one_num = input.nextInt();
                  System.out.printf("출금 할 오만원권의 갯수를 입력해주세요: ");
                  five_num = input.nextInt();
                  check = minus - ((long)one_num*10000+(long)five_num*50000);
                if(check!=0)
                {
                   System.out.printf("출금 할 지폐에 오류가 있습니다.\n");
                }
                else
                {
                   a = 1;
                }
                }
                ATM.one = ATM.one-one_num;
                ATM.five = ATM.five-five_num;
                if (ATM.one < 0 || ATM.five < 0)
                {
                  ATM.one = ATM.one + one_num;
                  ATM.five = ATM.five + five_num;
                  System.out.printf("ATM 지폐부족으로 출금이 실패하였습니다.\n");
                  break;
                }
                ATM.WithDraw(DB, id, minus);
                System.out.printf("출금이 완료되었습니다.\n해당 계좌의 잔액은 : %d원 입니다!\n",DB.getBalance(id));
				
                
                break;
             
             case 4:
                b=1;
                break;

             case 5:
               System.out.printf("관리자 비밀번호를 입력하세요: ");
               int admin = input.nextInt();
               if (admin == 1234)
               {
                  System.out.printf("관리자 메뉴입니다.\n" );
                  for (int i = 0; i < ATM.log.size() ; i++)
                  {
                     ATM.LogPrint(i);
                  }
                  System.out.printf("지폐를 추가하시겠습니까? Yes: 1 / No: 0 ");
                  int addCheck = input.nextInt();
                  if (addCheck == 1)
                  {
                     ATM.one = ATM.one + 1000;
                     ATM.five = ATM.five + 200;
                     System.out.printf("지폐가 추가되었습니다.\n 현재 1만원권 %d장 5만원권 %d장 입니다!\n",ATM.one,ATM.five);
                  }
                  break;
               }
               break;
             }
             }
          }
          else {
             System.out.print("잘못된 비밀번호입니다. \n");
             
          }
       }
       else {
          System.out.print("존재하지 않는 계좌번호입니다. \n");
       }
       
    }
    }
   
   }