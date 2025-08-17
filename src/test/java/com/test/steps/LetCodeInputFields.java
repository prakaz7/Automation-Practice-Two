package com.test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetCodeInputFields {
	
	WebDriver driver;
	
	public LetCodeInputFields() {
		driver = DriverFactory.getDriver();
	}
	
	@Given("User can launch the letcode site")
	public void user_can_launch_the_letcode_site() {
		driver.get("https://letcode.in/test");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Workspace | LetCode with Koushik");
	   
	}

	@When("user clicks on the edit option in Input field")
	public void user_clicks_on_the_edit_option_in_input_field() {
		WebElement inputCard = driver.findElement(By.xpath("//header[@class='card-header']/following::p[contains(text(),'Input')]"));
		String inputCardName = inputCard.getText();
		
		Assert.assertEquals(inputCardName, "Input");
		driver.findElement(By.xpath("//a[@class='card-footer-item' and contains(text(),'Edit')]")).click();
		
		WebElement element = driver.findElement(By.xpath("//h1"));
		String headerVal = element.getText();
		Assert.assertEquals(headerVal, "Input");
		
	    
	}

	@Then("enter {string} and append a {string} and press tab")
	public void enter_and_append_a_and_press_tab(String name, String appendName) {
		
		WebElement inputfield = driver.findElement(By.id("fullName"));
		inputfield.sendKeys(name);	
		
		WebElement appendVal = driver.findElement(By.id("join"));
		appendVal.sendKeys(appendName , Keys.TAB);
	    
	}

	@Then("get the text value")
	public void get_the_text_value() {
		
		WebElement getMe = driver.findElement(By.id("getMe"));
		String whatsInside =  getMe.getText();
		System.out.println("This is what inside : " +whatsInside);
	    
	}

	@Then("clear the text")
	public void clear_the_text() {
		driver.findElement(By.id("clearMe")).clear();
	    
	}

	@Then("confirm edit is disabled")
	public void confirm_edit_is_disabled() {
		String bool = driver.findElement(By.id("noEdit")).getDomAttribute("disabled");
		if(bool.equalsIgnoreCase("true")) {
			System.out.println("Disabled  true");
		}else {
			System.out.println("Disabled  false");
		}
	}

	@Then("confirm the text is readonly")
	public void confirm_the_text_is_readonly() {
		String isReadonly = driver.findElement(By.id("dontwrite")).getDomAttribute("readonly");
		System.out.println(isReadonly);
		DriverFactory.setDriver();	    
	}

}
