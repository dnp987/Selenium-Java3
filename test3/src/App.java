import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        String test_sight = "https://www.tsx.com";
        String expected_page_title = "TMX TSX | TSXV - Toronto Stock Exchange and TSX Venture Exchange";
        String actual_page_title;
        System.out.println("Hello, World!");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(test_sight);
        actual_page_title = driver.getTitle();
        System.out.println(actual_page_title);
        actual_page_title = driver.getTitle();

        /*
         * if (actual_page_title.equals(expected_page_title)) {
         * System.out.println("Page title matches the expected page title");
         * } else {
         * System.out.println("Page title does not match the expected_page_title");
         * }
         */
        check_page_title(expected_page_title, actual_page_title);
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