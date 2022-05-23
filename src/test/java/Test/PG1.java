package Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;


public class PG1 {

  public WebDriver driver; 
  public String baseUrl = "https://www.lambdatest.com/";
    
    @Test
    public void testWebDriverBackedSelenium(){
        
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--headless");
    driver = new ChromeDriver(options);    
        
        
    driver.manage().window().maximize();  
    driver.get(baseUrl);
    driver.close();


}
}
