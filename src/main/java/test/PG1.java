package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class PG1 {


    public static WebDriver driver;
    //public String baseUrl = "http://192.168.178.120:8081/app/index.html";
    public String baseUrl = "http://qload-api.eba-9gsnxmph.eu-central-1.elasticbeanstalk.com/app/index.html";


    public static final By emailaddressefield = By.xpath("//input[@id='exampleInputEmail1']");
    String email = "jane.doe";

    public static final By passwordfield = By.xpath("//*[@id=\"exampleInputPassword1\"]");
    String password = "Test_1234";

    public static final By submit = By.xpath("//button[@type='submit']");



    public void test1() {

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


    }

   /* @de.qload.de.qload.Test.Test
    public void emailAddressInsert(){
        driver.findElement(emailaddressefield).sendKeys(email);
    }

    @de.qload.de.qload.Test.Test
    public void passwordInsert(){
        driver.findElement(passwordfield).sendKeys(password);
    }

    @de.qload.de.qload.Test.Test
    public void submitClick() {
        driver.findElement(submit).click();
    }
*/

}