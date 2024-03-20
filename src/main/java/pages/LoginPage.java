package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends pagebase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "username")
    WebElement Username;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    WebElement loginBtn;
    public void userlogin(String username, String password) {
        Username.sendKeys(username);
        Password.sendKeys(password);
        loginBtn.click();
    }
}
