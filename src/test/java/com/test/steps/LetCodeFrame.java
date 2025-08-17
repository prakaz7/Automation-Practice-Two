package com.test.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetCodeFrame {
	WebDriver driver;
	public LetCodeFrame() {
		driver=DriverFactory.getDriver();
	}
	
	@When("User click on inner HTML")
	public void user_click_on_inner_html() {
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("//a[text()=' Inner HTML ']")).click();	
		
	}

	@Then("Enter details of the fields")
	public void enter_details_of_the_fields() {
	    String userName = "UserOne";
	    String lastName = "UseTwo";

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Switch to outer frame
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='frameui']")));
	    System.out.println("=======================");
	    System.out.println("Inside outer frame");
	    System.out.println("=======================");

	    WebElement enterName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fname")));
	    enterName.sendKeys(userName);

	    WebElement enterLName = driver.findElement(By.name("lname"));
	    enterLName.sendKeys(lastName);

	    // Switch to inner frame inside outer frame
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='innerframe']")));
	    System.out.println("Inside inner frame");

	    // Locate the input field by name and send keys
	    WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
	    emailInput.sendKeys("Inner Frame");

	    // Return to outer frame
	    driver.switchTo().parentFrame();
	    enterLName.sendKeys(" from frame");

	    // Return to main document
	    driver.switchTo().defaultContent();

	    WebElement eli = driver.findElement(By.xpath("//p[text()=' Insight ']"));
	    if (eli.isDisplayed()) {
	        System.out.println("✅ 'Insight' element is visible");
	    }
	}

}
