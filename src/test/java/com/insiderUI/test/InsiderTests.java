package com.insiderUI.test;

import com.insiderUI.page.CareersPage;
import com.insiderUI.page.HomePage;
import com.insiderUI.page.OpenPositionpage;
import com.insiderUI.page.QaJobPage;
import com.insiderUI.utilities.BrowserUtils;
import com.insiderUI.utilities.Driver;
import com.insiderUI.utilities.ScreenshotUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class InsiderTests {

    @Test(priority = 1, description = "Verify Insider Home Page & 'Careers' Page from the 'Company' Menu")
    public void check_homepage() {
        HomePage homePage = new HomePage();
        CareersPage careersPage = new CareersPage();
        homePage.openHomePage();

        try {
            Assert.assertTrue(Driver.getDriver().getTitle().contains("Insider"));
            homePage.companyMenu.click();
            homePage.careersSection.click();
            Assert.assertTrue(careersPage.islifeAtInsiderOpen());
            Assert.assertTrue(careersPage.isLocationOpen());
            Assert.assertTrue(careersPage.istTeamsOpen());
        } catch (AssertionError e) {
            ScreenshotUtil.takeScreenshot(Driver.getDriver(), "check_homepage");
            throw e;
        }

    }

    @Test(priority = 2, description = "Check QA job filtering by location and department, verify job details and application page.")
    public void qaJobFilteringAndApply() {
        QaJobPage qaJobPage = new QaJobPage();
        OpenPositionpage openPositionpage = new OpenPositionpage();
        qaJobPage.openQaJobPage();

        qaJobPage.allQaJobButton.click();
        BrowserUtils.waitForInvisibilityOf(openPositionpage.selectedQAJob, "Quality Assurance");
        openPositionpage.filterLocation.click();
        openPositionpage.selectIstanbulLocation.click();
        BrowserUtils.sleep(5);
        try {
            Assert.assertFalse(openPositionpage.isJobListPresence());
        } catch (AssertionError e) {
            ScreenshotUtil.takeScreenshot(Driver.getDriver(), "qaJobFilteringAndApply");
            throw e;
        }
    }
    @Test(dependsOnMethods = { "qaJobFilteringAndApply" }, description = "Verify Job Details.")
        public void verifyJobDetails() {
        OpenPositionpage openPositionpage = new OpenPositionpage();

        for (WebElement item : openPositionpage.joblist) {
            try {
                Assert.assertTrue(openPositionpage.isTitleIncludeQualityAssurance(item));
                Assert.assertTrue(openPositionpage.isLocationIstanbul(item));
                Assert.assertTrue(openPositionpage.isDepartmentIncludeQualityAssurance(item));
            } catch (AssertionError e) {
                ScreenshotUtil.takeScreenshot(Driver.getDriver(), "verifyJobDetails");
                throw e;
            }

        }
    }

    @Test(priority = 3, description = "Verify 'View Role' Button Redirects to Lever Application Form")
    public void verifyApplicationPage() {

        OpenPositionpage openPositionpage = new OpenPositionpage();
        String currentUrl;
        openPositionpage.viewRoleButton.click();
        BrowserUtils.sleep(4);
        BrowserUtils.switchWindowAndVerify(Driver.getDriver(), "lever.co", "Senior Software Quality Assurance Engineer");

    }

    @AfterTest
    public void closeDriver() {
        Driver.closeDriver();
    }

}


