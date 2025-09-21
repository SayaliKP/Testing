package com.transflower;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test {
    private static WebDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/src/Webpages/login.html");
    }

    @Test
    void testLoginForm() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("loginButton"));

        username.sendKeys("sayaliparanjape@gmail.com");
        password.sendKeys("sayali@123");

        String enteredUser = username.getAttribute("value");
        String enteredPass = password.getAttribute("value");

        login.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("msg")));

        if (enteredUser.equals("sayaliparanjape@gmail.com") && enteredPass.equals("sayali@123")) {

            message.sendKeys("Login Sucessfully");
        } else {

            message.sendKeys("Login unsucessfully");
        }
    }

    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
