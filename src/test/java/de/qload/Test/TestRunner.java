package de.qload.Test;

import de.qload.Webpages.QLoadPO;
import de.qload.Webpages.UpLoadSuiteCRMPO;
import de.qload.Webpages.UploadQyteraWebsitePO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestRunner {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        //use FF Driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testrunner() {

        QLoadPO qloadpo = new QLoadPO(driver);
        qloadpo.goToRootPage();
        qloadpo.emailAddressInsert();
        qloadpo.passwordInsert();
        qloadpo.submitClick();

        UploadQyteraWebsitePO uploadpwebsitepo = new UploadQyteraWebsitePO(driver);
        uploadpwebsitepo.selectQyteraWebsiteInDropdown();
        uploadpwebsitepo.uploadJMeterProject ();
        uploadpwebsitepo.dragnDrop();
        uploadpwebsitepo.verfiyDataOnAWSCloudforQyteraWebsite();
        uploadpwebsitepo.deleteDataOnAWSCloudforQyteraWebsite();
        uploadpwebsitepo.createEnviroment();
        uploadpwebsitepo.printResults();
        uploadpwebsitepo.destroyEnviroment ();
        uploadpwebsitepo.uploadClick();

        UpLoadSuiteCRMPO uploadsuitecrmpo = new UpLoadSuiteCRMPO(driver);
        uploadsuitecrmpo.selectQyteraWebsiteInDropdown();
        uploadsuitecrmpo.uploadJMeterProject ();
        uploadsuitecrmpo.dragnDrop();
        uploadsuitecrmpo.verfiyDataOnAWSCloudforQyteraWebsite();
        uploadsuitecrmpo.deleteDataOnAWSCloudforQyteraWebsite();
        uploadsuitecrmpo.createEnviroment();
        uploadsuitecrmpo.printResults();
        uploadsuitecrmpo.destroyEnviroment ();
        uploadsuitecrmpo.uploadClick();

    }

    @AfterTest
    public void close(){
        driver.close();
    }


}
