package com.java.common;

import java.util.ArrayList;

public class Common {

	static public String priceView(int price) {
		
		ArrayList<Character> temp = new ArrayList<Character>();
		String priceTemp = Integer.toString(price);
		String priceView = "";
		
		int count = 0;
		for(int i=priceTemp.length(); i>0; i--) {
			temp.add(0, priceTemp.charAt(i-1));
			count++;
			if(count % 3 == 0) {
				temp.add(0,',');
			}
		}
	
		if(temp.get(0) == ',') {
			temp.remove(0);
		}

		for (Character s : temp) {
			priceView = priceView.concat(Character.toString(s)); 
		}
		
		return priceView;
	}

}
