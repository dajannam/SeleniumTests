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

    public static final WebDriver driver = new ChromeDriver();
    static ChromeOptions chromeOptions = new ChromeOptions();
    static HomePage homePage = new HomePage(driver);
    static LogInPage logInPage = new LogInPage(driver);
    static AccountSummaryPage accountSummaryPage = new AccountSummaryPage(driver);
    public static String expectedHeaderString = "Log in to ZeroBank";


    @BeforeClass
    public void beforeClass(){
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
        driver.get("http://zero.webappsecurity.com/index.html");
        homePage.clickElement();

        boolean isHeaderDisplayed = logInPage.isHeaderElementDisplayed();
        String actualHeaderText = logInPage.getHeaderText();

        Assert.assertTrue(isHeaderDisplayed);
        Assert.assertEquals(actualHeaderText, expectedHeaderString);


        logInPage.enterUsername();
        logInPage.enterPassword();
        logInPage.clickLoginButton();

        String currentUrl = driver.getCurrentUrl();
        accountSummaryPage.getText();


    }

    @AfterClass
    public void afterClass(){
        driver.close();
        driver.quit();

    }
}
