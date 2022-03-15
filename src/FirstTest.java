import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import static org.junit.Assert.*;

public class FirstTest {

    private AppiumDriver driver;
    private final String searchFiledXpathLocator =
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView";
    private final String expectedTextSearchField = "Search Wikipedia";

    private static final int DEFAULT_TIMEOUT = 5;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\LearnQA\\avt-mob-50-java\\apks\\org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void textInSearchFieldMainActivityTest() {
        WebElement element_to_init_search = waitForElementPresent(
                By.xpath(searchFiledXpathLocator),
                "Cannot find search input");
        assertElementHasText(element_to_init_search, expectedTextSearchField, "Text not equals in element_to_init_search");
    }

    private void assertElementHasText(WebElement element, String expectedText, String errorMessage) {
        assertEquals(errorMessage, expectedText, element.getAttribute("text"));
    }

    private WebElement waitForElementPresent(By by, String errorMessage, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        wait.withMessage(errorMessage + '\n');
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitForElementPresent(By by, String errorMessage) {
        return waitForElementPresent(by, errorMessage, DEFAULT_TIMEOUT);
    }

    private boolean waitForElementNotPresent(By by, String errorMessage, long timeoutInSecond) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        wait.withMessage(errorMessage + '\n');
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private boolean waitForElementNotPresent(By by, String errorMessage) {
        return waitForElementNotPresent(by, errorMessage, DEFAULT_TIMEOUT);
    }

    private WebElement waitForElementAndClick(By by, String errorMessage, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSecond);
        element.click();
        return element;
    }

    private WebElement waitForElementAndClick(By by, String errorMessage) {
        return waitForElementAndClick(by, errorMessage, DEFAULT_TIMEOUT);
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String errorMessage, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSecond);
        element.sendKeys(value);
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String errorMessage) {
        return waitForElementAndSendKeys(by, value, errorMessage, DEFAULT_TIMEOUT);
    }

    private WebElement waitForElementAndClear(By by, String errorMessage, long timeoutInSecond) {
        WebElement element = waitForElementPresent(by, errorMessage, timeoutInSecond);
        element.clear();
        return element;
    }

    private WebElement waitForElementAndClear(By by, String errorMessage) {
        return waitForElementAndClear(by, errorMessage, DEFAULT_TIMEOUT);
    }
}
