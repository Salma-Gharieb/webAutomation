package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminPage extends pagebase{
    public adminPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    public WebElement adminTab;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    public WebElement recordsCount;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    public WebElement addRecordBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement searchField;
//    @FindBy(className = "oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space")
//    WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]")
    WebElement deleteIcon;
//    @FindBy(className = "oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin")
//    WebElement deleteBtn;

    public String getRecords(){
        String txt = recordsCount.getText();
        String number = txt.replaceAll("[^\\d]", "");
        return number;
    }

}
