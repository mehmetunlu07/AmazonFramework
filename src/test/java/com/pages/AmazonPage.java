package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.CommonMethods;

public class AmazonPage extends CommonMethods {
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	public WebElement book;
	
	@FindBy(xpath="//span[text()='$47.49']")
	public WebElement price;
	
	@FindBy(id="add-to-cart-button")
	public WebElement cartButton;
	
	@FindBy(xpath="//span[text()='$47.49']")
	public WebElement totalPrice;
	
	@FindBy(xpath="//a[@id='hlb-ptc-btn-native']")
	public WebElement proceedToCheckoutButton;
	
	
	
	
	
	
	public AmazonPage() {
		PageFactory.initElements(driver, this);
	}
}
