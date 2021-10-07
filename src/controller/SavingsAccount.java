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
public class SavingsAccount {
	String name=null;
	int AccNum=0;
	String NicNum=null;
	String Pass=null;
	int deposit=0;
	
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
	
	SavingsAccount(String Name,int accNum,String nicNum,String pass,int Deposit){
		name=Name;
		AccNum=accNum;
		NicNum=nicNum;
		Pass=pass;
		deposit=Deposit;
	}
	
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public static void add(SavingsAccount objOne) {
		// TODO Auto-generated method stub
		
	}   
}
