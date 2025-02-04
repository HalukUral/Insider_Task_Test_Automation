package com.insiderUI.page;

import com.insiderUI.utilities.BrowserUtils;
import com.insiderUI.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenPositionpage {


    public OpenPositionpage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='select2-filter-by-location-container']")
    public WebElement filterLocation;
    @FindBy(xpath = "//li[text()='Istanbul, Turkey']")
    public WebElement selectIstanbulLocation;
    @FindBy(xpath = "//span[@title='Quality Assurance']")
    public WebElement selectedQAJob;
    @FindBy(xpath= "//*[@id='jobs-list']")
    public List<WebElement> joblist;
    @FindBy(xpath = "//a[contains(text(),'View Role')]")
    public WebElement viewRoleButton;

    @FindBy(xpath= "//*[@id='jobs-list']")
    public WebElement jobListBlock;

    public boolean isTitleIncludeQualityAssurance(WebElement item){
        String expect= "Quality Assurance";
        BrowserUtils browserUtils= new BrowserUtils();
        browserUtils.scrollToElement(item);
        return item.findElement(By.xpath("//p[contains(@class, 'position-title')]")).getText().contains(expect);
    }
    public boolean isLocationIstanbul(WebElement item){
        String expect= "Istanbul, Turkey";
        return item.findElement(By.xpath("//*[contains(@class, 'position-location')]")).getText().contains(expect);

    }
    public boolean isDepartmentIncludeQualityAssurance(WebElement item){
        String expect= "Quality Assurance";
        return item.findElement(By.xpath("//*[contains(@class, 'position-location')]")).getText().contains(expect);
    }
    public boolean isJobListPresence(){
        BrowserUtils browserUtils= new BrowserUtils();
        browserUtils.scrollToElement(jobListBlock);
        return joblist.isEmpty();

    }


}
