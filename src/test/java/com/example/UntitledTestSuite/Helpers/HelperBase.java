package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import org.openqa.selenium.*;

public class HelperBase{
    protected WebDriver driver;
    protected ApplicationManager applicationManager;

    protected boolean acceptNextAlert = true;

    public HelperBase(ApplicationManager applicationManager){
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }



    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
