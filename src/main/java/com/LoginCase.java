package com;

import com.Util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginCase {

    WebDriver driver;
    public void InitDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/java/com/Util/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://www.imooc.com");

    }
    @Test
    public void userLogin() throws InterruptedException, IOException {

        InitDriver();
        Thread.sleep(2000);

        ProUtil proUtil=new ProUtil("src/main/resources/user.properties");
        String user=null;
        String username =null;
        String password =null;
        int lines=proUtil.getLines();

        for (int i=0;i<lines;i++){
            user = proUtil.getPro("user");
            username=user.split(">")[0];
            password=user.split(">")[1];

        }

        WebElement login=getElement("login");
        login.click();
        Thread.sleep(2000);
        WebElement emailele=getElement("userName");
        WebElement passwordele=getElement("password");
        WebElement buttonele=getElement("button");
        emailele.sendKeys(username);
        passwordele.sendKeys(password);
        buttonele.click();
        Thread.sleep(3000);

        try {
            WebElement pngEle=getElement("eleHead");
            Actions actions=new Actions(driver);
            actions.moveToElement(pngEle).perform();

            List<WebElement> buttonElement=getElements("textEle");//先获取这个className

            String sss=buttonElement.get(0).getText();
            if (sss.equals("技术创未来")){
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();

    }

    public WebElement getElement(String key) throws IOException {
        return driver.findElement(this.getBy(key));
    }
    public List<WebElement> getElements(String key) throws IOException {
        return driver.findElements(this.getBy(key));
    }


    public By getBy(String key) throws IOException {
        ProUtil proUtil=new ProUtil("src/main/resources/element.properties");
        String locator=proUtil.getPro(key);
        String locatorBy=locator.split(">")[0];
        String locatorValue=locator.split(">")[1];

        if (locatorBy.equals("id")){
            return By.id(locatorValue);
        }else if (locatorBy.equals("name")){
            return By.name(locatorValue);
        }else if (locatorBy.equals("className")){
            return By.className(locatorValue);
        }else {
            return By.xpath(locatorValue);
        }
    }

    public void getBy() throws IOException {
        ProUtil proUtil=new ProUtil("src/main/resources/element.properties");

    }



    public static void main(String[] args) throws InterruptedException, IOException {
        LoginCase loginCase=new LoginCase();
        loginCase.InitDriver();
        loginCase.userLogin();
    }








}
