import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import java.time.*;

// Simple Selenium Java test, proof of concept
public class App {
    public static void main(String[] args) throws Exception {
        String expected_page_title = "TMX Money | TSX Today | Canadian Stock Market";
        String actual_page_title;
        String baseURL = "";
        String symbol = "";

        System.out.println("Get a TSX Quote test");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        excel_utils data_sheet_in = new excel_utils();
        data_sheet_in.setExcelFileSheet("C:\\temp\\test-parameters.xlsx", "test_parameters", "in");
        baseURL = data_sheet_in.getCell(1, 1);
        expected_page_title = data_sheet_in.getCell(2, 1);

        excel_utils test_symbols = new excel_utils();
        test_symbols.setExcelFileSheet("C:\\temp\\test-parameters.xlsx", "symbols", "in");
        symbol = test_symbols.getCell(1, 0);

        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();
        actual_page_title = driver.getTitle();

        check_page_title(expected_page_title, actual_page_title);
        WebElement input_symbol = driver.findElement(By.id("global-search-input"));
        try {
            input_symbol.sendKeys(symbol, Keys.RETURN);
        } catch (StaleElementReferenceException e) {
            input_symbol = driver.findElement(By.id("global-search-input"));
        }
        input_symbol.sendKeys(symbol, Keys.RETURN);

        driver.close();
        driver.quit();
    }

    public static void check_page_title(String expected_page_title, String actual_page_title) {
        if (actual_page_title.equals(expected_page_title)) {
            System.out.println("Page title matches the expected page title");
        } else {
            System.out.println("Page title does not match the expected_page_title");
        }
    }
}