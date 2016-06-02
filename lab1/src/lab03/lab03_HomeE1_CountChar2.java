package lab03;

import java.util.Scanner;

public class lab03_HomeE1_CountChar2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] UpperCase = new int[26];
		//int [] LowerCase = new int[26];
		char[] lowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] upperCase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

		//String s = args[0];
		System.out.println("Please enter a 5 character string with mixed upper and lowercase");
		Scanner scn = new Scanner (System.in);
		String input = scn.next();

		int k=0;
		char[] chArray = new char[5];
		for (k=0;k<chArray.length;k++)
			chArray[k] =  input.charAt(k);
		//char tobeFound = 0;
		int i;
		int j;
		int count1 = 0;
		int count2 = 0;
		for(i=0; i<lowerCase.length; i++)
		{
			for (j=0;j<chArray.length;j++){
				if (chArray[j]==lowerCase[i])
					count1++;
			} 
		}
		for(i=0; i<upperCase.length; i++)
		{
			for (j=0;j<chArray.length;j++){
				if (chArray[j]==upperCase[i])
					count2++;
			}
			//if (tobeFound==UpperCase[i])u
			//count++;
		} 
		System.out.println("There are "+count1+" lowercase characters and "+count2+" uppercase characters in this string");	
	}
}