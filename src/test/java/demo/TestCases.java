package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.swing.Action;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import dev.failsafe.internal.util.Assert;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        
        
    }
   
    @Test
    public void testCase01() throws InterruptedException{

        

        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



       

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@jscontroller='oCiKKc']/div[1]/div[1]/div[1]/div[1]/input")));
        WebElement name= driver.findElement(By.xpath("//div[@jscontroller='oCiKKc']/div[1]/div[1]/div[1]/div[1]/input"));
        
        name.sendKeys("Crio Learner");
        Thread.sleep(5000);
        System.out.println("Name has given");


        WebElement ans = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        ans.sendKeys("I want to be the best QA Engineer! 171057202");
        Thread.sleep(5000);
        System.out.println("Answer has given");


        WebElement experience= driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb'][1]"));
        experience.click();
        Thread.sleep(5000);
        System.out.println("Experience has selected");

        WebElement ckbx1 = driver.findElement(By.xpath("//div[@class='eBFwI'][1]"));
        ckbx1.click();
        Thread.sleep(3000);
        WebElement ckbx2 = driver.findElement(By.xpath("//div[@class='eBFwI'][2]"));
        ckbx2.click();
        Thread.sleep(3000);
        WebElement ckbx3 = driver.findElement(By.xpath("//div[@class='eBFwI'][4]"));
        ckbx3.click();
        Thread.sleep(3000);
        System.out.println("Skills that learn from crio");




        WebElement addresed = driver.findElement(By.xpath("//span[text()='Choose']"));
        addresed.click();
        Thread.sleep(3000);
        WebElement addressname= driver.findElement(By.xpath("//div[@class='OA0qNb ncFHed QXL7Te']/div[6]"));
        addressname.click();
        Thread.sleep(3000);
        System.out.println("addressed");

        
        LocalDate date=LocalDate.now().minusDays(7);
        DateTimeFormatter format= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatedDate= date.format(format);
        WebElement calender= driver.findElement(By.xpath("//div[@jscontroller='lLliLe']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input"));
        calender.sendKeys(formatedDate);
        // int width = calender.getSize().getWidth();
        // Actions action = new Actions(driver);
        // action.moveToElement(calender, (width/2)-4,0).click().perform();

        Thread.sleep(5000);
        System.out.println("Todays Date - 7 has given");


        // LocalTime time = LocalTime.of(7, 30);
        // DateTimeFormatter formatter= DateTimeFormatter.ofPattern("HH:mm");
        // String formatTime = time.format(formatter);

        WebElement timehr= driver.findElement(By.xpath("//div[@class='ocBCTb']/div[1]/div[2]/div[1]/div[1]/div[1]/input"));
        // "//div[@class='ocBCTb']/div[1]/div[2]/div[1]/div[1]/div[1]/input"
        // //div[@jscontroller='OZjhxc']/div[1]
        timehr.sendKeys("07");
        Thread.sleep(3000);
        WebElement timemin= driver.findElement(By.xpath("//div[@class='ocBCTb']/div[3]/div[1]/div[1]/div[1]/div[1]/input"));
        timemin.sendKeys("30");
        Thread.sleep(3000);
        // WebElement ampm= driver.findElement(By.xpath("//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb']"));
        // ampm.click();
        // Thread.sleep(3000);
        // WebElement slctam= driver.findElement(By.xpath("//div[@class='jgvuAb ybOdnf f0pfFe t9kgXb llrsB iWO5td']/div[2]/div[1]"));
        // slctam.click();
        // Thread.sleep(3000);
        System.out.println("time has given");


        WebElement submit= driver.findElement(By.xpath("//div[@class='lRwqcd']/div[1]/span"));
        submit.click();
        Thread.sleep(5000);

        WebElement msg = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        String tnxmsg= msg.getText();
        System.out.println(tnxmsg);


        
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}