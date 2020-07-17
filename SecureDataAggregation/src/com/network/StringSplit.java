package com.network;


public class StringSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="MASTER-PC/192.168.1.11/ffff";
		String parts[]=str.split("/");
		System.out.println(parts[0]);
		System.out.println(parts[1]);
		System.out.println(parts[2]);
		
		

	}

}
