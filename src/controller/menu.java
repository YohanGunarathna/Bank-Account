/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author Yohan Gunarathna
 */
public class menu {

    public static void mainMenu(Scanner input){
            System.out.println("");
            System.out.println("........................................");
            System.out.println("       WELCOME TO INNER BANKING PTY     ");
            System.out.println("........................................");
            System.out.println("");
            System.out.println("Enter '1' to Admin Login");
            System.out.println("Enter '2' to Exit" );
            System.out.println("");
            System.out.println("Enter your Choice");
            String choice=input.nextLine();

            switch(choice){


            case "1" :
                    Logic.login(input);
                    break;

            case "2" :
                    System.exit(0);
            break;

            default :
                    System.out.println("");
                    System.out.println("Invalid input");
                    System.out.println("");
                    mainMenu(input);
                    break;
            }


    }

    public static void mainMenuAcc(Scanner input){

            System.out.println("");
            System.out.println("..................................................");
            System.out.println("Enter the '1' to  Create Bank Account ");
            System.out.println("Enter the '2' to  Transfer Amount");
            System.out.println("Enter the '3' to  View Bank Account Details");
            System.out.println("Enter the '4' to  Create Document file");
            System.out.println("Enter the '5' to  Go the Back");
            System.out.println("Enter the '6' to  Exit");
            System.out.println("..................................................");
            System.out.println("");
            System.out.println("Enter your Choice");
            String choice=input.nextLine();

            switch(choice){

            case "1" :
                    menu.CreateAccount(input);
                    break;

            case "2" :
                    Logic.TransferMoney(input);
                    break;

            case "3" : 
                    menu.ViewBankDetails(input);
                    break;

            case "4" :
                    menu.fileWritermenu(input);
                    break;	

            case "5" :
                    mainMenu(input);
                    break;

            case "6" :
                    System.exit(0);
            break;

            default :
                    System.out.println("");
                    System.out.println("Invalid input");
                    System.out.println("");
                    mainMenuAcc(input);
                    break;
    }

}
    public static void fileWritermenu(Scanner input){
            System.out.println("");
            System.out.println("..................................................");
            System.out.println("Enter the '1' to  Get SavingsAccount Document File ");
            System.out.println("Enter the '2' to  Get CheckingAccount Document File");
            System.out.println("Enter the '3' to  Get CheckingAccountWithInterest Document File");

            System.out.println("..................................................");
            System.out.println("");
            System.out.println("Enter your Choice");
            String choice=input.nextLine();

            switch(choice){

            case "1" :
                    Logic.TextWriterSavingsAccount(input);
                    break;

            case "2" :
                    Logic.TextWriterCheckingAccount(input);
                    break;

            case "3" : 
                    Logic.TextWriterCheckingAccountWithInterest(input);
                    break;


            default :
                    System.out.println("");
                    System.out.println("Invalid input");
                    System.out.println("");
                    mainMenuAcc(input);
                    break;
    }

}


    public static void CreateAccount(Scanner input){

            System.out.println("");
            System.out.println("");
            System.out.println("...........................................");
            System.out.println("Select Account type");
            System.out.println("...........................................");
            System.out.println("Enter the '1' to  Create Savings Account ");
            System.out.println("Enter the '2' to  Create Checking Account");
            System.out.println("Enter the '3' to  Create Checking with Interest Account");
            System.out.println("Enter the '4' to  Go the Back");
            System.out.println("Enter the '5' to  Exit");
            System.out.println("...........................................");
            System.out.println("");
            System.out.println("Enter your Choice");
            String choice=input.nextLine();

            switch(choice){

            case "1" :
                    Logic.GetSavingsDetails(input);
                    break;

            case "2" :
                    Logic.GetCheckingAccountDetails(input);
                    break;

            case "3" :
                    Logic.GetCheckingAccountWithInterestDetails(input);
                    break;

            case "4" :
                    mainMenuAcc(input);
                    break;

            case "5" :
                    System.exit(0);
                    break;

            default :
                    System.out.println("");
                    System.out.println("Invalid input");
                    System.out.println("");
                    mainMenuAcc(input);
                    break;
    }

}

    public static void ViewBankDetails(Scanner input){

            System.out.println("");
            System.out.println("");
            System.out.println("...........................................");
            System.out.println("Select Account type");
            System.out.println("...........................................");
            System.out.println("Enter the '1' to  View Savings Account Details");
            System.out.println("Enter the '2' to  View Checking Account Details");
            System.out.println("Enter the '3' to  View Checking with Interest Account Details");
            System.out.println("Enter the '4' to  Go the Back");
            System.out.println("Enter the '5' to  Exit");
            System.out.println("...........................................");
            System.out.println("");
            System.out.println("Enter your Choice");
            String choice=input.nextLine();

            switch(choice){

            case "1" :
                    Logic.viewAllSavingsAccountDetails(input);
                    break;

            case "2" :
                    Logic.viewAllCheckingAccountDetails(input);
                    break;

            case "3" :
                    Logic.viewCheckingAccountWithInterestDetails(input);
                    break;

            case "4" :
                    mainMenuAcc(input);
                    break;

            case "5" :
                    System.exit(0);
            break;

            default :
                    System.out.println("");
                    System.out.println("Invalid input");
                    System.out.println("");
                    mainMenuAcc(input);
                    break;
    }

}
}
