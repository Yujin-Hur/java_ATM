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
       {System.out.print("���¹�ȣ�� �Է��ϼ��� : ");
       Scanner input = new Scanner(System.in);
       String accountnum = input.next();
       
       if(DB.checkingId(accountnum)) {
          id = accountnum;
          int a=0;
          int b=0;
          int one_num=0;
          int five_num = 0;
          long check=0;
          System.out.print("���� ��� ��ȣ�� �Է��ϼ��� : ");
          int password = input.nextInt();
          if(DB.matchingPassword(id, password))
          {   
             while(b==0)
             {   
             System.out.print("������ �۾��� �����ϼ��� \n 1�� : �ܰ� ��ȸ, 2�� : �Ա�, 3�� : ��� 4�� : ����: \n ==>");
             int num = input.nextInt();
             switch(num) {
             
             case 1:
                System.out.printf("�ܾ� ��ȸ �����Դϴ�.\n�ش� ������ �ܾ��� : %d�� �Դϴ�!\n",DB.getBalance(id));
                break;
                
             case 2:
                System.out.printf("�Ա��� �ݾ��� �Է����ּ��� : ");
                long cash = input.nextLong();
                while(a==0)
                {
                   System.out.printf("�Ա� �� �������� ������ �Է����ּ���: ");
                one_num = input.nextInt();
                System.out.printf("�Ա� �� ���������� ������ �Է����ּ���: ");
                five_num = input.nextInt();
                check = cash - ((long)one_num*10000+(long)five_num*50000);
                if(check!=0)
                {
                   System.out.printf("�Ա� �� ���� ������ �ֽ��ϴ�.\n");
                }
                else
                {
                   a = 1;
                }
                }
                ATM.one = ATM.one+one_num;
                ATM.five = ATM.five+five_num;
                ATM.Deposit(DB, id,cash);
                
                
                System.out.printf("�Ա��� �Ϸ�Ǿ����ϴ�.\n�ش� ������ �ܾ��� : %d�� �Դϴ�!\n",DB.getBalance(id));
                
                break;
             case 3:
                a=0;
                System.out.printf("����� �ݾ��� �Է����ּ��� : ");
                long minus = input.nextLong();
                while(a==0)
                {
                   System.out.printf("��� �� �������� ������ �Է����ּ���: ");
                one_num = input.nextInt();
                System.out.printf("��� �� ���������� ������ �Է����ּ���: ");
                five_num = input.nextInt();
                check = minus - ((long)one_num*10000+(long)five_num*50000);
                if(check!=0)
                {
                   System.out.printf("��� �� ���� ������ �ֽ��ϴ�.\n");
                }
                else
                {
                   a = 1;
                }
                }
                ATM.one = ATM.one-one_num;
                ATM.five = ATM.five-five_num;
                ATM.WithDraw(DB, id, minus);
                System.out.printf("����� �Ϸ�Ǿ����ϴ�.\n�ش� ������ �ܾ��� : %d�� �Դϴ�!\n",DB.getBalance(id));
				
                
                break;
             
             case 4:
                b=1;
				// ATM.LogPrint(0);
                break;
             }
             }
          }
          else {
             System.out.print("��й�ȣ ����");
             
          }
       }
       else {
          System.out.print("id ����");
       }
       
    }
    }
   
   }