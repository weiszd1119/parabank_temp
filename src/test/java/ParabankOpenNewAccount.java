import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParabankOpenNewAccount extends StartDriver {

    private final By findOpenNewAccountLink = By.xpath("//a[@href='/parabank/openaccount.htm']");

    private final By findDropdownList = (By) driver.findElement(By.xpath("//*[@id=\"type\"]"));
    private final By findOpenNewAccountButton = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input");
    private final String actualLinkText = driver.getCurrentUrl();
    private final String expectedLinkText = "https://parabank.parasoft.com/parabank/openaccount.htm";
    public ParabankOpenNewAccount(WebDriver startdriver) {
        super(startdriver);
    }

    public void clicklink() {
        driver.findElement(findOpenNewAccountLink).click();
    }

    public void clickdropdownlist() {
        driver.findElement(findDropdownList).click();
    }

    public void selectfromdropdownlist() {
        Select itemSelect = new Select((WebElement) findDropdownList);
        itemSelect.selectByValue("SAVINGS");
    }

    public void clickonopennewaccountbutton() {
        driver.findElement(findOpenNewAccountButton).click();
    }
    public void checklink() {
        assertEquals(expectedLinkText, actualLinkText);
    }
}