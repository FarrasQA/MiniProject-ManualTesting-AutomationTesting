package Tests;

import core.BaseTest;
import core.DriverManager;
import org.example.Pages.CreateTicketPage;
import org.example.Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateTicketTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(CreateTicketTest.class);

    @Test(priority = 1, description = "TC-CREATETICKET-01")
    public void CreateTicketWithCompleteData() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        CreateTicketPage createTicketPage = new CreateTicketPage(DriverManager.getDriver());
        createTicketPage.createTicket(config.getProperty("title"), config.getProperty("description"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(createTicketPage.successCreateTicket(),
                "User Should see dashboard button on ticket issue page");

        softAssert.assertFalse(createTicketPage.failedCreateTicket(),
                "User should not see any error allert after successful create ticket");

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "TC-CREATETICKET-02")
    public void CreateTicketWithoutDescription() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        CreateTicketPage createTicketPage = new CreateTicketPage(DriverManager.getDriver());
        createTicketPage.createTicket(config.getProperty("title"), "");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(createTicketPage.successCreateTicket(),
                "User Should see dashboard button on ticket issue page");

        softAssert.assertFalse(createTicketPage.failedCreateTicket(),
                "User should not see any error allert after successful create ticket");

        softAssert.assertAll();
    }

    @Test(priority = 1, description = "TC-CREATETICKET-03")
    public void CreateTicketWithEmptyData() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        CreateTicketPage createTicketPage = new CreateTicketPage(DriverManager.getDriver());
        createTicketPage.createTicket("", "");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(createTicketPage.failedCreateTicket(),
                "User should see an error message when create ticket fails");

        softAssert.assertFalse(createTicketPage.successCreateTicket(),
                "Users should be informed that the data is mandatory");

        softAssert.assertAll();
    }

    @Test(priority = 1, description = "TC-CREATETICKET-04")
    public void CreateTicketWithoutTittle() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        CreateTicketPage createTicketPage = new CreateTicketPage(DriverManager.getDriver());
        createTicketPage.createTicket("", config.getProperty("description"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(createTicketPage.failedCreateTicket(),
                "User should see an error message when create ticket fails");

        softAssert.assertFalse(createTicketPage.successCreateTicket(),
                "Users should be informed that the data is mandatory");

        softAssert.assertAll();
    }
}
