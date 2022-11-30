package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.Model.AccountData;
import com.example.UntitledTestSuite.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHelper extends HelperBase{

    public LoginHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }

    public void Login(AccountData user) throws InterruptedException {
        if (isAuth()){
            if (isUserAuth(user.getUsername())){
                return;
            }
            logout();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/section/div[2]/div/div[2]/form/div[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/section/div[2]/div/div[2]/form/div[1]/div/input")).sendKeys(user.getUsername());
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/section/div[2]/div/div[2]/form/div[2]/div[2]/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/section/div[2]/div/div[2]/form/div[2]/div[2]/input")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/section/div[2]/div/div[2]/form/button")).click();
    }

    public void logout(){
        driver.get("https://taplink.ru/profile/11779194/account/profiles/");
        driver.findElement(By.linkText("Выход")).click();
        driver.get("https://taplink.ru/profile/auth/signin/");
    }

    public boolean isAuth(){
       return isElementPresent(By.xpath("/html/body/div[1]/div[6]/div/div[2]/header"));
    }

    public boolean isUserAuth(String name) throws InterruptedException {
        Thread.sleep(1000);
        driver.get("https://taplink.ru/profile/11824428/account/profiles/");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Настройки аккаунта")).click();
        Thread.sleep(1000);
        driver.get("https://taplink.ru/profile/11824428/account/settings/");
        Thread.sleep(1000);
        String username = driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div/div[1]/div[2]/div/div/div/div[1]/div/p/div/div/div/div")).getText();
        return name.equals(username);
    }

    public boolean isErrorLogin() throws InterruptedException {
        Thread.sleep(1000);
        return isElementPresent(By.xpath("/html/body/div[4]/div"));
    }
}
