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
public class BankBranch {
	int BSBnumber=0;
	String Address=null;
	int PostCode=0;
	int AccountNum=0;

	
	public int getBSBnumber() {
		return BSBnumber;
	}
	public String getAddress() {
		return Address;
	}
	public int getPostCode() {
		return PostCode;
	}
	public int getAccountNum() {
		return AccountNum;
	}
	
	BankBranch(int bsbNumber,String address,int postcode,int Accountnum){
		
		BSBnumber=bsbNumber;
		Address=address;
		PostCode=postcode;
		AccountNum=Accountnum;
	}
    
}
