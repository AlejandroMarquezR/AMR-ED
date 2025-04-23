package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverSetup {
    protected WebDriver driver;
    
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "ruta\\a\\chromedriver.exe"); // Reemplaza con tu ruta
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}