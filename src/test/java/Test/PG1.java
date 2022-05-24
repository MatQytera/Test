package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class QLoadPO
{
    public WebDriver driver;
    //public String baseUrl = "http://192.168.178.120:8081/app/index.html";
    public String baseUrl = "http://qload-api.eba-9gsnxmph.eu-central-1.elasticbeanstalk.com/";

    public static final By emailaddressefield = By.xpath("//input[@id='exampleInputEmail1']");
    String email =  "jane.doe";
    
    public static final By passwordfield = By.xpath("//*[@id=\"exampleInputPassword1\"]");
    String password = "Test_1234";
    
    public static final By submit = By.xpath("//button[@type='submit']");
    
    @Test
    public void goToRootPage() {

        
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
        /*driver.findElement(emailaddressefield).sendKeys(email);
        driver.findElement(passwordfield).sendKeys(password);
        driver.findElement(submit).click();*/
        driver.close();
    }
    
    
    @Test
    public void emailAddressInsert(){
       driver.findElement(emailaddressefield).sendKeys(email)
    }
    
    @Test
    public void passwordInsert(){{
        driver.findElement(passwordfield).sendKeys(password);
    }
    
    @Test                             
    public void submitClick() {

      
        driver.findElement(submit).click();
    }
    
}
