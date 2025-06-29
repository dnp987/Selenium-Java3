import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        String test_sight = "https://www.tsx.com";
        String page_title = "TMX TSX | TSXV - Toronto Stock Exchange and TSX Venture Exchange";
        String test_title;
        System.out.println("Hello, World!");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(test_sight);
        test_title = driver.getTitle();
        System.out.println(test_title);
        driver.close();
        driver.quit();
    }
}