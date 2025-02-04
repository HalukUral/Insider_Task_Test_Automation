package com.insiderUI.page;

import com.insiderUI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QaJobPage {
    public QaJobPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void openQaJobPage() {
        Driver.getDriver().get ("https://useinsider.com/careers/quality-assurance/");
    }
    @FindBy(linkText = "See all QA jobs")
    public WebElement allQaJobButton;

}
