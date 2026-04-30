package com.bms.utils;

import com.bms.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class ScreenshotUtil extends BaseClass {

    public static void takeScreenshot(String fileName) {
        try {
            File screenshotDir = new File("screenshots/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + fileName + ".png");

            FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}