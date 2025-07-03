import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Simple Selenium Java test, proof of concept
public class App {
    public static void main(String[] args) throws Exception {
        String expected_page_title = "TMX TSX | TSXV - Toronto Stock Exchange and TSX Venture Exchange";
        String actual_page_title;
        String baseURL = "";

        System.out.println("Get a TSX Quote test");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        excel_utils data_sheet_in = new excel_utils();
        data_sheet_in.setExcelFileSheet("C:\\temp\\test-parameters.xlsx", "test_parameters", "in");
        baseURL = data_sheet_in.getCell(1, 1);
        expected_page_title = data_sheet_in.getCell(2, 1);

        WebDriver driver = new ChromeDriver();
        driver.get(baseURL);
        actual_page_title = driver.getTitle();

        check_page_title(expected_page_title, actual_page_title);
        WebElement input_symbol = driver.findElement(By.id("global-search-input"));
        input_symbol.sendKeys("BMO", Keys.RETURN);

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