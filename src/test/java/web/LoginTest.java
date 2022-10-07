package web;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.FileReader;

import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void userPersonalInfoTest() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String testDataPath = FileReader.readProperties("test_data_path");
        Map<String, String> testData = FileReader.readJson(testDataPath);

        loginPage.acceptCookiesIfBannerAppears();
        loginPage.login(testData.get("login"), testData.get("password"));
        myAccountPage.openUserAccount();
        Assert.assertEquals(testData.get("first_name"), myAccountPage.getFirstNameInfo());
        Assert.assertEquals(testData.get("last_name"), myAccountPage.getLastNameInfo());
        Assert.assertEquals(testData.get("phone_code"), myAccountPage.getPhoneCodeInfo());
        Assert.assertEquals(testData.get("phone_number"), myAccountPage.getPhoneNumberInputInfo());
    }
}
