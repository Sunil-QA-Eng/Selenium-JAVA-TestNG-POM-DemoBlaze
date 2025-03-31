package com.demoblaze.browserfactory;

import com.demoblaze.propertyreader.PropertyReader;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

/**
 * Created by Sunil Suhagiya
 */
public class ManageBrowser {

    public static WebDriver driver;

    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");

    int implicitWait = Integer.parseInt(PropertyReader.getInstance().getProperty("implicitWait"));

    public ManageBrowser() {
        PageFactory.initElements(driver, this);
        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
