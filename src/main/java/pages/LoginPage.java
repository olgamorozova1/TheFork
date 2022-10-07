package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static By loginButton = By.xpath("//button/span[contains(text(),'Log in')]");
    public static By emailInput = By.xpath("//input[@id='identification_email']");
    public static By continueSubmitEmailButton = By.xpath("//button[@data-testid='checkout-submit-email']");
    public static By continueSubmitPasswordButton = By.xpath("//button[@data-testid='submit-password']");
    public static By passwordInput = By.xpath("//input[@name='password']");
    public static By acceptCookiesButton = By.xpath("//button[@id='_evidon-accept-button']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        click(loginButton);
        fillInput(emailInput, email);
        click(continueSubmitEmailButton);
        fillInput(passwordInput, password);
        click(continueSubmitPasswordButton);
    }

    public void acceptCookiesIfBannerAppears() {
        if (isElementExist(acceptCookiesButton)) {
            click(acceptCookiesButton);
        }
    }
}
