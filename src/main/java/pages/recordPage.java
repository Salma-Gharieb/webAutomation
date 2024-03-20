package pages;

import io.cucumber.messages.types.Hook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class recordPage extends pagebase{
    public recordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")
    WebElement userRoleDropDown;
    @FindBy(xpath = "//div[contains(@class, 'oxd-select-text') and contains(@class, 'oxd-select-text--active')][2]")
    WebElement statusDropDown;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active'][2]")
    WebElement userName;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active'][3]")
    WebElement userPassword;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active'][4]")
    WebElement confirmPassword;
//    @FindBy(className = "oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space")
//    WebElement saveBtn;

    public void addNewUser(String role, String status,String empName,String usrName,String usrPass){

//        userRoleDropDown.click();
        recordPage obj = new recordPage(driver);
        String script = "arguments[0].value = 'Admin';";
        ((JavascriptExecutor) driver).executeScript(script, userRoleDropDown);
        statusDropDown.sendKeys(status);
        employeeName.sendKeys(empName);
        userName.sendKeys(usrName);
        userPassword.sendKeys(usrPass);
        confirmPassword.sendKeys(usrPass);
//        saveBtn.click();
    }
}
