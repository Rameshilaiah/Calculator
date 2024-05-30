package org.calculator.calculator;


import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class CalculatorTest extends CalculatorMethods{
	
	 private String baseUrl;

	    // Constructor to receive the parameters
	    public CalculatorTest(String baseUrl) {
	        this.baseUrl = baseUrl;
	    }

	    // Parameters for staging and production URLs
	    @Parameterized.Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][]{
	        	{"https://nuix.github.io/SDET/senior-sdet/productionCalc/index.html"},
	            {"https://nuix.github.io/SDET/senior-sdet/stagingCalc/index.html"}
	        });
	    }

@Before
public void setUp() {
    // Set the path to the chromedriver executable
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.get(baseUrl);
}

@Test
public void testAddition() {
	performOperation("9", "+", "5", "14");
}

@Test
public void testSubtraction() {
    performOperation("9", "-", "5", "4");
    driver.close();
}

@Test
public void testMultiplication() {
    performOperation("3", "×", "4", "12");
    driver.close();
}

@Test
public void testDivision() {
    performOperation("8", "÷", "2", "4");
    driver.close();
}

@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}

}
