package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.Model.AccountData;
import com.example.UntitledTestSuite.Model.AccountsList;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class LoginTest extends TestBase{
    @DataPoints("valid")
    public static List<AccountData> validDataFromXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(AccountsList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AccountsList users = (AccountsList) unmarshaller.unmarshal(new File("./validData.xml"));
            return users.getAccountDataList();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    @Theory
    public void loginWithValidData(@FromDataPoints("valid") AccountData user) throws Exception {
        AccountData user1 = new AccountData(user.getUsername(), user.getPassword());
        applicationManager.getNavigationHelper().OpenHomePage();
        applicationManager.getNavigationHelper().OpenLoginPage();
        applicationManager.getLoginHelper().Login(user1);
        Assert.assertTrue(applicationManager.getLoginHelper().isUserAuth(user.getUsername()));
    }

    @DataPoints("invalid")
    public static List<AccountData> invalidDataFromXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(AccountsList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AccountsList users = (AccountsList) unmarshaller.unmarshal(new File("./invalidData.xml"));
            return users.getAccountDataList();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Theory
    public void loginWithInvalidData(@FromDataPoints("invalid") AccountData user) throws Exception {
        AccountData user1 = new AccountData(user.getUsername(), user.getPassword());
        applicationManager.getNavigationHelper().OpenHomePage();
        applicationManager.getNavigationHelper().OpenLoginPage();
        applicationManager.getLoginHelper().Login(user1);
        Thread.sleep(3000);
        Assert.assertTrue(applicationManager.getLoginHelper().isErrorLogin());
    }
}
