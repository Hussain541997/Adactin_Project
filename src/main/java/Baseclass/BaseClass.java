package Baseclass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // Launch browser with implicit and explicit wait setup
    public static WebDriver launchBrowser(String browserType) {
        try {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid browser type: " + browserType);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        } catch (Exception e) {
            System.err.println("Browser launch failed: " + e.getMessage());
            throw e;
        }
        return driver;
    }

    public static void openUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            System.err.println("Failed to open URL: " + e.getMessage());
            throw e;
        }
    }

    public void enterText(String xpath, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.err.println("Error entering text: " + e.getMessage());
            throw e;
        }
    }

    public void clickElement(String xpath) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            element.click();
        } catch (Exception e) {
            System.err.println("Error clicking element: " + e.getMessage());
            throw e;
        }
    }

    public void selectDropdown(String xpath, String type, String value) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Select select = new Select(element);

            switch (type.toLowerCase()) {
                case "visibletext":
                    select.selectByVisibleText(value);
                    break;
                case "value":
                    select.selectByValue(value);
                    break;
                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid dropdown type: " + type);
            }
        } catch (Exception e) {
            System.err.println("Dropdown selection failed: " + e.getMessage());
            throw e;
        }
    }

    public void mouseHover(String xpath) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            System.err.println("Mouse hover failed: " + e.getMessage());
        }
    }

    public void dragAndDrop(String sourceXpath, String targetXpath) {
        try {
            WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sourceXpath)));
            WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(targetXpath)));
            new Actions(driver).dragAndDrop(source, target).perform();
        } catch (Exception e) {
            System.err.println("Drag and drop failed: " + e.getMessage());
        }
    }

    public void switchToFrame(String type, String value) {
        try {
            switch (type.toLowerCase()) {
                case "index":
                    driver.switchTo().frame(Integer.parseInt(value));
                    break;
                case "name":
                    driver.switchTo().frame(value);
                    break;
                case "xpath":
                    WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                    driver.switchTo().frame(frame);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid frame switch type: " + type);
            }
        } catch (Exception e) {
            System.err.println("Frame switch failed: " + e.getMessage());
        }
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void switchToNewWindow() {
        try {
            String parent = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if (!handle.equals(parent)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Window switching failed: " + e.getMessage());
        }
    }

    public void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String dest = "src/test/screenshots/" + fileName + ".png";
            FileUtils.copyFile(src, new File(dest));
            System.out.println("Screenshot saved: " + dest);
        } catch (IOException e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }

    public void jsClick(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.err.println("JS click failed: " + e.getMessage());
        }
    }

    public void scrollToElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.err.println("Scroll to element failed: " + e.getMessage());
        }
    }

    public void waitForVisibility(String xpath, int seconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            customWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            System.err.println("Wait for visibility failed: " + e.getMessage());
        }
    }

    public String getText(String xpath) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.err.println("Get text failed: " + e.getMessage());
            return null;
        }
    }

    public String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.err.println("Get title failed: " + e.getMessage());
            return null;
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
    public void handleAlert(boolean acceptAlert, String textToSend) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();

            if (textToSend != null && !textToSend.isEmpty()) {
                alert.sendKeys(textToSend);
                alert.accept();  // Assuming you always want to accept after sending text
            } else {
                if (acceptAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
            }
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present: " + e.getMessage());
        } catch (UnhandledAlertException e) {
            System.out.println("Unhandled alert issue: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception while handling alert: " + e.getMessage());
        }
    }
}
