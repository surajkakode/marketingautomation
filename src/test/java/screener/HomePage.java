package screener;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public static final Logger log = Logger.getLogger(HomePage.class.getName());
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='company-info']/h1")
    private WebElement companyName;

    @FindBy(xpath = "//*[@id='company-info']/following-sibling::p")
    private WebElement companyInfo;

    @FindBy(xpath = "//section[1]")
    private WebElement companyValue;

    @FindBy(xpath = "//*[@id='analysis']/div/div[1]")
    private WebElement pros;
    @FindBy(xpath = "//*[@id='analysis']/div/div[2]")
    private WebElement cons;

    @FindBy(xpath = "//*[@id='peers']//tbody")
    private WebElement peers;

    @FindBy(xpath = "//*[@id='quarters']//table")   ////*[@id='quarters']//tbody to exclude 1st coloum
    private WebElement quarters;

    @FindBy(xpath = "//*[@id='profit-loss']//table")
    private List<WebElement> profitLoss;

    @FindBy(xpath = "//*[@id='balance-sheet']//table")
    private WebElement balanceSheet;

    @FindBy(xpath = "//*[@id='cash-flow']//table")
    private WebElement cashFlow;

    @FindBy(xpath = "//*[@id='ratios']//table")
    private WebElement ratiostable;

    @FindBy(xpath = "//*[contains(text(),'Recent Announcements')]/following-sibling::ul")
    private WebElement announcement;
    @FindBy(xpath = "//*[contains(text(),'Annual Reports')]/following-sibling::ul")
    private WebElement reports;
    @FindBy(xpath = "//*[contains(text(),'Credit Ratings')]/following-sibling::ul")
    private WebElement ratings;

    @FindBy(xpath = "//tr//button")
    private List<WebElement> expand;

    @FindBy(xpath = "h1")
    private WebElement title;

    public void waitTillElementclickable(WebElement element,int sec)
    {
        new WebDriverWait(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTillElementclickable(List<WebElement> element,int sec)
    {
        new WebDriverWait(driver,sec).until(ExpectedConditions.elementToBeClickable(element.get(0)));
    }

    public void isPagefunctional()
    {
        try {
            waitTillElementclickable(title,10);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    public void expandAllRow() {

        try {
            waitTillElementclickable(expand,30);
        } catch (Exception e) {
            log.error("Unable to load page");
        }
        for (WebElement element : expand) {
            element.click();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }

        }

    }

    public String getCompanyName() {
        try {
            return companyName.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getCompanyInfo() {
        try {
            return companyInfo.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getCompanyValue() {
        try {
            return companyValue.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getPros() {
        try {
            return pros.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getCons() {
        try {
            return cons.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public void getheader(List<WebElement> rows) {
        List<WebElement> cols = rows.get(0).findElements(By.tagName("th"));

    }

    public List<Peers> getPeers() {

        List<Peers> peersList = new ArrayList<>();
        List<WebElement> rows = peers.findElements(By.tagName("tr"));


        for (int i = 0; i < rows.size(); i++)  //to exclude 1st coloum set counter i=1.
        {
            List<WebElement> cols;
            if (i == 0) {
                cols = rows.get(i).findElements(By.tagName("th"));
            } else {
                cols = rows.get(i).findElements(By.tagName("td"));
            }


            Peers peers = new Peers();
            peers.setSno(cols.get(0).getText());
            peers.setName(cols.get(1).getText());
            peers.setCmp(cols.get(2).getText());
            peers.setPe(cols.get(3).getText());
            peers.setMarcap(cols.get(4).getText());
            peers.setDividendyeild(cols.get(5).getText());
            peers.setNetprofitlatestQauter(cols.get(6).getText());
            peers.setYouquarterlyprofitgrowth(cols.get(7).getText());
            peers.setSaleslatestquarter(cols.get(8).getText());
            peers.setYoyquarterlysalesgrowth(cols.get(9).getText());
            peers.setRoce(cols.get(10).getText());

            peersList.add(peers);
        }
        return peersList;
    }

    public List<ColoumData> getQuarters() {

        List<WebElement> rows = quarters.findElements(By.tagName("tr"));
        return getcoloumData(rows);
    }

    public void addEmptyData(List cols, int count) {
        for (int i = 0; i < count; i++) {
            cols.add(new WebElement() {
                @Override
                public void click() {

                }

                @Override
                public void submit() {

                }

                @Override
                public void sendKeys(CharSequence... charSequences) {

                }

                @Override
                public void clear() {

                }

                @Override
                public String getTagName() {
                    return null;
                }

                @Override
                public String getAttribute(String s) {
                    return null;
                }

                @Override
                public boolean isSelected() {
                    return false;
                }

                @Override
                public boolean isEnabled() {
                    return false;
                }

                @Override
                public String getText() {
                    return "";
                }

                @Override
                public List<WebElement> findElements(By by) {
                    return null;
                }

                @Override
                public WebElement findElement(By by) {
                    return null;
                }

                @Override
                public boolean isDisplayed() {
                    return false;
                }

                @Override
                public Point getLocation() {
                    return null;
                }

                @Override
                public Dimension getSize() {
                    return null;
                }

                @Override
                public Rectangle getRect() {
                    return null;
                }

                @Override
                public String getCssValue(String s) {
                    return null;
                }

                @Override
                public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
                    return null;
                }
            });
        }
    }

    public List<ColoumData> getcoloumData(List<WebElement> rows)
    {
        List<ColoumData> coloumDataList = new ArrayList<>();
        boolean header = false;
        int expected_td = 0;
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cols;
            if (header == false) {
                cols = rows.get(i).findElements(By.tagName("th"));
                header = true;
            } else {
                cols = rows.get(i).findElements(By.tagName("td"));
            }
            if (i == 0) {
                expected_td = cols.size();
            }

            addEmptyData(cols, expected_td - cols.size());

            ColoumData obj = new ColoumData();
            int size = cols.size();
            WebElement firstTd = cols.get(0);
            String value = firstTd.getAttribute("style");
            obj.setParent(value.indexOf("padding-left") == -1);
            List<String> dataColumns = new ArrayList<String>();
            for (int j = 0; j < cols.size(); j++) {
                dataColumns.add(cols.get(j).getText());
            }
            obj.setColumns(dataColumns);
            coloumDataList.add(obj);
        }
        return coloumDataList;

    }

    public List<ColoumData> getProfitLoss() {

        List<WebElement> rows = profitLoss.get(0).findElements(By.tagName("tr"));
        return getcoloumData(rows);

    }

    public List<CompoundGrowth> getCompoundSalesGrowth() {
        List<CompoundGrowth> list = new ArrayList<>();
        List<WebElement> rows = profitLoss.get(1).findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {


            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            CompoundGrowth obj = new CompoundGrowth();

            obj.setYears(cols.get(0).getText());
            obj.setGrowth(cols.get(1).getText());
            list.add(obj);
        }
        return list;
    }

    public List<CompoundGrowth> getCompoundProfitGrowth() {
        List<CompoundGrowth> list = new ArrayList<>();
        List<WebElement> rows = profitLoss.get(2).findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            CompoundGrowth obj = new CompoundGrowth();

            obj.setYears(cols.get(0).getText());
            obj.setGrowth(cols.get(1).getText());

            list.add(obj);
        }
        return list;
    }

    public List<CompoundGrowth> getReturnOnEquity() {
        List<CompoundGrowth> list = new ArrayList<>();
        List<WebElement> rows = profitLoss.get(3).findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            CompoundGrowth obj = new CompoundGrowth();

            obj.setYears(cols.get(0).getText());
            obj.setGrowth(cols.get(1).getText());

            list.add(obj);
        }
        return list;
    }


    public List<ColoumData> getBalanceSheet() {

        List<WebElement> rows = balanceSheet.findElements(By.tagName("tr"));
        return getcoloumData(rows);
    }

    public List<ColoumData> getCashFlow() {

        List<WebElement> rows = cashFlow.findElements(By.tagName("tr"));
        return getcoloumData(rows);
    }

    public List<ColoumData> getRatios() {

        List<WebElement> rows = ratiostable.findElements(By.tagName("tr"));
        return getcoloumData(rows);
    }

    public List<RecentAnnouncements> getRecentAnnuouncement() {
        List<RecentAnnouncements> documentsList = new ArrayList<>();
        try {
            List<WebElement> rows = announcement.findElements(By.tagName("li"));

            for (int i = 0; i < rows.size(); i++) {
                RecentAnnouncements obj = new RecentAnnouncements();

                obj.setName(rows.get(i).findElement(By.tagName("a")).getText());
                obj.setLink(rows.get(i).findElement(By.tagName("a")).getAttribute("href"));
                obj.setDate(rows.get(i).findElement(By.tagName("span")).getText());
                documentsList.add(obj);
            }
        } catch (Exception e) {
            log.info("No Recent Announcement Found");
        }
        return documentsList;
    }

    public List<AnnualReports> getAnnualReports() {
        List<AnnualReports> documentsList = new ArrayList<>();
        try {
            List<WebElement> rows = reports.findElements(By.tagName("li"));

            for (int i = 0; i < rows.size(); i++) {
                AnnualReports obj = new AnnualReports();

                obj.setName(rows.get(i).findElement(By.tagName("a")).getText());
                obj.setLink(rows.get(i).findElement(By.tagName("a")).getAttribute("href"));
                obj.setFrom(rows.get(i).findElement(By.tagName("span")).getText());
                documentsList.add(obj);
            }
        } catch (Exception e) {
            log.info("No Annual Reports Found");
        }
        return documentsList;
    }

    public List<CreditRatings> getCreditRatings() {
        List<CreditRatings> documentsList = new ArrayList<>();
        try {
            List<WebElement> rows = ratings.findElements(By.tagName("li"));

            for (int i = 0; i < rows.size(); i++) {
                CreditRatings obj = new CreditRatings();

                obj.setName(rows.get(i).findElement(By.tagName("a")).getText());
                obj.setLink(rows.get(i).findElement(By.tagName("a")).getAttribute("href"));
                obj.setCredit(rows.get(i).findElement(By.tagName("span")).getText());
                documentsList.add(obj);
            }
        } catch (Exception e) {
            log.info("No credit Rating");
        }
        return documentsList;
    }

}
