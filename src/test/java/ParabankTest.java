// Main: Driver konfigurálása, tesztek futtatása
// Lokális futtatásnál a headless-t ki kell kapcsolni, viszont a GitHub-os futtatás csak bekapcsolt headless-szel működik
// Jelenleg csak a lokális futtatás működik

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ParabankTest {
    WebDriver driver;
    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        // options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    @Epic("Parabank")
    @Story("Login to Parabank")
    @Description("Navigation to the login page and login to the site")
    @Severity(SeverityLevel.CRITICAL)
    public void loginToParabank() throws InterruptedException {
        ParabankLoginTest parabankLoginTest = (ParabankLoginTest) SiteFactory.Create("ParabankLoginTest", driver);
        parabankLoginTest.navigate();
        Thread.sleep(5000);
        parabankLoginTest.writeintouserfield();
        parabankLoginTest.writeintopasswordfield();
        parabankLoginTest.pressloginbutton();
        Thread.sleep(5000);
        // parabankLoginTest.checkloginresult();
        }

    @Test
    @Epic("Parabank")
    @Story("Total Amount at Parabank")
    @Description("Navigation to the overview page and check total amount")
    @Severity(SeverityLevel.CRITICAL)
    public void totalAmountInParabank() throws InterruptedException {
        loginToParabank();
        ParabankTotalAmountTest parabankTotalAmountTest = (ParabankTotalAmountTest) SiteFactory.Create("ParabankTotalAmountTest", driver);
        parabankTotalAmountTest.checkamountresult();
    }

    @Test
    @Epic("Parabank")
    @Story("Open New Account at Parabank")
    @Description("Navigation to the overview page and create a new account")
    @Severity(SeverityLevel.CRITICAL)
    public void openNewAccountInParabank() throws InterruptedException {
        loginToParabank();
        ParabankOpenNewAccount parabankOpenNewAccount = (ParabankOpenNewAccount) SiteFactory.Create("ParabankOpenNewAccount", driver);
        parabankOpenNewAccount.clicklink();
        parabankOpenNewAccount.checklink();
        parabankOpenNewAccount.clickdropdownlist();
        parabankOpenNewAccount.clickonopennewaccountbutton();
    }


    @AfterEach
    @Epic("Parabank")
    @Story("Make Screenshot")
    @Description("Make Screenshot After Each Test")
    @Severity(SeverityLevel.CRITICAL)
    public void makeScreenshot() {
        Allure.addAttachment("Screenshot of Tested Page", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}