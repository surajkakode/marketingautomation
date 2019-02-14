package screener;

import org.apache.log4j.Logger;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import testBase.TestBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ScreenerAutomation extends TestBase {


    public static final Logger log = Logger.getLogger(ScreenerAutomation.class.getName());


    @BeforeTest
    public void setup() {
        init();
//        try {
//            loadUserProperty();
//        } catch (IOException e) {
//            log.error(e);
//        }
    }


    private Screener screener;

    public Screener getScreener() {
        return screener;
    }

    public void setScreener(Screener screener) {
        this.screener = screener;
    }



    //private String ticker;

//    public void loadUserProperty() throws IOException {
//        this.csvFile = System.getProperty("csvFile");
//        log.info(this.csvFile);
//    }

    /*@DataProvider(name = "symbol")
    public Iterator<Object []> bhavcopyReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("csvFile")));
        String line;
        List<Object[]> cols = new ArrayList<>();
        String[] data = null;
        while ((line = br.readLine()) != null) {
            // use comma as separator
            data = line.split(",");
            cols.add(data);

        }
        cols.remove(0);
        return cols.iterator();



    }*/

/*
    @Test(dataProvider = "symbol")
    public void screenerData(String SYMBOL, String SERIES, String OPEN, String HIGH, String LOW, String CLOSE, String LAST, String PREVCLOSE, String TOTTRDQTY, String TOTTRDVAL, String TIMESTAMP, String TOTALTRADES, String ISIN) {
*/


        @Test
    public void screenerData() {

        String SYMBOL = System.getProperty("tickers");
        driver.get("https://www.screener.in/company/" + SYMBOL);

        HomePage homePage = new HomePage(driver);
        Screener screenerData = new Screener();

        homePage.expandAllRow();
        screenerData.setTicker(SYMBOL);
        screenerData.setCompanyName(homePage.getCompanyName());
        screenerData.setCompanyInfo(homePage.getCompanyInfo());
        CompanyValue companyValue = new CompanyValue(driver);
        screenerData.setCompanyValue(companyValue);
        screenerData.setPros(homePage.getPros());
        screenerData.setCon(homePage.getCons());
        screenerData.setPeers(homePage.getPeers());
        screenerData.setQuarters(homePage.getQuarters());
        screenerData.setProfitLoss(homePage.getProfitLoss());
        screenerData.setCompSalesGrowth(homePage.getCompoundSalesGrowth());
        screenerData.setCompoundProfitGrowths(homePage.getCompoundProfitGrowth());
        screenerData.setReturnOnEquities(homePage.getReturnOnEquity());
        screenerData.setBalanceSheet(homePage.getBalanceSheet());
        screenerData.setCashFlow(homePage.getCashFlow());
        screenerData.setRatios(homePage.getRatios());
        screenerData.setRecentAnnouncements(homePage.getRecentAnnuouncement());
        screenerData.setAnnualReports(homePage.getAnnualReports());
        screenerData.setCreditRatings(homePage.getCreditRatings());

        this.setScreener(screenerData);

        PostScreenerData postScreenerData = new PostScreenerData();
        postScreenerData.postData(this.getScreener());

    }

    @AfterTest
    public void closeBrowser() {

        /*for (Map.Entry<String, HashMap<String, String>> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }*/
        for (String handle : driver.getWindowHandles()) {
            if (handle != null && handle.trim().length() > 0) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.quit();
    }
}


