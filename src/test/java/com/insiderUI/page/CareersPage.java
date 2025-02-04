package com.insiderUI.page;

import com.insiderUI.utilities.BrowserUtils;
import com.insiderUI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersPage {

    public CareersPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "career-find-our-calling")
    public WebElement teams;
    @FindBy (id="career-our-location")
    public WebElement location;
    @FindBy (xpath="//h2[text()='Life at Insider']")
    public WebElement lifeAtInsider;
    @FindBy (xpath = "//*[contains(@class, 'job-title')]/a/h3")
    public  List<WebElement>jobTitle;



public boolean checkTeamsBlockContent() {

    String[] departments = {"Customer Success", "Sales", "Product & Engineering", "Finance & Business Support", "Marketing",
    "CEO's Executive Office", "Purchasing & Operations", "People and Culture", "Business Intelligence", "Security Engineering",
            "Partnership", "Quality Assurance", "Mobile Business","Partner Support Development","Product Design"};

  return jobTitle.size()== departments.length ;

}
public boolean islifeAtInsiderOpen(){
    BrowserUtils browserUtils= new BrowserUtils();
    browserUtils.scrollToElement(lifeAtInsider);
    return lifeAtInsider.isDisplayed();
}
public boolean isLocationOpen(){
        BrowserUtils browserUtils= new BrowserUtils();
        browserUtils.scrollToElement(location);
        return location.isDisplayed();
    }
public boolean istTeamsOpen(){
        BrowserUtils browserUtils= new BrowserUtils();
        browserUtils.scrollToElement(teams);
        return teams.isDisplayed() & checkTeamsBlockContent();
    }

}