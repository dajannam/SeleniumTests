import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LogInPage;
import Pages.TransferFundsPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransferFundsFeatureTest  {

    ChromeOptions chromeOptions = new ChromeOptions();
    private HomePage homePage;
    private LogInPage logInPage;
    private WebDriver driver;
    private AccountSummaryPage accountSummaryPage;
    private TransferFundsPages transferFundsPages;

    @BeforeClass
    public void beforeClass(){
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);
        transferFundsPages = new TransferFundsPages(driver);

        driver.get("http://zero.webappsecurity.com/login.html");

        logInPage.enterUsername();
        logInPage.enterPassword();
        logInPage.clickLoginButton();

        accountSummaryPage.clickTransferFundsButton();

    }
    @Test
    public void transferFundsTest() throws InterruptedException{

        transferFundsPages = new TransferFundsPages(driver);
     transferFundsPages.clickToAccountDropDown();
     transferFundsPages.clickToAccountOption();
     transferFundsPages.enterAmount();
     transferFundsPages.enterDescription();
     transferFundsPages.clickSubmitButton();
     transferFundsPages.clickSubmitButton();

     String expectedToAccount = "Savings";
     String expectedAmount = "$ 300";
     String expectedSuccessMessage = "You successfully submitted your transaction.";

        Assert.assertEquals(transferFundsPages.getSuccessfulMessageText(), expectedSuccessMessage);
        Assert.assertEquals(transferFundsPages.fromAccountText(), expectedToAccount);
        Assert.assertEquals(transferFundsPages.toAccountText(), expectedToAccount);
        Assert.assertEquals(transferFundsPages.amountText(), expectedAmount);


    }

    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();
    }

}
