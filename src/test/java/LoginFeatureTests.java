import Pages.AccountSummaryPage;
import Pages.HomePage;
import Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginFeatureTests {

    ChromeOptions chromeOptions = new ChromeOptions();
    private HomePage homePage;
    private LogInPage logInPage;
    private AccountSummaryPage accountSummaryPage;
    private WebDriver driver;

    public static String expectedHeaderString = "Log in to ZeroBank";


    @BeforeClass
    public void beforeClass(){
        chromeOptions.addArguments("--allow-insecure-localhost");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(chromeOptions);
        homePage = new HomePage(driver);
        logInPage = new LogInPage(driver);
        accountSummaryPage = new AccountSummaryPage(driver);

        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @Test
    public void invalidLoginTest(){
    logInPage.clickLoginButton();
    String expectedMessage = "Login and/or password are wrong.";

    Assert.assertEquals(logInPage.getInvalidCredentialsText(), expectedMessage);
    }


    @Test
    public void successfulLoginTest(){

        logInPage.enterUsername();
        logInPage.enterPassword();
        logInPage.clickLoginButton();

        String expectedPageUrl = "account-summary.html";
        String currentUrl = driver.getCurrentUrl();
        boolean isCorrectUrl = currentUrl.contains(expectedPageUrl);

        Assert.assertTrue(isCorrectUrl);


    }

    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();

    }
}
