package de.qload.Webpages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class QLoadPO {

    private WebDriver driver;

    public String baseUrl = "http://qload-api.eba-vtn3fmhm.eu-central-1.elasticbeanstalk.com/app/index.html";

    public static final By emailaddressefield = By.xpath("//input[@id='username_input']");
    String email =  "jane.doe";

    public static final By passwordfield = By.xpath("//*[@id=\"password_input\"]");
    String password = "Test_1234";

    public static final By submit = By.xpath("//button[@type='submit']");




    public QLoadPO(WebDriver driver){
        this.driver=driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void goToRootPage() {

        driver.get(baseUrl);
    }

    public void emailAddressInsert(){
        driver.findElement(emailaddressefield).sendKeys(email);
    }

    public void passwordInsert(){
        driver.findElement(passwordfield).sendKeys(password);
    }

    public void submitClick() {
        driver.findElement(submit).click();
    }

}
