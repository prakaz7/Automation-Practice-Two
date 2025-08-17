package com.test.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.utils.DriverFactory;

import io.cucumber.java.en.*;

public class LetCodeWindows {

	WebDriver driver;

	public LetCodeWindows() {
		driver = DriverFactory.getDriver();
	}

	@Given("when user navigates to windowhandles page")
	public void when_user_navigates_to_windowhandles_page() {
		driver.get("https://letcode.in/window");
	}

	@When("user click on Go to home")
	public void user_click_on_go_to_home() {
		WebElement ele = driver.findElement(By.id("home"));
		String window1 = driver.getWindowHandle();
		String s = driver.getCurrentUrl();
		System.out.println(window1 + "is " + s);
		ele.click();
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
		String newOne = driver.getCurrentUrl();
		System.out.println("URL is " + newOne);
		//driver.switchTo().window(list.get(1));
		driver.close();
		driver.switchTo().window(list.get(0));
	}

	@Then("Open Multiple window tasks")
	public void open_multiple_window_tasks() {
		driver.get("https://letcode.in/window");
		WebElement ele = driver.findElement(By.id("multi"));
		String window1 = driver.getWindowHandle();
		String s = driver.getCurrentUrl();
		ele.click();
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		list.clear();
		list.addAll(set);
		for(int i=0;i<list.size(); i++) {
			System.out.println("The window " +i+ " is " +list.get(i));
		}
		for(int j=0;j<list.size(); j++) {
			driver.switchTo().window(list.get(j));
			driver.close();
		}

	}

}
