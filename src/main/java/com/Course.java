package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Course {

    WebDriver driver;
    @BeforeMethod
    public void InitDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/java/com/Util/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://coding.imooc.com/");
    }

    @AfterMethod
    public void driverClose(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> courseList=driver.findElements(By.className("shizan-name"));
        for(WebElement courseName:courseList){
            System.out.println(courseName.getText());
            courseName.click();
            driver.navigate().back();
            Thread.sleep(2000);
            driver.findElement(By.className("js-close")).click();
            courseList=driver.findElements(By.className("shizan-name"));
        }

    }



}
