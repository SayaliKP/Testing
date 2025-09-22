package com.transflower;


import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://127.0.0.1:5500/src/Webpages/Registration.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test_register() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement age = driver.findElement(By.id("age"));
        WebElement dob = driver.findElement(By.id("dob"));
        WebElement male = driver.findElement(By.id("male"));
        WebElement female = driver.findElement(By.id("female"));
        WebElement reading = driver.findElement(By.id("reading"));
        WebElement sports = driver.findElement(By.id("sports"));
        WebElement music = driver.findElement(By.id("music"));
        WebElement country = driver.findElement(By.id("country"));
        WebElement address = driver.findElement(By.id("address"));
        WebElement button = driver.findElement(By.id("submit"));
        WebElement reset = driver.findElement(By.id("reset"));
        WebElement msg=driver.findElement(By.id("msg"));

        
        username.sendKeys("Sayali Paranjape");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        email.sendKeys("sayaliparanjape@gmail.com");
         try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        password.sendKeys("sayali123");
         try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        age.sendKeys("25");
         try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        dob.sendKeys("03-12-2000"); // Correct date format for <input type="date">
         try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        female.click();
        reading.click();
        music.click();

        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText("India");

        address.sendKeys("Pune");

        String enteredusername = username.getAttribute("value");
         try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        button.click();
         try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        
        WebElement welcomeMessage = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("msg"))
        );
         try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
           //assertTrue(msg.isDisplayed());
        assertTrue(welcomeMessage.getText().contains("Welcome "+ enteredusername));
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
