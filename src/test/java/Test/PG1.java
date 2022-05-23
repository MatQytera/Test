package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import java.util.concurrent.TimeUnit;


public class PG1
{
    public WebDriver driver;
    public String baseUrl = "http://192.168.178.120:8081/app/index.html";

    public static final By emailaddressefield = By.xpath("//input[@id='exampleInputEmail1']");
    String email =  "jane.doe";
    
    public static final By passwordfield = By.xpath("//*[@id=\"exampleInputPassword1\"]");
    String password = "Test_1234";
    
    public static final By submit = By.xpath("//button[@type='submit']");
    
    @Test
    public void test1() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
               
       
    }
    
    @Test
    public void emailAddressInsert(){
        driver.findElement(emailaddressefield).sendKeys(email);

    }

    @Test
    public void passwordInsert(){
        driver.findElement(passwordfield).sendKeys(password);
    }
    
    @Test
    public void submitClick() {

       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(testautomatisation));
        driver.findElement(submit).click();
    }
    
}
