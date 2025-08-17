package com.test.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetCodeRadioFields {
	
	WebDriver driver;
	public LetCodeRadioFields() {
		driver = DriverFactory.getDriver();
	}
	
	
	@Given("when user navigates to Radiobutton page")
	public void when_user_navigates_to_radiobutton_page() {
		driver.get("https://letcode.in/radio");
	    
	    
	}

	@When("Select any one")
	public void select_any_one() {
	    WebElement one = driver.findElement(By.xpath("//input[@name='answer' and @id='no']"));
	    one.click();
	    if(one.isSelected()) {
	    	System.out.println("No is been selected.");
	    }
	    
	}

	@Then("Confirm you can select only one radio button")
	public void confirm_you_can_select_only_one_radio_button() {
		WebElement one = driver.findElement(By.xpath("//input[@name='one' and @id='one']"));
		WebElement two = driver.findElement(By.xpath("//input[@name='one' and @id='two']"));
		
		one.click();
		boolean ones = one.isSelected();
		boolean twos = two.isSelected();
		
		System.out.println("Two should be false: and the answer is : "+twos);
		
		two.click();
		boolean onet = one.isSelected();
		boolean twot = two.isSelected();
		
		System.out.println("One should be false: and the answer is : "+onet);
		
	    
	    
	}

	@Then("Find the bug")
	public void find_the_bug() {
		WebElement one = driver.findElement(By.xpath("//input[@name='nobug' and @id='nobug']"));
		WebElement two = driver.findElement(By.xpath("//input[@name='bug' and @id='bug']"));
		one.click();
		two.click();
		if(one.isSelected() == two.isSelected()) {
			System.out.println("Found the bug");
		}
	    
	    
	}

	@Then("Find which one is selected")
	public void find_which_one_is_selected() {
	    WebElement one = driver.findElement(By.xpath("//input[@name='foobar' and @id='notfoo']"));
	    one.isSelected();
	    System.out.println(one.getText());
	    
	    
	}

	@Then("Confirm last field is disabled")
	public void confirm_last_field_is_disabled() {
		WebElement one = driver.findElement(By.xpath("//input[@name='plan' and @id='maybe']"));
		String two = one.getDomAttribute("disabled");
		System.out.println("Yes answer is :" + two);    
		boolean val = one.isEnabled();
		System.out.println("THe val is :"+ val);
	    
	}

	@Then("Find if the checkbox is selected?")
	public void find_if_the_checkbox_is_selected() {
	    
	    WebElement ele = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	    boolean vl = ele.isSelected();
	    System.out.println(vl);
	}

	@Then("Accept the T&C")
	public void accept_the_t_c() {
		WebElement ele = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
	    boolean vl = ele.isSelected();
	    System.out.println(vl);
	    ele.click();
	    boolean vl1 = ele.isSelected();
	    System.out.println(vl1);
	    DriverFactory.setDriver();
	    
	}

}
