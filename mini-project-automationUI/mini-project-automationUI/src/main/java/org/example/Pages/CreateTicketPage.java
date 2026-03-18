package org.example.Pages;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTicketPage extends BasePage {
    public CreateTicketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn-create-ticket")
    private WebElement createTicketButton;

    @FindBy(id = "input-ticket-title")
    private WebElement ticketTittleTextField;

    @FindBy(id = "textarea-ticket-description")
    private WebElement ticketDescriptionTextField;

    @FindBy(id = "checkbox-ticket-public")
    private WebElement ticketPublicCheckbox;

    @FindBy(id = "btn-submit-ticket")
    private WebElement submitTicketButton;

    @FindBy (id = "btn-dashboard")
    private WebElement dashboardButton;

    @FindBy (xpath = "//input[@aria-invalid='true']")
    private WebElement errorAllertTicketTittleField;

    public void createTicket(String title, String description){
        waitForElementToBeVisible(createTicketButton);
        createTicketButton.click();

        waitForElementToBeVisible(ticketTittleTextField);
        ticketTittleTextField.sendKeys(title);

        ticketDescriptionTextField.sendKeys(description);
        ticketPublicCheckbox.click();
        submitTicketButton.click();
    }

    public boolean successCreateTicket(){
        try {
            waitForElementToBeVisible(dashboardButton);
            return dashboardButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean failedCreateTicket(){
        try {
            waitForElementToBeVisible(errorAllertTicketTittleField);
            return errorAllertTicketTittleField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}