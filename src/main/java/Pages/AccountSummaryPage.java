package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummaryPage extends BasePage {

    public AccountSummaryPage(WebDriver driver){
        super(driver);
    }

@FindBy(id = "transfer_funds_tab")
    private WebElement transferFunds;

    public void clickTransferFundsButton(){
        transferFunds.click();
    }
}
