package tarea1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TareaUno {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        // Prueba 1: Login válido
        login(driver, "standard_user", "secret_sauce");
        verificarUrl(driver, "https://www.saucedemo.com/inventory.html");
        driver.navigate().back();

        // Prueba 2: Login inválido
        login(driver, "invalid_user", "wrong_pass");
        verificarMensajeError(driver, "Epic sadface: Username and password do not match any user");

        // Prueba 3: Usuario bloqueado
        login(driver, "locked_out_user", "secret_sauce");
        verificarMensajeError(driver, "Epic sadface: Sorry, this user has been locked out.");

        driver.quit();
    }

    public static void login(WebDriver driver, String user, String pass) {
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("user-name")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
    }

    public static void verificarUrl(WebDriver driver, String urlEsperada) {
        if (driver.getCurrentUrl().equals(urlEsperada)) {
            System.out.println("✅ Login exitoso validado.");
        } else {
            System.out.println("❌ Fallo en login válido.");
        }
    }

    public static void verificarMensajeError(WebDriver driver, String mensajeEsperado) {
        WebElement error = driver.findElement(By.cssSelector("[data-test='error']"));
        if (error.getText().equals(mensajeEsperado)) {
            System.out.println("✅ Mensaje de error correcto: " + mensajeEsperado);
        } else {
            System.out.println("❌ Mensaje de error incorrecto.");
        }
    }
}
