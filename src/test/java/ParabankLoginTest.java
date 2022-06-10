import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParabankLoginTest extends StartDriver {
    private final String urlLogin = "https://parabank.parasoft.com/parabank/index.htm";
    private final String actualUrlLogin = driver.getCurrentUrl();
    private final String expectedUrlLogin = "https://parabank.parasoft.com/parabank/overview.htm";
    private final String inputLoginUserName = "weiszd1119";
    private final String inputLoginPassword = "TEmp1119";
    private final By findLoginUserName = By.name("username");
    private final By findLoginPassword = By.name("password");
    private final By findLoginButton = By.xpath("/html/body/div[1]/div[3]/div[1]/div/form/div[3]/input");



    //Konstruktor
    public ParabankLoginTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void navigate() {
        driver.navigate().to(urlLogin);
    }

    public void writeintouserfield() {
        driver.findElement(findLoginUserName).sendKeys(inputLoginUserName);
    }

    public void writeintopasswordfield() {
        driver.findElement(findLoginPassword).sendKeys(inputLoginPassword);
    }

    public void pressloginbutton() {
        driver.findElement(findLoginButton).click();
    }
    public void checkloginresult() {
        assertEquals(expectedUrlLogin, actualUrlLogin);
    }
}