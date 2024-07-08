package org.docker.pages.flightreservation;

import org.docker.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id = "go-to-flights-search")
    private WebElement flightsSearchButton;
    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstNameElement;

    public RegistrationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLoaded() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsSearchButton));
        return this.flightsSearchButton.isDisplayed();
    }

    public String getFirstName() {
        return this.firstNameElement.getText();
    }

    public void goToFlightsSearch() {
        this.flightsSearchButton.click();
    }
}
