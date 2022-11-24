package com.example.UntitledTestSuite.Helpers;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.Model.ProfileData;
import org.openqa.selenium.By;

public class ProfileHelper extends HelperBase {

    public ProfileHelper(ApplicationManager applicationManager){
        super(applicationManager);
    }


    public void AddPost(ProfileData profileData) throws Exception {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Перенести тариф'])[1]/following::div[11]")).click();
        driver.findElement(By.xpath("//div[2]/div/div/div/div/div/div/i")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Нет'])[1]/following::button[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div[4]/div[3]/div/div/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/section/div/div[1]/button")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/section/section[2]/div/div")).sendKeys(profileData.getProfileContent());
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/footer/div[2]/button")).click();
    }

    public void ChangePost(ProfileData profileData) throws Exception {
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[2]/header/div/div[1]/div[1]/div/div/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div[4]/div[1]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/a")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/section/section[2]/div/div")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/section/section[2]/div/div")).clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/section/section[2]/div/div")).sendKeys(profileData.getProfileContent());
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/footer/div[2]/button")).click();

        //driver.findElement(By.className("input")).sendKeys(profileData.getProfileContent());
    }

    public ProfileData GetCreatedProfile() throws Exception {
        applicationManager.getNavigationHelper().OpenProfilePage();
        //driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div[2]/div/div[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[2]/header/div/div[1]/div[1]/div/div/a[1]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div[4]/div[1]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/a")).click();
        //String text = driver.findElement(By.className("block-text")).getText();
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div[3]/div[4]/div[1]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/a/div")).getText();
        return new ProfileData(text);
    }
}
