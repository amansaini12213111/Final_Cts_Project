package com.bms.tests;

import com.bms.base.BaseClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseClass {
	@BeforeMethod
    public void goToLoginPage(){
        driver.findElement(By.partialLinkText("Sign")).click();
    }
    @Test
    public void testUserRegistration() {

        driver.findElement(By.id("register-tab")).click();
        driver.findElement(By.id("reg-name")).sendKeys("newuser");
        driver.findElement(By.id("reg-email")).sendKeys("newuser@test.com");
        driver.findElement(By.id("reg-password")).sendKeys("newuser@123");
        driver.findElement(By.id("register-btn")).click();


        String msg = driver.findElement(By.id("auth-message")).getText();
        Assert.assertTrue(msg.toLowerCase().contains("successful"));
    }
}