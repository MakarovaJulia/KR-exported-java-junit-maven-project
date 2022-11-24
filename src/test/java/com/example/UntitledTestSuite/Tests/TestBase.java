package com.example.UntitledTestSuite.Tests;

import com.example.UntitledTestSuite.ApplicationManager;
import com.example.UntitledTestSuite.Helpers.HelperBase;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;

public class TestBase {
    protected static ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.getInstance();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        applicationManager.stop();
    }
}
