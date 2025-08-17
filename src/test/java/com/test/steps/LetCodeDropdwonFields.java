package com.test.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetCodeDropdwonFields {
	
	WebDriver driver;
	public LetCodeDropdwonFields() {
		driver = DriverFactory.getDriver();
	}
	
	@When("user click on the dropdown button")
	public void user_click_on_the_dropdown_button() {
		String mainUrl = "https://letcode.in/test";
		driver.get(mainUrl);
		WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Drop-Down')]"));
		ele.isDisplayed();
		ele.click();
		String url =  driver.getCurrentUrl();
	    Assert.assertNotEquals(mainUrl, url);
	}

	@When("User selects the apple fruit by visible text")
	public void user_selects_the_apple_fruit_by_visible_text() throws InterruptedException {
		WebElement ddfruits = driver.findElement(By.id("fruits"));
		Select dd = new Select(ddfruits);
		dd.selectByVisibleText("Mango");
		WebElement text = driver.findElement(By.xpath("//p[@class='subtitle']"));
		String assertValue = text.getText();
		String val[] = assertValue.split(" ");
		String lastword = val[val.length-1];
		System.out.println(lastword);
	}

	@Then("user selects the multiple heros")
	public void user_selects_the_multiple_heros() {
		WebElement ddsuperHeros = driver.findElement(By.id("superheros"));
		Select sel = new Select(ddsuperHeros);
		boolean bool = sel.isMultiple();
		if(bool) {
			System.out.println("Multi drop down");
		}
	    sel.selectByIndex(0);
	    sel.selectByValue("ta");
	    sel.selectByVisibleText("Captain America");
	    
	    List<WebElement> list = sel.getAllSelectedOptions();
	    for(int i=0; i<list.size(); i++) {
	    	
	    	System.out.println("==============");
	    	
	    	System.out.println(list.get(i).getText());
	    	
	    	System.out.println("==============");
	    }
	    WebElement first = sel.getFirstSelectedOption();
	    String firstele = first.getText();
	    System.out.println(firstele);
	    
	}

	@Then("User selects the last programming language and print all options")
	public void user_selects_the_last_programming_language_and_print_all_options() throws InterruptedException {
		
		WebElement ele = driver.findElement(By.id("lang"));
		Select sel = new Select(ele);
		List<WebElement> li = sel.getOptions();
		for(int i=0;i<li.size();i++) {
			System.out.println("The options are : " +li.get(i).getText());
		}
		
		if(!li.isEmpty()) {
			WebElement lastOption = li.get(li.size()-1);
			sel.selectByVisibleText(lastOption.getText());
		}
		
	}

	@Then("USer selects India and print the selected")
	public void u_ser_selects_india_and_print_the_selected() {
		
		WebElement ele = driver.findElement(By.id("country"));
		Select sel = new Select(ele);
		sel.selectByValue("India");
		WebElement val = sel.getFirstSelectedOption();
		System.out.println(val.getText());
	    
	    
	}

}
