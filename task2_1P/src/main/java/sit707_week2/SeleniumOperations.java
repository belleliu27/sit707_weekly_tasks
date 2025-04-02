package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void officeworks_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/junzhang/Downloads/chromedriver-mac-arm64/chromedriver");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load the registration page in chromium browser.
        driver.get(url);

        // Wait for the registration form to load
        WebDriverWait wait = new WebDriverWait(driver, 10);  // Timeout in seconds for older versions

        try {
            // Find and populate the input fields
            WebElement firstName = driver.findElement(By.id("firstname"));
            firstName.sendKeys("Belle");

            WebElement lastName = driver.findElement(By.id("lastname"));
            lastName.sendKeys("Liu");

            WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
            phoneNumber.sendKeys("0432345487");

            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("belle@example.com");

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("test@123");

            WebElement confirmPassword = driver.findElement(By.id("confirmPassword"));
            confirmPassword.sendKeys("test@123");

            // Identify button 'Create account' and click to submit using Selenium API
            WebElement createAccountButtonSubmit = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
            createAccountButtonSubmit.click();

            // Sleep to wait for the page to process
            sleep(2);

            // Take screenshot using selenium API
            takeScreenshot(driver, "officeworks_registration.png");
            sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sleep a while and close the chrome driver
        sleep(2);
        driver.close();
    }
    
    public static void bunnings_registration_page(String url) {
        // Step 1: Locate chrome driver folder in the local drive.
        System.setProperty("webdriver.chrome.driver", "/Users/junzhang/Downloads/chromedriver-mac-arm64/chromedriver");

        // Step 2: Use above chrome driver to open up a chromium browser.
        System.out.println("Fire up chrome browser.");
        WebDriver driver = new ChromeDriver();

        System.out.println("Driver info: " + driver);

        sleep(2);

        // Load the registration page in chromium browser.
        driver.get(url);

        // Wait for the registration form to load
        WebDriverWait wait = new WebDriverWait(driver, 10);  // Timeout in seconds for older versions

        try {
            // Find and populate the input fields
        	

            WebElement email = driver.findElement(By.id("uid"));
            email.sendKeys("belle@example.com");
        	
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("test123123...");
            
        	WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys("Belle");

            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys("Liu");

            // Identify button 'Create Account' and click to submit using Selenium API
            WebElement createAccountButtonSubmit = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
            createAccountButtonSubmit.click();

            // Sleep to wait for the page to process
            sleep(2);

            // Take screenshot using selenium API
            takeScreenshot(driver, "bunnings_registration.png");
            sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sleep a while and close the chrome driver
        sleep(2);
        driver.close();
    }


    public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName));
            System.out.println("Screenshot saved: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
