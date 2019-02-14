package screener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CompanyValue {

    WebDriver driver;

    public CompanyValue(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);

        setvalue();
    }

    public void setvalue()
    {
        setMarketCap();
        setCurrentPrice();
        setFiftyTwoWeeksHigh();
        setFiftytwoweeksLow();
        setBookValue();
        setStock();
        setDividendYield();
        setRoce();
        setRoe();
        setSalesGrowth();
        setBselink();
        setNselink();
        setCompanywebsite();
        setFacevalue();
        setSector();
        setIndustry();
    }

    public String marketCap;
    public String currentPrice;
    public String fiftytwoweeksHigh;//52WeeksHigh
    public String fiftytwoweeksLow;//52WeeksLow
    public String bookValue;
    public String stock;
    public String dividendYield;
    public String roce;
    public String roe;
    public String salesGrowth;
    public String bselink;
    public String nselink;
    public String companywebsite;
    public String facevalue;
    public String sector;
    public String industry;

    public CompanyValue(WebDriver driver, String marketCap, String currentPrice, String fiftytwoweeksHigh, String fiftytwoweeksLow, String bookValue, String stock, String dividendYield, String roce, String roe, String salesGrowth, String bselink, String nselink, String companywebsite, String facevalue, String sector, String industry) {
        this.driver = driver;
        this.marketCap = marketCap;
        this.currentPrice = currentPrice;
        this.fiftytwoweeksHigh = fiftytwoweeksHigh;
        this.fiftytwoweeksLow = fiftytwoweeksLow;
        this.bookValue = bookValue;
        this.stock = stock;
        this.dividendYield = dividendYield;
        this.roce = roce;
        this.roe = roe;
        this.salesGrowth = salesGrowth;
        this.bselink = bselink;
        this.nselink = nselink;
        this.companywebsite = companywebsite;
        this.facevalue = facevalue;
        this.sector = sector;
        this.industry = industry;
    }



    public String getSector() {
        return sector;
    }

    public void setSector() {
        try {
            this.sector=driver.findElement(By.xpath("//*[@id='peers']//small/a[1]")).getText();
        } catch (Exception e) {

        }
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry() {
        try {
            this.industry=driver.findElement(By.xpath("//*[@id='peers']//small/a[2]")).getText();
        } catch (Exception e) {

        }
    }






    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap() {
        try {
            this.marketCap=driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[1]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice() {
        try {
            this.currentPrice=driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[2]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getFiftytwoweeksHigh() {
        return fiftytwoweeksHigh;
    }

    public void setFiftyTwoWeeksHigh() {
        try {
            this.fiftytwoweeksHigh = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[3]/b[1]")).getText();
        } catch (Exception e) {

        }
    }

    public String getFiftytwoweeksLow() {
        return fiftytwoweeksLow;
    }

    public void setFiftytwoweeksLow() {
        try {
            this.fiftytwoweeksLow = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[3]/b[2]")).getText();
        } catch (Exception e) {

        }
    }

    public String getBookValue() {
        return bookValue;
    }

    public void setBookValue() {
        try {
            this.bookValue = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[4]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getStock() {
        return stock;
    }

    public void setStock() {
        try {
            this.stock = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[5]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield() {
        try {
            this.dividendYield = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[6]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getRoce() {
        return roce;
    }

    public void setRoce() {
        try {
            this.roce =driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[7]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getRoe() {
        return roe;
    }

    public void setRoe() {
        try {
            this.roe = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[8]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getSalesGrowth() {
        return salesGrowth;
    }

    public void setSalesGrowth() {
        try {
            this.salesGrowth = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[9]/b")).getText();
        } catch (Exception e) {

        }
    }

    public String getBselink() {
        return bselink;
    }

    public void setBselink() {
        try {
            this.bselink = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[10]/a[1]")).getAttribute("href");
        } catch (Exception e) {

        }
    }

    public String getNselink() {
        return nselink;
    }

    public void setNselink() {
        try {
            this.nselink = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[10]/a[2]")).getAttribute("href");
        } catch (Exception e) {

        }
    }

    public String getCompanywebsite() {
        return companywebsite;
    }

    public void setCompanywebsite() {
        try {
            this.companywebsite = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[11]/a")).getAttribute("href");
        } catch (Exception e) {

        }
    }

    public String getFacevalue() {
        return facevalue;
    }

    public void setFacevalue() {
        try {
            this.facevalue = driver.findElement(By.xpath("//*[@id='main-area']/section[1]/ul/li[12]/b")).getText();
        } catch (Exception e) {

        }
    }





}
