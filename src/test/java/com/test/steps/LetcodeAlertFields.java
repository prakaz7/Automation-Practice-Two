package com.test.steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetcodeAlertFields {
	WebDriver driver;
	public LetcodeAlertFields() {
		driver=DriverFactory.getDriver();
	}
	
	@When("User click on dialog button")
	public void user_click_on_dialog_button() {
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("//a[text()=' Dialog ']")).click();	    
	}

	@Then("user clicks on simple alert")
	public void user_clicks_on_simple_alert() throws InterruptedException {
		WebElement ele = driver.findElement(By.id("accept"));
		ele.isDisplayed();
		ele.click();
		Alert al = driver.switchTo().alert();
		al.accept();
		
	}

	@Then("user dismiss the alert and print the text")
	public void user_dismiss_the_alert_and_print_the_text() {
		WebElement ele = driver.findElement(By.id("confirm"));
		ele.isDisplayed();
		ele.click();
		Alert al = driver.switchTo().alert();
		System.out.println( al.getText());
		al.dismiss();
	    
	}

	@Then("user works on promt alert")
	public void user_works_on_promt_alert() {
		WebElement ele = driver.findElement(By.id("prompt"));
		ele.isDisplayed();
		ele.click();
		Alert al = driver.switchTo().alert();
		al.sendKeys("My Name is don");
		al.accept();
	    
	}

	@Then("user checks the sweet alert")
	public void user_checks_the_sweet_alert() {
		WebElement ele = driver.findElement(By.id("modern"));
		ele.isDisplayed();
		ele.click();
		//Alert al = driver.switchTo().alert();	
		WebElement el = driver.findElement(By.className("modal-close"));
		el.click();
	    
	}

}
