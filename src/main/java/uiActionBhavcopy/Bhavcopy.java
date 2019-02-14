package uiActionBhavcopy;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.Utility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Bhavcopy {

    public static final Logger log = Logger.getLogger(Bhavcopy.class.getName());

    WebDriver driver;

    public Bhavcopy(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    String fileName;
    public final String BHAVCOPY = "Bhavcopy";
    @FindBy (xpath = "//*[@id='h_filetype']")
    private WebElement selectReport;

    @FindBy (xpath = "//*[@id='date']")
    private WebElement date;

    @FindBy (xpath = "//*[@class='getdata-button']")
    private WebElement getDataButton;

    @FindBy(xpath = "//select[contains(@class,'ui-datepicker')]")
    private WebElement datePicker;

    @FindBy (xpath = "//*[@id='spanDisplayBox']//a")
    private WebElement file;

    @FindBy(xpath = "//*[@id='spanDisplayBox']/table/tbody/tr/td[2]")
    private WebElement noFile;

    public void setSelectReport(String reportName)
    {
        waitTillElementToBeVisibleAndCliable(this.selectReport);
        Select select = new Select(this.selectReport);
        select.selectByVisibleText(reportName);

    }


    public void choosePreviousDate()
    {
        selectDate();
        waitTillElementToBeVisibleAndCliable(this.date);
        this.date.clear();
        this.date.sendKeys(previousDay+Keys.ENTER+Keys.TAB);

    }
    public void chooseDate(String date)
    {
        waitTillElementToBeVisibleAndCliable(this.date);
        this.date.clear();
        this.date.sendKeys(date+Keys.ENTER+Keys.TAB);
    }

    public void getData()
    {
        try {
            waitTillElementToBeVisibleAndCliable(this.getDataButton);
            this.getDataButton.click();
        } catch (Exception e) {
            executeJavascriptToGetFile();
        }


    }
    private void executeJavascriptToGetFile()
    {
        log.debug("executing by javaScript");
        ((JavascriptExecutor) driver).executeScript("validateInput()");
    }
    public void closeBrowser()
    {
        for (String handle : driver.getWindowHandles()) {
            if (handle != null && handle.trim().length() > 0) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.quit();
    }

    public String downloadFile() {
        try {
            String parentWindowHandle = driver.getWindowHandle();
            waitTillElementToBeVisibleAndCliable(this.file);
            this.fileName= this.file.getText();
            String url ="https://www.nseindia.com";
            String href= this.file.getAttribute("href");
            driver.get(href);
            //return fileName;
        } catch (Exception e) {
            log.error(driver.findElement(By.xpath("//*[contains(text(),'No file found')]")).getText());
            Assert.fail();
            closeBrowser();
        }
        return fileName;
    }

    private String previousDay;
    private String today;

    public void selectDate() {
        Calendar cal = Calendar.getInstance();
        DateFormat dd = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat time = new SimpleDateFormat("kk");
        this.today = dd.format(cal.getTime());

        if(cal.get(Calendar.DAY_OF_WEEK)==2) {
            cal.add(Calendar.DATE, -3);
            this.previousDay = dd.format(cal.getTime());
        }
        if(cal.get(Calendar.DAY_OF_WEEK)==1) {
            cal.add(Calendar.DATE, -2);
            this.previousDay = dd.format(cal.getTime());
        }
        if(cal.get(Calendar.DAY_OF_WEEK)==7) {
            cal.add(Calendar.DATE, -1);
            this.previousDay = dd.format(cal.getTime());
        }else {
            cal.add(Calendar.DATE, -1);
            this.previousDay = dd.format(cal.getTime());
        }

    }

    protected void waitTillElementToBeVisible(WebElement element)
    {
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitTillElementToBecliable(WebElement element)
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(element));
    }
    protected void waitTillElementToBeInVisible(WebElement element)
    {
        new WebDriverWait(driver,10).until(ExpectedConditions.stalenessOf(element));
    }
    protected void waitTillElementToBeVisibleAndCliable(WebElement element)
    {

        try {

            new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.error(e);
        }
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(element));
    }
}
