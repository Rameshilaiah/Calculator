package org.calculator.calculator;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CalculatorMethods {

public WebDriver driver;

public void performOperation(String num1, String operator, String num2, String expectedResult) {
    clickButtonByValue(num1);
    clickButtonByValue(operator);
    clickButtonByValue(num2);
    clickButtonByValue("=");

    WebElement result = driver.findElement(By.xpath("//div[@id='display']/div"));
    assertEquals(expectedResult, result.getText());
}

private void clickButtonByValue(String value) {
    String xpath = String.format("//input[@value='%s']", value);
    WebElement button = driver.findElement(By.xpath(xpath));
    button.click();
}
}

