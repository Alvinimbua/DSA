package com.imbuka.algorithms;

public class StringUtil {
	
	public boolean isPalindrome(String word) {
		//use regex to remove all special characters and white spaces.
		word = word.replaceAll("[^a-zA-z0-9]","");
		//change the string to lower case and then to an array of characters
		char[] charArray = word.toLowerCase().toCharArray();
		//making 2 pointers for start and end for comparison
		int start = 0;
		int end = word.length() -1;
		
		while(start < end) {
			if (charArray[start] != charArray[end]){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	StringUtil util = new StringUtil();
	Boolean palin = util.isPalindrome("A man, a plan, a canal: Panama");
	
	System.out.println(palin);
		
	}

}
