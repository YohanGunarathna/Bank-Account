/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yohan Gunarathna
 */
public class Logic {
	static int amountCredite=0;
	static int AccNum=0;
	static int AccNumTrans=0;
	static int AmountTrans=0;
	static int deposit=0;
	static int bsb=0;
	static int postcode=0;
	static int Mfee=0;
	static int NoCheques=0;

	static ArrayList <SavingsAccount> SavingsAccount =new ArrayList <SavingsAccount>();
	static ArrayList <CheckingAccountWithInterest> CheckingAccountWithInterest =new ArrayList <CheckingAccountWithInterest>();
	static ArrayList <CheckingAccount> CheckingAccount =new ArrayList <CheckingAccount>();
	static ArrayList <BankBranch> BankBranch =new ArrayList <BankBranch>();

	static int debitBalance=0;
    static int crediteBalance=0;
    
    public static void login(Scanner input){
	
	System.out.println("Enter the User Name");
	String name=input.nextLine();
	System.out.println("Enter the Password");
	String pass=input.nextLine();
	
	if(name.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
		menu.mainMenuAcc(input);
	}else{
		System.out.println("");
		System.out.println("Invalid password");
		System.out.println("");
		login(input);
	}

	
}

public static void GetSavingsDetails(Scanner input){
	
	System.out.println("");
	System.out.println("Create Savings Account ");
	System.out.println("");
	for(int accountCount=0;accountCount<10;accountCount++){
	System.out.println("Enter the Customer Name (Go to Back Enter 'Back')");
	String name=input.nextLine();
	
	if(name.equalsIgnoreCase("BACK")){
		menu.mainMenuAcc(input);	
	}
	
	AccNum=(int)(Math.random() * ((9999 - 1000) + 1)) + 1000;
	
	System.out.println("");
	System.out.println("Your Account Number  : "+AccNum);
	System.out.println("");

	//Validation for bsb number
	boolean isbsbnumOk=false;
	while(!isbsbnumOk){
		try{
		System.out.println("Enter the BSB Number");
		bsb=Integer.parseInt(input.nextLine());	
		isbsbnumOk=true;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	//Validation for postcode
	boolean ispostcodenumOk=false;
	while(!ispostcodenumOk){
		try{
		System.out.println("Enter the Post Code");
		postcode=Integer.parseInt(input.nextLine());	
		ispostcodenumOk=true;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	System.out.println("Enter the Address ");
	String address=input.nextLine();
	
	System.out.println("Enter the NIC number");
	String NicNum=input.nextLine();
	
	System.out.println("Enter the password");
	String Pass=input.nextLine();
	
	//Validation for Deposit
		boolean isDepositOk=false;
		
		while(!isDepositOk){
			try{
				System.out.println("Deposit");
				deposit=Integer.parseInt(input.nextLine());
			
				if(deposit>100000) {
					System.out.println("");
					System.out.println("Account balance is reaching to the $100000");
					GetSavingsDetails(input);
				}
			else if(deposit<0) {
					System.out.println("");
					System.out.println("Account balance cannot be less than $0");
					GetSavingsDetails(input);
				}
				
				
				isDepositOk=true;
			}catch(Exception ex){
				System.out.println("");
				System.out.println("Invalid Input");
				System.out.println("");
				continue;
				
			}
		}
	
	
		SavingsAccount objOne = new SavingsAccount(name,AccNum,NicNum,Pass,deposit);
		BankBranch objTwo = new BankBranch(bsb,address,postcode,AccNum);

		SavingsAccount.add(objOne);
		BankBranch.add(objTwo);
		
	System.out.println("");
	System.out.println("Registration Successfull");
	System.out.println("");
	}

		menu.mainMenuAcc(input);	
	
}

public static void GetCheckingAccountWithInterestDetails(Scanner input){
	
	System.out.println("");
	System.out.println("Create Checking Account With Interest Account ");
	System.out.println("");
	for(int accountCount=0;accountCount<5;accountCount++){
	System.out.println("Enter the Customer Name (Go to Back Enter 'Back')");
	String name=input.nextLine();
	
	if(name.equalsIgnoreCase("BACK")){
		menu.mainMenuAcc(input);	
	}
	
	AccNum=(int)(Math.random() * ((9999 - 1000) + 1)) + 1000;
	System.out.println("");
	System.out.println("Your Account Number  : "+AccNum);
	System.out.println("");

	//Validation for bsb number
	boolean isbsbnumOk=false;
	while(!isbsbnumOk){
		try{
		System.out.println("Enter the BSB Number");
		bsb=Integer.parseInt(input.nextLine());	
		isbsbnumOk=true;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	//Validation for postcode
	boolean ispostcodenumOk=false;
	while(!ispostcodenumOk){
		try{
		System.out.println("Enter the Post Code");
		postcode=Integer.parseInt(input.nextLine());	
		ispostcodenumOk=true;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	System.out.println("Enter the Address ");
	String address=input.nextLine();
	
	System.out.println("Enter the NIC number");
	String NicNum=input.nextLine();
	
	System.out.println("Enter the password");
	String Pass=input.nextLine();
	
	//Validation for AccNumber
		boolean isDepositOk=false;
		
		while(!isDepositOk){
			try{
				System.out.println("Deposit");
				deposit=Integer.parseInt(input.nextLine());
			
				if(deposit>100000) {
					System.out.println("");
					System.out.println("Account balance is reaching to the $100000");
					GetSavingsDetails(input);
				}
			else if(deposit<0) {
					System.out.println("");
					System.out.println("Account balance cannot be less than $0");
					GetSavingsDetails(input);
				}
				
				
				isDepositOk=true;
			}catch(Exception ex){
				System.out.println("");
				System.out.println("Invalid Input");
				System.out.println("");
				continue;
				
			}
		}
	
	
		CheckingAccountWithInterest objOne = new CheckingAccountWithInterest(name,AccNum,NicNum,Pass,deposit);
		BankBranch objTwo = new BankBranch(bsb,address,postcode,AccNum);

		CheckingAccountWithInterest.add(objOne);
		BankBranch.add(objTwo);
		
	System.out.println("");
	System.out.println("Registration Successfull");
	System.out.println("");
	}

		menu.mainMenuAcc(input);	
	
}

public static void GetCheckingAccountDetails(Scanner input){
	
	System.out.println("");
	System.out.println("Create Checking Account");
	System.out.println("");
	for(int accountCount=0;accountCount<10;accountCount++){
	System.out.println("Enter the Customer Name (Go to Back Enter 'Back')");
	String name=input.nextLine();
	
	if(name.equalsIgnoreCase("BACK")){
		menu.mainMenuAcc(input);	
	}
	
	AccNum=(int)(Math.random() * ((9999 - 1000) + 1)) + 1000;
	System.out.println("");
	System.out.println("Your Account Number  : "+AccNum);
	System.out.println("");

	//Validation for bsb number
	boolean isbsbnumOk=false;
	while(!isbsbnumOk){
		try{
		System.out.println("Enter the BSB Number");
		bsb=Integer.parseInt(input.nextLine());	
		isbsbnumOk=true;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	//Validation for postcode
	boolean ispostcodenumOk=false;
	while(!ispostcodenumOk){
		try{
		System.out.println("Enter the Post Code");
		postcode=Integer.parseInt(input.nextLine());	
		ispostcodenumOk=true;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	System.out.println("Enter the Address ");
	String address=input.nextLine();
	
	//Validation for Monthly Fee 
		boolean isMfeeOk=false;
		while(!isMfeeOk){
			try{
			System.out.println("Enter the Monthly Fee ");
			Mfee=Integer.parseInt(input.nextLine());	
			isMfeeOk=true;
			}catch(Exception ex){
				System.out.println("");
				System.out.println("Invalid Input");
				System.out.println("");
				continue;
				
			}
		}
	
		//Validation for Number of Cheques 
				boolean isNoChequesOk=false;
				while(!isNoChequesOk){
					try{
					System.out.println("Number of Cheques ");
					NoCheques=Integer.parseInt(input.nextLine());	
					isNoChequesOk=true;
					}catch(Exception ex){
						System.out.println("");
						System.out.println("Invalid Input");
						System.out.println("");
						continue;
						
					}
				}
				
				
	System.out.println("Enter the NIC number");
	String NicNum=input.nextLine();
	
	System.out.println("Enter the password");
	String Pass=input.nextLine();
	
	//Validation for AccNumber
		boolean isDepositOk=false;
		
		while(!isDepositOk){
			try{
				System.out.println("Deposit");
				deposit=Integer.parseInt(input.nextLine());
			
				if(deposit>100000) {
					System.out.println("");
					System.out.println("Account balance is reaching to the $100000");
					GetSavingsDetails(input);
				}
			else if(deposit<0) {
					System.out.println("");
					System.out.println("Account balance cannot be less than $0");
					GetSavingsDetails(input);
				}
				
				
				isDepositOk=true;
			}catch(Exception ex){
				System.out.println("");
				System.out.println("Invalid Input");
				System.out.println("");
				continue;
				
			}
		}
	
	
		CheckingAccount objOne = new CheckingAccount(name,AccNum,NicNum,Pass,deposit,Mfee,NoCheques);
		BankBranch objTwo = new BankBranch(bsb,address,postcode,AccNum);

		CheckingAccount.add(objOne);
		BankBranch.add(objTwo);
		
	System.out.println("");
	System.out.println("Registration Successfull");
	System.out.println("");
	}

		menu.mainMenuAcc(input);	
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////

public static void viewAllSavingsAccountDetails(Scanner input){
	int customer=1;
	int AccountNumber=0;
	for(SavingsAccount a : SavingsAccount){
		System.out.println("");
		System.out.println("..............Start of the report.............");
		System.out.println("   ("+customer+")    ");
		System.out.println("Interest Rate : 3%");
		System.out.println("");
		System.out.println("Customer Name           : "+a.getName());
		System.out.println("Customer Account Number : "+a.getAccNum());
		AccountNumber=a.getAccNum();
		for(BankBranch b : BankBranch){
			if(AccountNumber==b.AccountNum){
		System.out.println("BSB Number              : "+b.BSBnumber);
		System.out.println("Post Code               : "+b.PostCode);
		System.out.println("Address                 : "+b.Address);
			}
		}
		System.out.println("Customer NIC Number     : "+a.getNicNum());
		System.out.println("password                : "+a.getPass());
		System.out.println("Balance                 : "+a.getDeposit());
		customer++;
	}
	System.out.println("");
	System.out.println("...............End of the report..............");
	System.out.println("");
	System.out.println("Go to Back Enter 'Back' ");
	String choice=input.next();
	if(choice.equalsIgnoreCase("BACK")){
		input.nextLine();
		menu.mainMenuAcc(input);
}
}

public static void viewAllCheckingAccountDetails(Scanner input){
	int customer=1;
	int AccountNumber=0;
	for(CheckingAccount a : CheckingAccount){
		System.out.println("");
		System.out.println("..............Start of the report.............");
		System.out.println("   ("+customer+")    ");
		System.out.println("Interest Rate : 0%");
		System.out.println("");		
		System.out.println("Customer Name            : "+a.getName());
		System.out.println("Customer Account Number  : "+a.getAccNum());
		AccountNumber=a.getAccNum();
		for(BankBranch b : BankBranch){
			if(AccountNumber==b.AccountNum){
		System.out.println("BSB Number               : "+b.BSBnumber);
		System.out.println("Post Code                : "+b.PostCode);
		System.out.println("Address                  : "+b.Address);
			}
		}
		System.out.println("Monthly Fee              : "+a.Mfee);
		System.out.println("Number Of Cheques        : "+a.NoCheques);
		System.out.println("Customer NIC Number      : "+a.getNicNum());
		System.out.println("password                 : "+a.getPass());
		System.out.println("Balance                  : "+a.getDeposit());
		customer++;
	}
	System.out.println("");
	System.out.println("...............End of the report..............");
	System.out.println("");
	System.out.println("Go to Back Enter 'Back' ");
	String choice=input.next();
	if(choice.equalsIgnoreCase("BACK")){
		input.nextLine();
		menu.mainMenuAcc(input);
}
}	

public static void viewCheckingAccountWithInterestDetails(Scanner input){
	int customer=1;
	int AccountNumber=0;
	
	for(CheckingAccountWithInterest a : CheckingAccountWithInterest){
		System.out.println("");
		System.out.println("..............Start of the report.............");
		System.out.println("   ("+customer+")    ");
		System.out.println("Interest Rate : 0.02%");
		System.out.println("");
		System.out.println("Customer Name            : "+a.getName());
		System.out.println("Customer Account Number  : "+a.getAccNum());
		AccountNumber=a.getAccNum();
		for(BankBranch b : BankBranch){
			if(AccountNumber==b.AccountNum){
		System.out.println("BSB Number               : "+b.BSBnumber);
		System.out.println("Post Code                : "+b.PostCode);
		System.out.println("Address                  : "+b.Address);
			}
		}
		System.out.println("Customer NIC Number      : "+a.getNicNum());
		System.out.println("password                 : "+a.getPass());
		System.out.println("Balance                  : "+a.getDeposit());
		customer++;
	}
	System.out.println("");
	System.out.println("...............End of the report..............");
	System.out.println("");
	System.out.println("Go to Back Enter 'Back' ");
	String choice=input.next();
	if(choice.equalsIgnoreCase("BACK")){
		input.nextLine();
		menu.mainMenuAcc(input);
}
}

////////////////////////////////////////////////////////////////////////////////////////////////// 
public static void TransferMoney(Scanner input){
	System.out.println("Welcome to Transaction Department ");
	System.out.println("");
	System.out.println("Enter '1' for normal Transaction ");
	System.out.println("Enter '2' for Standing Order Transaction ");
	System.out.println("");
System.out.println("Select Your Transaction");
String choice=input.nextLine();
switch(choice){

case "1": 
	System.out.println("Normal Transaction ");
	System.out.println("");
	NormalTransaction(input);
	break;

case "2" :
	System.out.println("Standing Order Transaction");
	StandingOrderTransaction(input);
	System.out.println("");
}
    
}
///////////////////////////////////////////////////////////////////////////////////////////////////

public static void TextWriterSavingsAccount(Scanner input){
	
	File file=new File("SavingsAccount.txt");
	try{
	PrintWriter output=new PrintWriter(file);

	int customer=1;
	int AccountNumber=0;
	for(SavingsAccount a : SavingsAccount){
		output.println("");
		output.println("   ("+customer+")    ");
		output.println("Interest Rate : 3%");
		output.println("");
		output.println("Customer Name  "+a.getName());
		output.println("Customer Account Number  "+a.getAccNum());
		AccountNumber=a.getAccNum();
		for(BankBranch b : BankBranch){
			if(AccountNumber==b.AccountNum){
				output.println("BSB Number "+b.BSBnumber);
				output.println("Post Code "+b.PostCode);
				output.println("Address "+b.Address);
			}
		}
		output.println("Customer NIC Number  "+a.getNicNum());
		output.println("password  "+a.getPass());
		output.println("Balance  "+a.getDeposit());
		customer++;
	}
	output.close();
	}catch(IOException ex){
		System.out.println(ex);
	}
	
	System.out.println("");
	System.out.println("Go to Back Enter 'Back' ");
	String choice=input.next();
	if(choice.equalsIgnoreCase("BACK")){
		input.nextLine();
		menu.mainMenuAcc(input);
	}
	
	
}

//////////////////////////////////////////////////////////////////////////
public static void TextWriterCheckingAccountWithInterest(Scanner input){
	
	File file=new File("CheckingAccountWithInterest.txt");
	try{
	PrintWriter output=new PrintWriter(file);

	int customer=1;
	int AccountNumber=0;
	for(CheckingAccountWithInterest a : CheckingAccountWithInterest){
		output.println("");
		output.println("   ("+customer+")    ");
		output.println("Interest Rate : 3%");
		output.println("");
		output.println("Customer Name   : "+a.getName());
		output.println("Customer Account Number   : "+a.getAccNum());
		AccountNumber=a.getAccNum();
		for(BankBranch b : BankBranch){
			if(AccountNumber==b.AccountNum){
				output.println("BSB Number  : "+b.BSBnumber);
				output.println("Post Code  : "+b.PostCode);
				output.println("Address  : "+b.Address);
			}
		}
		output.println("Customer NIC Number  : "+a.getNicNum());
		output.println("password  : "+a.getPass());
		output.println("Balance  : "+a.getDeposit());
		customer++;
	}
	output.close();
	}catch(IOException ex){
		System.out.println(ex);
	}
	System.out.println("");
	System.out.println("Go to Back Enter 'Back' ");
	String choice=input.next();
	if(choice.equalsIgnoreCase("BACK")){
		input.nextLine();
		menu.mainMenuAcc(input);
	}
	
	
}

public static void TextWriterCheckingAccount(Scanner input){
	
	File file=new File("CheckingAccount.txt");
	try{
	PrintWriter output=new PrintWriter(file);

	int customer=1;
	int AccountNumber=0;
	for(CheckingAccount a : CheckingAccount){
		output.println("");
		output.println("   ("+customer+")    ");
		output.println("Interest Rate : 3%");
		output.println("");
		output.println("Customer Name  : "+a.getName());
		output.println("Customer Account Number  : "+a.getAccNum());
		AccountNumber=a.getAccNum();
		for(BankBranch b : BankBranch){
			if(AccountNumber==b.AccountNum){
				output.println("BSB Number  : "+b.BSBnumber);
				output.println("Post Code  : "+b.PostCode);
				output.println("Address  : "+b.Address);
			}
		}
		output.println("Monthly Fee  : "+a.Mfee);
		output.println("Number Of Cheques  : "+a.NoCheques);
		output.println("Customer NIC Number  : "+a.getNicNum());
		output.println("password : "+a.getPass());
		output.println("Balance  : "+a.getDeposit());
		customer++;
	}
	output.close();
	}catch(IOException ex){
		System.out.println(ex);
	}
	
	System.out.println("");
	System.out.println("Go to Back Enter 'Back' ");
	String choice=input.next();
	if(choice.equalsIgnoreCase("BACK")){
		input.nextLine();
		menu.mainMenuAcc(input);
	}
	
}
public static void NormalTransaction(Scanner input){

    int RelAccNum;
    int ValidateValue = 0;
    int ValidateNew = 0;
	System.out.println("");
	
	
	boolean isAccnumOk=false;
	boolean isOk=true;
	int RelCustomer;
	while(!isAccnumOk){
		try{
			System.out.println("Enter your Account Number");
			AccNum=Integer.parseInt(input.nextLine());
		for(SavingsAccount a : SavingsAccount){
			RelCustomer = a.getAccNum();
			if(RelCustomer==AccNum){
			ValidateValue=a.getDeposit();	
				isOk=false;
			}
			
			}	
		for(CheckingAccount a : CheckingAccount){
			RelCustomer = a.getAccNum();
			if(RelCustomer==AccNum){
				isOk=false;
			}
			}
		if(isOk==false){
			isAccnumOk=true;
		}

		continue;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	System.out.println("");
	for(SavingsAccount a : SavingsAccount){
		RelAccNum = a.getAccNum();
		
		if(RelAccNum==AccNum){
		System.out.println("Name - "+a.getName());
		System.out.println("Your Current Balance is  "+a.getDeposit());	
		}
		}	
	System.out.println("");
	for(CheckingAccount a : CheckingAccount){
		RelAccNum = a.getAccNum();
		if(RelAccNum==AccNum){
		System.out.println("Name - "+a.getName());
		System.out.println("Your Current Balance is  "+a.getDeposit());	
		}
		}	
	
	
	System.out.println("");
	
	boolean isAccnumTransOk=false;
	boolean isOkTrans=true;
	int RelCustomerTrans;
	
	while(!isAccnumTransOk){
		try{
		System.out.println("Transfer Account Number");
		AccNumTrans=Integer.parseInt(input.nextLine());
		System.out.println("");
		for(SavingsAccount a : SavingsAccount){
			RelCustomerTrans = a.getAccNum();
			
			ValidateNew=a.getDeposit();
			
			if(AccNum==AccNumTrans) {
				System.out.println("Invalid Account number");
				System.out.println("Account number cannot be same");
				TransferMoney(input);
			}
			
			if(RelCustomerTrans==AccNumTrans){
			System.out.println("Name - "+a.getName());
			System.out.println("Your Current Balance is  "+a.getDeposit());	
			}
			}	
		System.out.println("");
		for(CheckingAccount a : CheckingAccount){
			RelCustomerTrans = a.getAccNum();
			if(RelCustomerTrans==AccNumTrans){
			System.out.println("Name - "+a.getName());
			System.out.println("Your Current Balance is  "+a.getDeposit());	
			}
			}		
		System.out.println("");
		System.out.println("Transfer Amount  ");
		AmountTrans=Integer.parseInt(input.nextLine());
				
		for(SavingsAccount a : SavingsAccount){
			RelCustomerTrans = a.getAccNum();
			
			
			
			if((ValidateValue-AmountTrans)<0){
				
				System.out.println("");
				System.out.println("You do not have enough balance to do this transaction");
				System.out.println("Account balance less than 0");
				TransferMoney(input);
			}
			
			if((ValidateValue-AmountTrans)<10) {
				
				System.out.println("");
				System.out.println("Account balance is dropping below $10");
				
			}
			
			if((ValidateNew+AmountTrans)>100000) {
				System.out.println("");
				System.out.println("Account balance is reaching to the $100000");
			}
			
			
			if(RelCustomerTrans==AccNumTrans){
				int	toAcc=(a.getDeposit()+AmountTrans);
				a.setDeposit(toAcc);
				for(SavingsAccount b : SavingsAccount){
					RelCustomer = b.getAccNum();
					if(RelCustomer==AccNum){
					int	fromAcc=(b.getDeposit()-AmountTrans);
				    b.setDeposit(fromAcc);		
					}
					}	
				for(CheckingAccount b : CheckingAccount){
					RelCustomer = b.getAccNum();
					if(RelCustomer==AccNum){
						int	fromAcc=(b.getDeposit()-AmountTrans);
						b.setDeposit(fromAcc);		
					}
					}	
				isOkTrans=false;
			}
			}	
		for(CheckingAccount a : CheckingAccount){
			RelCustomerTrans = a.getAccNum();
			if(RelCustomerTrans==AccNumTrans){
				int	toAcc=(a.getDeposit()+AmountTrans);
				a.setDeposit(toAcc);
				for(SavingsAccount b : SavingsAccount){
					RelCustomer = b.getAccNum();
					if(RelCustomer==AccNum){
					int	fromAcc=(b.getDeposit()-AmountTrans);
				    b.setDeposit(fromAcc);		
					}
					}	
				for(CheckingAccount b : CheckingAccount){
					RelCustomer = b.getAccNum();
					if(RelCustomer==AccNum){
						int	fromAcc=(b.getDeposit()-AmountTrans);
						b.setDeposit(fromAcc);		
					}
					}	
				isOkTrans=false;
			}
			}
		if(isOkTrans==false){
			isAccnumTransOk=true;
		}
		
		System.out.println("");
		continue;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
	}
	
	System.out.println("");
	System.out.println("Successfully Transferred");
	System.out.println("");
	
	System.out.println("Debit accout balance is   : "+ (ValidateValue-AmountTrans));
	System.out.println("Credit account balance is : "+ (ValidateNew+AmountTrans));
	System.out.println("");
	
	while(true){
		System.out.println("'MENU' GO TO THE MENU");
		String goMenu=input.nextLine();
		if(goMenu.equalsIgnoreCase("MENU")){
			menu.mainMenuAcc(input);
			
		}else{
			System.out.println("Invalid input");
			continue;
		}

	}
}

public static void StandingOrderTransaction(Scanner input){
	int RelAccNum;
    String debitname = null;
    String creditename = null;
    

	System.out.println("");
	
	boolean isdisplayOk=false;

	boolean isAccnumOk=false;
	boolean isOk=true;
	boolean isCreditOk=false;

	int RelCustomer;
	while(!isAccnumOk){
		try{
			System.out.println("");
			System.out.println("Enter your Debit Account Number");
			AccNum=Integer.parseInt(input.nextLine());
		for(SavingsAccount a : SavingsAccount){
			RelCustomer = a.getAccNum();
			if(RelCustomer==AccNum){
				isOk=false;
			}
			
			}
		if(isOk==false){
			isAccnumOk=true;
		}

		continue;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
}
	
	System.out.println("");
	for(SavingsAccount a : SavingsAccount){
		RelAccNum = a.getAccNum();
		
		if(RelAccNum==AccNum){
		debitname=a.getName();
		System.out.println("Name - "+a.getName());
		debitBalance=a.getDeposit();
		System.out.println("Your Current Balance is  "+a.getDeposit());	
		System.out.println("");
		}
		}	
////////////////////////////////////////////////////////////////	
	while(!isCreditOk){
		try{
			System.out.println("Enter your Credit Account Number");
			AccNum=Integer.parseInt(input.nextLine());
		for(SavingsAccount a : SavingsAccount){
			RelCustomer = a.getAccNum();
			if(RelCustomer==AccNum){
				isOk=false;
			}
			
			}
		if(isOk==false){
			//isCreditOk
			isCreditOk=true;
		}

		continue;
		}catch(Exception ex){
			System.out.println("");
			System.out.println("Invalid Input");
			System.out.println("");
			continue;
			
		}
}
	
	System.out.println("");
	for(SavingsAccount a : SavingsAccount){
		RelAccNum = a.getAccNum();
		
		if(RelAccNum==AccNum){
		creditename=a.getName();
		System.out.println("Name - "+a.getName());
		crediteBalance=a.getDeposit();
		System.out.println("Your Current Balance is  "+a.getDeposit());	
		System.out.println("");

		}
		}
	System.out.println("Transfer Amount ");
	boolean amount=false;
	while(!amount){
		try{
		    amountCredite=Integer.parseInt(input.nextLine());
			amount=true;
		}catch(Exception ex){
			System.out.println("Invalid Input");
			continue;
		}
		
		
	}
	int month=0;
	System.out.println("Debit Account Name : "+debitname+"            "+"Credit Account Name : "+creditename);
	System.out.println("");
	System.out.println("  *MONTH*             *DEBIT BALANCE*                *CREDIT BALANCE*     ");
	while(!isdisplayOk){
		if(debitBalance<0){
			break;
		}
	System.out.print(month+"  :  Month             ");	
	System.out.print(debitBalance);
	System.out.print("                             ");	
	System.out.print(crediteBalance);
	System.out.println("");
	debitBalance-=amountCredite;
	crediteBalance+=amountCredite;
	month++;
	}
	while(true){
		System.out.println("");
		System.out.println("ENTER 'MENU' TO GO TO THE MENU");
		String goMenu=input.nextLine();
		if(goMenu.equalsIgnoreCase("MENU")){
			menu.mainMenuAcc(input);
			
		}else{
			System.out.println("Invalid input");
			continue;
		}

	}
   }
  
}
