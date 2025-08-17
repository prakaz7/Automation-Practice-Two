package com.test.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetCodeButtonFields {
	WebDriver driver;
	public LetCodeButtonFields() {
		driver = DriverFactory.getDriver();
	}
	
	
	@When("user clicks on the Click option in button field")
	public void user_clicks_on_the_click_option_in_button_field() {
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("//a[@class='card-footer-item' and contains(text(),'Click')]")).click();
		WebElement ele = driver.findElement(By.xpath("//h1"));
		if(ele.getText().equalsIgnoreCase("Button")) {
			System.out.println("Success");
		}
	}

	@Then("user Goto Home and come back here using driver command")
	public void user_goto_home_and_come_back_here_using_driver_command() {
		 WebElement home = driver.findElement(By.id("home"));
		 home.isDisplayed();
		 home.click();
		 driver.navigate().back();
	}

	@Then("Get the X & Y co-ordinates")
	public void get_the_x_y_co_ordinates() {
		WebElement findLoc = driver.findElement(By.id("position"));
		Dimension loc =  findLoc.getSize();
		System.out.println(loc);
		int height = loc.getHeight();
		int width = loc.getWidth();
		
		System.out.println("Height : " + height + "width : " +width);
	    
	}

	@Then("Find the color of the button")
	public void find_the_color_of_the_button() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement color = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("color")));
		System.out.println("***##########***");
		System.out.println( color.getCssValue("background-color"));
	    
	}

	@Then("Find the height & width of the button")
	public void find_the_height_width_of_the_button() {
		WebElement ele= driver.findElement(By.id("property"));
		Rectangle data =  ele.getRect();
		int x =  data.getHeight();
		 int y = data.getWidth();
		 System.out.println("height => : " + x + "Width => : " +y);
	    
	}

	@Then("Confirm button is disabled")
	public void confirm_button_is_disabled() {
		WebElement ele =  driver.findElement(By.id("isDisabled"));
		boolean status =  ele.isEnabled(); 
		System.out.println("boolean is : " + status);
	}

	@Then("Click and Hold Button")
	public void click_and_hold_button() throws InterruptedException {
		System.out.println("***##########***");
		WebElement ele = driver.findElement(By.xpath("//button[@id='isDisabled']/following::h2"));
		Actions action = new Actions(driver);
		action.clickAndHold(ele).build().perform();
	    System.out.println("***##########***");
	    DriverFactory.setDriver();
	}

}
