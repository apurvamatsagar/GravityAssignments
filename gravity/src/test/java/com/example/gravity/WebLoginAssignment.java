package com.example.gravity;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class WebLoginAssignment
{

    public static void main(String[] args)
    {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\gravity\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            //Open URL
            driver.get("https://www.automationpractice.pl/index.php");
            driver.manage().window().maximize();


            //Click on login button
            driver.findElement(By.className("login")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
            WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));

            //Enter username
            usernameField.sendKeys("apurvamatsagar178@gmail.com");

            //Enter Password
            WebElement passwordField= driver.findElement(By.id("passwd"));
            passwordField.sendKeys("Testgma@123");


            //Click on Submit button
            driver.findElement(By.id("SubmitLogin")).click();

            //Verify Login Success
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle);
            String acceptableTitle = "My account - My Shop";
            Assert.assertEquals(pageTitle, acceptableTitle);

        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
