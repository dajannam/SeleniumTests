package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransferFundsPages extends BasePage{


public  TransferFundsPages(WebDriver driver){
    super(driver);

}

    @FindBy(id = "tf_toAccountId")
    WebElement toAccountDropDown;

    @FindBy(css = "select[id=\"tf_toAccountId\"]>option[value=\"3\"]")
            WebElement toAccountDropdownOptionSecondSaving;

    @FindBy(id = "tf_amount")
    WebElement amountInoutField;

    @FindBy(id = "tf_description")
    WebElement descriptionInputField;

    @FindBy(id = "btn_submit")
    WebElement buttonSubmit;

    @FindBy(css = "/bank/transfer-funds.html")
    WebElement successfulMessage;

    @FindBy(css = "div[class=\\\"row\\\"]>div[class=\\\"span3\\\"]")
    List<WebElement> results;


    public void clickToAccountDropDown(){
        toAccountDropDown.click();
}

  public void clickToAccountOption(){
        toAccountDropdownOptionSecondSaving.click();
  }
  public void enterAmount(){
        amountInoutField.sendKeys("300");

  }

  public void enterDescription(){
      clearAndSendKeys(descriptionInputField, "Transfet money");
  }

  public void clickSubmitButton(){
        waitForElementToBeClickAndClick(buttonSubmit);

  }
  public String getSuccessfulMessageText(){
        return successfulMessage.getText();
  }

  public String fromAccountText(){
        return results.get(0).getText();
  }
  public String toAccountText(){
        return results.get(1).getText();
  }

  public String amountText(){
        return results.get(2).getText();
  }

}

