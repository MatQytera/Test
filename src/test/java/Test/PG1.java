package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;


public class PG1 {

    @Test
    public void testWebDriverBackedSelenium(){
    // declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver","C:\\Webdriver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    //comment the above 2 lines and uncomment below 2 lines to use Chrome
    //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();

    String baseUrl = "http://demo.guru99.com/test/newtours/";
    String expectedTitle = "Welcome: Mercury Tours";
    String actualTitle = "";

    // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

    // get the actual value of the title
    actualTitle =driver.getTitle();

    /*
     * compare the actual title of the page with the expected one and print
     * the result as "Passed" or "Failed"
     */
        if(actualTitle.contentEquals(expectedTitle))

    {
        System.out.println("test.Test Passed!");
    } else

    {
        System.out.println("test.Test Failed");
    }

    //close Fire fox
        driver.close();

}
}