package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferFundsPages extends BasePage{


public  TransferFundsPages(WebDriver driver){
    super(driver);

}

    @FindBy(id = "tf_toAccountId")
    WebElement toAccountDropDown;

    @FindBy(css = "select[id=\"tf_toAccountId\"]>option[value=\"3\"]")
            WebElement toAccountDropdownOptionSecondSaving;


    public void clickToAccountDropDown(){
    toAccountDropDown.click();
}

  public void clickToAccountOption(){
        toAccountDropdownOptionSecondSaving.click();
  }
}

