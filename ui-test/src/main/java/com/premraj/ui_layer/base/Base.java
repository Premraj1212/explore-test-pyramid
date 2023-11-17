package com.premraj.ui_layer.base;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driver, this);
    }

    public abstract boolean isAt();

    protected WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElements(locator);
    }

    protected void scrollToElement(By locator) {
        WebElement element = findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

}
