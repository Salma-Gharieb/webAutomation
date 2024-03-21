package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.adminPage;
import pages.recordPage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class End2EndTest {
    LoginPage loginObj;
    adminPage adminObj;
    recordPage recordObj;
    String generatedUsrName;
    int recordno;
    int updatedRecordsValue;
    @Given("User is on login screen")
    public void userIsOnLoginScreen() {
        loginObj = new LoginPage(Hooks.driver);
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                (Hooks.driver).getCurrentUrl());
    }
    @When("he inserts his credentials {string} and {string} and login")
    public void heInsertsHisCredentialsAndLogin(String username, String password) {
        loginObj.userlogin(username, password);
    }
    @And("navigates to dashboard")
    public void navigatesToDashboard() {
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",
                Hooks.driver.getCurrentUrl());
    }
    @And("navigates to Admin page and check the records")
    public void navigatesToAdminPageAndCheckTheRecords() {
        adminObj = new adminPage(Hooks.driver);
        adminObj.adminTab.click();
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("admin"));
        recordno = adminObj.getRecords();
    }
    @And("navigate to add role page and insert user info {string},{string},{string}")
    public void navigateToAddRolePageAndInsertUserInfo(String empName, String usrName, String usrPass) throws InterruptedException {
        recordObj = new recordPage(Hooks.driver);
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        generatedUsrName = usrName+randomNumber;
        adminObj.addRecordBtn.click();
        Hooks.driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        recordObj.addNewUser(Hooks.driver,empName, generatedUsrName , usrPass);
    }
    @Then("verify that number of records increased by {int}")
    public void verifyThatNumberOfRecordsIncreasedBy(int arg0) {
        updatedRecordsValue = adminObj.getRecords();
        Assert.assertEquals(updatedRecordsValue, recordno + 1);
    }
    @And("search for newly added user")
    public void searchForNewlyAddedUser() {
        adminObj.searchUser(generatedUsrName);
        Assert.assertEquals(adminObj.userNameInTable.getText(), generatedUsrName);
    }
    @Then("delete the new user")
    public void deleteTheNewUser() throws InterruptedException {
        Thread.sleep(3000);
        adminObj.deleteUser();
    }
    @And("verify that number of records decreased by {int}")
    public void verifyThatNumberOfRecordsDecreasedBy(int arg0) {
        adminObj.adminTab.click();
        updatedRecordsValue = adminObj.getRecords();
        Assert.assertEquals(updatedRecordsValue, recordno);
    }

}
