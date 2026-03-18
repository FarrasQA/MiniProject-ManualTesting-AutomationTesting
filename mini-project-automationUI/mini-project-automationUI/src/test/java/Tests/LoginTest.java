package Tests;

import core.BaseTest;
import core.DriverManager;
import core.TestUtils;
import org.example.Pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @DataProvider(name = "loginCredentials", parallel = true)
    public Object[][] loginCredentials() {
        return TestUtils.getTestData("src/test/resources/data/login-data-test.xlsx", "login-tests");
    }

    @Test(priority = 1, dataProvider = "loginCredentials", description = "Data-driven login test")
    public void testDataDriven(String username, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(username, password);


        SoftAssert softAssert = new SoftAssert();


        if (expectedResult.equalsIgnoreCase("success")) {
            softAssert.assertTrue(loginPage.isUserLoggedInSuccessfully(),
                    "User should see navbar button on active issue page");
        } else {
            softAssert.assertTrue(loginPage.isErrorMessageDisplayed(),
                    "User with username '" + username + "' should see an error message");


            softAssert.assertFalse(loginPage.isUserLoggedInSuccessfully(),
                    "User should not be able to access the Products page with invalid credentials");
        }

        softAssert.assertAll();
    }


    @Test(priority = 1, description = "TC-LOGIN-01 (Login with valid credentials)")
    public void testLogin() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(loginPage.isUserLoggedInSuccessfully(),
                "User should see navbar button on active issue page");


        softAssert.assertFalse(loginPage.isErrorMessageDisplayed(),
                "User should not see any error message after successful login");

        softAssert.assertAll();
    }

    @Test(priority = 1, description = "TC-LOGIN-02 (Login with empty credentials)")
    public void testLoginEmptyCredentials() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login("", "");


        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "User should see an error message when login fails");


        softAssert.assertFalse(loginPage.isUserLoggedInSuccessfully(),
                "User should not be able to see navbar button on active issue page with invalid credentials");

        softAssert.assertAll();
    }

    @Test(priority = 1, description = "TC-LOGIN-03 (Login with wrong username)")
    public void testLoginWrongUsername() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("wrongUser"), config.getProperty("password"));


        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "User should see an error message when login fails");


        softAssert.assertFalse(loginPage.isUserLoggedInSuccessfully(),
                "User should not be able to see navbar button on active issue page with invalid credentials");

        softAssert.assertAll();
    }

    @Test(priority = 1, description = "TC-LOGIN-04 (Login with wrong password)")
    public void testLoginWrongPassword() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("wrongPassword"));


        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(loginPage.isErrorMessageDisplayed(),
                "User should see an error message when login fails");


        softAssert.assertFalse(loginPage.isUserLoggedInSuccessfully(),
                "User should not be able to see navbar button on active issue page with invalid credentials");

        softAssert.assertAll();
    }
}
