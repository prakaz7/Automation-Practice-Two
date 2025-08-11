package com.test.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	WebDriver driver;

    public LoginTest() {
        driver = DriverFactory.getDriver();
    }


	
	@Given("A user can login to the HR CRM Portal")
	public void a_user_can_login_to_the_hr_crm_portal() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(5000);
	}

	@When("the {string} and {string} is entered")
	public void the_and_is_entered(String UserName, String Password) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement userName =  driver.findElement(By.name("username"));
		userName.sendKeys(UserName);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(Password);
	 
	}

	@Then("the user can click on the login button")
	public void the_user_can_click_on_the_login_button() {
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitBtn.click();
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("can see the dashboard screen.")
	public void can_see_the_dashboard_screen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement headerDashboard = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6"))
	    );

		String header = headerDashboard.getText();
		System.out.println("*************");
		System.out.println("this is the dashboard : " +header);
		System.out.println("*************");
		Assert.assertEquals("Dashboard", header);
		DriverFactory.setDriver();
	  
	    
	}
}
