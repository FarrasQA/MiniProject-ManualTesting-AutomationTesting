package org.example.Pages;

import org.example.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id="input-email-login")
    private WebElement usernameTextField;

    @FindBy (id="input-password-login")
    private WebElement passwordTextField;

    @FindBy (id = "btn-login")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@role='status']//div[@data-status='error']//div[contains(text(),'Invalid Credentials')]")
    private WebElement errorNotification;

    @FindBy(id = "btn-open-navbar")
    private WebElement navbarButton;

    public void login(String username, String password) {
        waitForElementToBeVisible(usernameTextField);
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public boolean isUserLoggedInSuccessfully() {
        try {
            waitForElementToBeVisible(navbarButton);
            return navbarButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(errorNotification));
            return errorNotification.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
