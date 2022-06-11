import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParabankTransferFund extends StartDriver {

    private final String inputAmountField = "1500";
    private final By findDropdownList = By.xpath("//*[@id=\"fromAccountId\"]");
    private final By findAmountField = By.xpath("//*[@id=\"amount\"]");
    private final By findTransferButton = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");

    public ParabankTransferFund(WebDriver startdriver) {
        super(startdriver);
    }

    /*
    public void navigate() {
        driver.navigate().to(urlOpenNewAccount);
    }
    */

    public void writeintoamountfield() {
        driver.findElement(findAmountField).sendKeys(inputAmountField);
    }

    public void selectfromfirstdropdownlist() {
        Select itemSelect = new Select(driver.findElement(findDropdownList));
        itemSelect.selectByIndex(1);
    }
    public void clickfirstdropdownlist() {
        driver.findElement(findDropdownList).click();
    }

    public void clickontransferbutton() {
        driver.findElement(findTransferButton).click();
    }
}
    /*
    public void checklink() {
        assertEquals(expectedLinkText, actualLinkText);
    }
    */