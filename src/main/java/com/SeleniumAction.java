package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumAction {

    WebDriver driver;
    public void InitDriver() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/java/com/Util/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://www.imooc.com");

    }


    //获取input输入框的值
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
        boolean isable = webElement.isEnabled();//该输入框是否可以输入
        webElement.clear();//清空输入框
        Thread.sleep(1000);
        System.out.println("isable："+isable);
        driver.close();
    }


    //获取input输入框的值
    public void input111() throws InterruptedException {

        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(2000);

        WebElement webElement=driver.findElement(By.name("email"));//获取到账号输入框
        webElement.sendKeys("17757101629");
        Thread.sleep(1000);
        webElement.clear();
        Thread.sleep(1000);
        webElement.sendKeys("1111111111234567896534567890-0987234567890$%^&*()(*&^%$11111111111111");//账号输入内容超长
        driver.findElement(By.className("rl-modal-header")).click();//点击一下空白处，这样提示文案才会出来
        List<WebElement> buttonElement=driver.findElements(By.className("rlf-tip-wrap"));//先获取这个className
        String strErr=buttonElement.get(0).getAttribute("data-error-hint");//因为有多个，所以我们取第一个，把提示信息取出来
        System.out.println("strErr:"+strErr);
        Thread.sleep(1000);
        driver.close();

    }


    //登录
    public  void  login() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("17757101629");//获取账号输入框,并输入账号
        driver.findElement(By.name("password")).sendKeys("aaa111000");//获取密码输入框，并输入密码
        driver.findElement(By.className("xa-login")).click();//获取登录，点击登录按钮

    }

    public void danxuankuang() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://www.imooc.com/user/setprofile");//进入个人信息页面
        Thread.sleep(2000);
        driver.findElement(By.className("js-edit-info")).click();//点击编辑按钮
        Thread.sleep(2000);
        WebElement webElement=driver.findElements(By.className("rlf-radio-group")).get(1);
        List<WebElement> sexList=webElement.findElements(By.name("sex"));

        for (WebElement sex:sexList){//这块是单选框的重点，
            if(sex.isSelected()){//判断当前是否被选中
                continue;//选中的话，继续下一个
            }else {//如果没有被选中，点击选中，断开
                sex.click();
                break;
            }
        }
        driver.findElement(By.id("profile-submit")).click();//点击确定按钮
        driver.close();


    }

    public void fuxuankuang() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();//点击登录按钮
        Thread.sleep(2000);
        WebElement webElement=driver.findElement(By.id("auto-signin"));
        webElement.click();
        Thread.sleep(1000);
        webElement.isSelected();//判断是否被选中
        driver.close();
    }



    public void button() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();
        Thread.sleep(2000);
        System.out.println("-------还未开始隐藏登录按钮");
        WebElement webElement=driver.findElement(By.className("moco-btn-red"));
        System.out.println(webElement.isDisplayed());//判断是否隐藏
        System.out.println(webElement.isEnabled());//判断是否可用
        System.out.println("-------开始隐藏登录按钮");
        String jsString ="document.getElementsByClassName(\'moco-btn-red\')[0].style.display=\'None\'";
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript(jsString);
        WebElement webElement11=driver.findElement(By.className("moco-btn-red"));
        System.out.println(webElement11.isDisplayed());
        System.out.println(webElement11.isEnabled());
        Thread.sleep(2000);
        driver.close();
    }


    /**
     * input 类型上传头像
     * @throws InterruptedException
     */
    public  void upFileINput() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.imooc.com/user/setbindsns");//跳转到个人中心页面
        WebElement webElement=driver.findElement(By.className("avator-img"));//获取到头像模块
        Actions actions=new Actions(driver);
        actions.moveToElement(webElement).perform();//模拟鼠标移动到头像上
        driver.findElement(By.className("update-avator")).click();//获取到更换头像，然后点击
        driver.findElement(By.id("upload")).sendKeys("/Users/gaofeng/Downloads/YU.jpeg");//上传头像
        Thread.sleep(2000);
        driver.close();
    }

    //select下拉框选择
    public void select() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("https://www.imooc.com/user/setprofile");//进入个人信息页面
        Thread.sleep(2000);
        driver.findElement(By.className("js-edit-info")).click();//点击编辑按钮
        Thread.sleep(2000);

        List<WebElement> webElement=driver.findElements(By.className("rlf-select"));//获取到上一层级
        webElement.get(1).click();//点击下拉框
        List<WebElement> list=webElement.get(1).findElements(By.tagName("option"));//获取到下拉框元素
        Thread.sleep(1000);
        list.get(4).click();//获取第5个值，点击，这样就完成了下拉框的操作
        Thread.sleep(1000);
        driver.findElement(By.id("profile-submit")).click();
        driver.close();

    }





    public static void main(String[] args) throws InterruptedException {
        SeleniumAction seleniumAction=new SeleniumAction();
        seleniumAction.InitDriver();
//        seleniumAction.input();
//        seleniumAction.input111();
        seleniumAction.login();
//        seleniumAction.danxuankuang();
//        seleniumAction.fuxuankuang();
//        seleniumAction.button();
//        seleniumAction.upFileINput();
        seleniumAction.select();

    }


}
