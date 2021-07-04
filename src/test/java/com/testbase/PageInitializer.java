package com.testbase;

import com.pages.AmazonPage;

public class PageInitializer extends BaseClass{
	
	public static AmazonPage amazon;
	
	
	public static void initialize() {
		amazon=new AmazonPage();
		
	}
	
	

}
