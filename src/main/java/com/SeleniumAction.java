package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumAction {

    WebDriver driver;
    public void InitDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/java/com/Util/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://www.imooc.com");

    }


    public void input() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(2000);
        WebElement webElement=driver.findElement(By.name("email"));//获取到账号输入框，然后装在webElement里
        webElement.sendKeys("17757101629");//填写账号
        String userInfo=webElement.getAttribute("placeholder");//通过getAttribute 去元素的值
        Thread.sleep(2000);
        System.out.println("userInfo:"+userInfo);
        String mobile=webElement.getAttribute("value");//这样获取到 账号输入框的值
        System.out.println("mobile："+mobile);
        boolean isable = webElement.isEnabled();//改输入框是否可以输入
        webElement.clear();//情空输入框
        Thread.sleep(1000);
        System.out.println("isable："+isable);
        driver.close();
    }


    public void aaaaaa() throws InterruptedException {

        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(2000);

        WebElement webElement=driver.findElement(By.name("email"));//获取到账号输入框
        webElement.sendKeys("1111111111234567896534567890-0987234567890$%^&*()(*&^%$11111111111111");//账号输入内容超长
        driver.findElement(By.className("rl-modal-header")).click();//点击一下空白处，这样提示文案才会出来
        List<WebElement> buttonElement=driver.findElements(By.className("rlf-tip-wrap"));//先获取这个className
        String strErr=buttonElement.get(0).getAttribute("data-error-hint");//因为有多个，所以我们取第一个，把提示信息取出来
        System.out.println("strErr:"+strErr);
        Thread.sleep(1000);
        driver.close();

    }



    public static void main(String[] args) throws InterruptedException {
        SeleniumAction seleniumAction=new SeleniumAction();
        seleniumAction.InitDriver();
//        seleniumAction.input();
        seleniumAction.aaaaaa();
    }

}
