package amfi;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testBase.TestBase;
import uiActionAMFI.FormSearch;

import java.util.Set;

public class DistributorData extends TestBase{

    public static final Logger log = Logger.getLogger(DistributorData.class.getName());

    @BeforeMethod
    public void setup() {
        init();
    }

    FormSearch data;

    @Test
    public void downloadDistributorData()
    {
        driver.get("https://www.amfiindia.com/locate-your-nearest-mutual-fund-distributor-details");

        data =new FormSearch(driver);

        //Set <String> citylist = data.getCityList();
        if (System.getProperty("cityname")!=null)
        {
            data.selectCity(System.getProperty("cityname"));
        }
        else {
            log.error("City name is null");
        }
        data.processBatch();



    }

    @AfterMethod
    public void closeBrowser() {
        for (String handle : driver.getWindowHandles()) {
            if (handle != null && handle.trim().length() > 0) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.quit();
    }
}
