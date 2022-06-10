import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParabankTotalAmountTest extends StartDriver {

    private final String actualTotalAmountText = driver.findElement(By.className("ng-binding")).getText();

    private final String expectedTotalAmountText = "-$149484.50";
    public ParabankTotalAmountTest(WebDriver startdriver) {
        super(startdriver);
    }

    public void checkamountresult() {
        assertEquals(expectedTotalAmountText, actualTotalAmountText );
    }
}

