package com.example.UntitledTestSuite;
import java.time.Duration;

import com.example.UntitledTestSuite.Helpers.LoginHelper;
import com.example.UntitledTestSuite.Helpers.NavigationHelper;
import com.example.UntitledTestSuite.Helpers.ProfileHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class ApplicationManager {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;


    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private ProfileHelper profileHelper;

    private static ThreadLocal<ApplicationManager> applicationManagerTreadLocal = new ThreadLocal<>();

    public ApplicationManager(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\julma\\OneDrive\\Рабочий стол\\ИТИС\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;

        navigationHelper = new NavigationHelper(this, baseUrl);
        loginHelper = new LoginHelper(this);
        profileHelper = new ProfileHelper(this);
    }

    public static ApplicationManager getInstance(){
        if (applicationManagerTreadLocal.get() == null){
            ApplicationManager newInstance = new ApplicationManager();
//            newInstance.getNavigationHelper().OpenHomePage();
            applicationManagerTreadLocal.set(newInstance);
        }
        return applicationManagerTreadLocal.get();
    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public  ProfileHelper getProfileHelper(){
        return  profileHelper;
    }

}
