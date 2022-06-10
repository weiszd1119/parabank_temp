//Class: oldal létrehozása aszerint, hogy melyik oldalt akarjuk tesztelni

import org.openqa.selenium.WebDriver;

public class SiteFactory {
    public static StartDriver Create(String name, WebDriver driver)
    {
        switch (name)
        {
            case "ParabankLoginTest":
                return new ParabankLoginTest(driver);
            case "ParabankTotalAmountTest":
                return new ParabankTotalAmountTest(driver);
            case "ParabankOpenNewAccount":
                return new ParabankOpenNewAccount(driver);
            default:
                return null;
        }
    }
}
