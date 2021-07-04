package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.utils.CommonMethods;

//Steps to Do:
//1. Navigate to www.amazon.com home page	
//2. Search for 'qa testing for beginners'
//3. Click on 1st item in the listed results
//4. Get the price of the item. 
//5. Click on Add to Cart
//6. Get the asset price before CheckOut.
//7. Click on proceed to CheckOut
//8. On the checkout page assert prices.
//

public class TestAmazon extends CommonMethods {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		setUp();   // Step-1
		sendTextEnter(amazon.searchBox, "qa testing for beginners");  // Step-2
		click(amazon.book);  // Step-3
		String expectedPrice=amazon.price.getText();  //Step-4
		System.out.println(expectedPrice);
		click(amazon.cartButton);    //Step-5
		String actualPrice=amazon.totalPrice.getText();  //Step-6
		System.out.println(expectedPrice+" - "+actualPrice);
		click(amazon.proceedToCheckoutButton);  //step-7
		Assert.assertEquals(actualPrice, expectedPrice);  //Step-8
		
		
		tearDown();
		
	}

}
