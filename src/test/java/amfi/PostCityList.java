package amfi;

import bhavcopy.BhavcopyData;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testBase.TestBase;
import uiActionAMFI.FormSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PostCityList extends TestBase{

    public static final Logger log = Logger.getLogger(PostCityList.class.getName());

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
        Set <String> city =new TreeSet<>();
        city = data.getCityList();
        List<String> citylist =new ArrayList<>(city);
        //List<String> citylist= (List<String>) city;
        processList(citylist);



    }

    public void processList(List <String> citylist)
    {   int batchCount=100;
        int count = citylist.size() / batchCount;
        int remainder = citylist.size() % batchCount;

        for(int k =0;k < count; k++) {
            int from = k*batchCount;
            int to = (k+1)*batchCount;
            log.info("FROM ["+from + "] TO ["+ to+"]");
            postData(citylist.subList(from, to));
        }

        if (remainder > 0) {
            postData(citylist.subList(count*batchCount, (count*batchCount) + remainder));
        }
    }
    public void postData(List<String> data) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(System.getProperty("userName"));
        authScheme.setPassword(System.getProperty("passWord"));
        RestAssured.authentication = authScheme;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        Gson gson = new Gson();
        String json =  gson.toJson(data);
        request.body(json);
        Response response = request.post(System.getProperty("URI"));
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
