package com.insiderUI.page;

import org.openqa.selenium.support.PageFactory;
import com.insiderUI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void openHomePage() {
        Driver.getDriver().get ("https://useinsider.com/");
    }
    @FindBy (linkText = "Company")
    public WebElement companyMenu;
    @FindBy (linkText = "Careers")
    public WebElement careersSection;

}
