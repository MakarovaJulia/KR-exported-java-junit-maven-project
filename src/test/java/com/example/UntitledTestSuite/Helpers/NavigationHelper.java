package com.example.UntitledTestSuite.Helpers;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.Settings;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class NavigationHelper extends HelperBase {

    public String baseUrl;


    public NavigationHelper(ApplicationManager applicationManager, String baseUrl){
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void OpenLoginPage() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Цены и тарифы'])[1]/following::a[1]")).click();
    }
    public void OpenHomePage() {
        driver.get(Settings.getBaseUrl());
    }

    public void OpenProfilePage() {
        driver.get("https://taplink.ru/profile/11471370/account/profiles/");
    }

    public void OpenPostPage(){
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div[2]/div/div[2]")).click();
    }
}
