package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }
    public void moveToElement(WebElement element){
        actions.moveToElement(element);
        actions.perform();

    }

    public void clearAndSendKeys(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        moveToElement(element);
        element.clear();
        element.sendKeys();

    }
    public void waitForElementToBeClickAndClick(WebElement element){
        moveToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void getElementText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.getText();
    }
}
