package com.test.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
    public void setUp() {
        DriverFactory.getDriver(); // Initializes driver before each scenario
    }

    @After
    public void tearDown() {
        DriverFactory.setDriver(); // Quits driver after each scenario
    }


}
