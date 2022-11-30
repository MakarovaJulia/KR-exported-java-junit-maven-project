package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.Model.AccountData;
import com.example.UntitledTestSuite.Tests.TestBase;
import org.junit.Before;

public class AuthBase extends TestBase {
    protected static final AccountData user = new AccountData(
            Settings.getUsername(),
            Settings.getPassword()
    );

    @Before
    public void setUp() throws Exception {
        super.setUp();
        applicationManager.getNavigationHelper().OpenHomePage();
        applicationManager.getNavigationHelper().OpenLoginPage();
        applicationManager.getLoginHelper().Login(user);
    }
}
