package com.adaction.util;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;
    protected static Scenario scenario;
    //  public WebDriver driver = new ChromeDriver();

    public static String readProperties(String key)
    {
        String value=null;
        try
        {
            File file=new File("src/test/Resources/config.properties");
            FileInputStream fis=new FileInputStream(file);
            Properties properties=new Properties();
            properties.load(fis);
            value=properties.getProperty(key);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
            return value;
        }


    public void launchBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
      
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.chromedriver().setup();
            driver = new EdgeDriver();

        }
    }

    public void open_the_application(String url)
    {
        if(driver==null)
        {
            driver = new ChromeDriver();
        }
        driver.get(url);
    }

    public void maxi() {
        driver.manage().window().maximize();
        System.out.println("Window is maximized now");
    }

    public void iwait(int wait) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void enter_and(WebElement element, String value) {
      element.clear();
     element.sendKeys(value);
    }

    public void tap(WebElement element) {
        element.click();
    }

    public void screenShot(String path) {
        try {
            TakesScreenshot tk = (TakesScreenshot) driver;
            File src = tk.getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] screenShot()
    {
        TakesScreenshot tk=(TakesScreenshot)driver;
        return tk.getScreenshotAs(OutputType.BYTES);
    }

  public void close() {
      driver.quit();
   }
}
