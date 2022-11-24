package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.Model.AccountData;
import com.example.UntitledTestSuite.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase{


    public LoginHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void Login(AccountData user) {
        driver.findElement(By.xpath("//input[@type='email']")).clear();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(user.Username);
        driver.findElement(By.xpath("//input[@type='password']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(user.Password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public boolean isAuth(){
       return driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[2]/header")).isDisplayed();
    }
}
