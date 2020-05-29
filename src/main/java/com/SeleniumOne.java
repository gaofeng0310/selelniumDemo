package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;

public class SeleniumOne {

    WebDriver driver;
    public void InitDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/java/com/Util/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://www.imooc.com");
        Thread.sleep(1000);
    }

    public void  getElement() throws InterruptedException {
        //By.id
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(3000);//为什么要休眠3秒呢？因为点了登录按钮，登录页面还没出来，下面就获取不到值，所以休眠下，等登录页面打开
        //By.name
        driver.findElement(By.name("email")).sendKeys("17757101629");//输入账号
        //By.className
        driver.findElement(By.className("js-loginPassword")).sendKeys("aaa111000");//输入密码
        //By.tagName
        WebElement webElement=driver.findElement(By.className("rlf-autoin"));//先拿到上一层级的className
        webElement.findElement(By.tagName("input")).click();//再取 input 标签   点击记住密码
        //className 有多个值
        List<WebElement> buttonElement=driver.findElements(By.className("rlf-group"));//先获取这个className
        buttonElement.get(4).click();//我们这里取第四个值    点击登陆按钮

        driver.close();//关闭浏览器

    }

    //点击找回密码
    public void bypartialLinkText() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(3000);
        //By.partialLinkText 通过部分链接文本查找元素，例如：无法登陆，写无法就可以
        driver.findElement(By.partialLinkText("无法")).click();
        driver.close();//关闭浏览器
    }

    //点击找回密码
    public void byLinkText() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(3000);
        //By.linkText 通过链接文本查找元素
        driver.findElement(By.linkText("找回密码")).click();
        driver.close();//关闭浏览器
    }


    //切换登陆方式为：账号密码登陆
    public void byXpath() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(3000);
        driver.findElement(By.xpath("id(\"signin\")/div[3]/div[1]/span[1]")).click();//点击账号密码登陆
        driver.close();
    }
    //获取验证吗功能
    public  void byCssSelector() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(3000);
        driver.findElement(By.xpath("id(\"signin\")/div[3]/div[1]/span[1]")).click();//点击账号密码登陆
        //获取验证吗
        driver.findElement(By.cssSelector("#signup-form > div.rlf-group.pr.phoneVerityBox > p.reSend.pa.active.js-phonecode-box > span")).click();

        driver.close();
    }







    public static void main(String[] args) throws InterruptedException {
        SeleniumOne seleniumOne=new SeleniumOne();
        seleniumOne.InitDriver();
//        seleniumOne.getElement();
        seleniumOne.byXpath();
//        seleniumOne.byCssSelector();
//        seleniumOne.bypartialLinkText();
//        seleniumOne.byLinkText();
    }


}
