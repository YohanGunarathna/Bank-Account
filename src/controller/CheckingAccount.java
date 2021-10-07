/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Yohan Gunarathna
 */
public class CheckingAccount {
	String name=null;
	
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	int AccNum=0;
	String NicNum=null;
	String Pass=null;
	int deposit=0;
	int Mfee=0;
	int NoCheques=0;

	
	public int getNoCheques() {
		return NoCheques;
	}
	public int getMfee() {
		return Mfee;
	}
	public String getName() {
		return name;
	}
	public int getAccNum() {
		return AccNum;
	}
	public String getNicNum() {
		return NicNum;
	}
	
	public String getPass() {
		return Pass;
	}
	public int getDeposit() {
		return deposit;
	}
	
	CheckingAccount(String Name,int accNum,String nicNum,String pass,int Deposit,int mfee,int noCheques){
		name=Name;
		AccNum=accNum;
		NicNum=nicNum;
		Pass=pass;
		deposit=Deposit;
		Mfee=mfee;
		NoCheques=noCheques;
	} 
}
