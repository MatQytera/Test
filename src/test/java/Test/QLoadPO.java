package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import java.lang.Thread;  

public class QLoadPO 
{
    public WebDriver driver;
    //public String baseUrl = "http://192.168.178.120:8081/app/index.html";
    public String baseUrl = "qload-api.eba-snwykjch.eu-central-1.elasticbeanstalk.com";

    public static final By emailaddressefield = By.xpath("//input[@id='exampleInputEmail1']");
    String email =  "jane.doe";
    
    public static final By passwordfield = By.xpath("//*[@id=\"exampleInputPassword1\"]");
    String password = "Test_1234";
    
    public static final By submit = By.xpath("//button[@type='submit']");
    
    @Test
    public void goToRootPage() throws InterruptedException {

        
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);

       
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(emailaddressefield).sendKeys(email);
        driver.findElement(passwordfield).sendKeys(password);
        driver.findElement(submit).click();
        //driver.close();
        //"//input[@id='resourceFiles']"
        //"//input[@id='jmeterProjectFile']"
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='jmeterProjectFile']")).sendKeys((System.getProperty("user.dir") + "/src/main/resources/uploaddata/example-project.jmx"));
        driver.findElement(By.xpath("//input[@id='resourceFiles']")).sendKeys((System.getProperty("user.dir") + "/src/main/resources/uploaddata/4cee28e5new-Kopie.jpg"));
        driver.findElement(submit).click();
        
        
    }
    
    
    
}

