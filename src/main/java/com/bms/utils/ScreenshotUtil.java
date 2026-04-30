package com.bms.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        File screenshotDir = new File("screenshots/");
        if (!screenshotDir.exists()) {
            throw new IllegalStateException(
                "Screenshots folder not found! Please create 'screenshots/' in your project root."
            );
        }
        File src  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/" + fileName + ".png");
        FileHandler.copy(src, dest);
        System.out.println("Screenshot saved: " + dest.getAbsolutePath());
    }
}