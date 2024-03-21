package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

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
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement searchBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
    public WebElement userNameInTable;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[1]")
    WebElement deleteIcon;
    @FindBy(xpath= "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement deleteBtn;

    public int getRecords(){
        String txt = recordsCount.getText();
        String replacedtxt = txt.replaceAll("[^\\d]", "");
        int recordno = Integer.parseInt(replacedtxt);
        return recordno;
    }
    public void searchUser(String usrname){
        searchField.sendKeys(usrname);
        searchBtn.click();
    }
    public void deleteUser() throws InterruptedException {
        deleteIcon.click();
        Thread.sleep(3000);
        deleteBtn.click();
    }

}
