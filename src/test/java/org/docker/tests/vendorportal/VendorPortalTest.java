package org.docker.tests.vendorportal;

import org.docker.pages.vendorportal.DashboardPage;
import org.docker.pages.vendorportal.LoginPage;
import org.docker.tests.AbstractTest;
import org.docker.tests.vendorportal.models.VendorModel;
import org.docker.util.Config;
import org.docker.util.Constants;
import org.docker.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorModel testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setUp( String testDataPath ) {
      this.loginPage = new LoginPage(driver);
      this.dashboardPage = new DashboardPage(driver);
      this.testData = JsonUtil.getTestData(testDataPath, VendorModel.class);
    }


    @Test
    public void loginTest() {
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginPage.isLoaded());
        loginPage.login(testData.username(), testData.password());
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() {
        Assert.assertTrue(dashboardPage.isLoaded());

        // finance metrics
        Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());

        // order history search
        dashboardPage.searchOrderHistoryBy(testData.searchKeyword());
        Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultsCount());
    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest() {
        dashboardPage.logout();
        Assert.assertTrue(loginPage.isLoaded());
    }

}
