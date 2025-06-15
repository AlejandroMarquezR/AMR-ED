package tarea2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TareaDos {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        esperar(3000);
        driver.findElement(By.xpath("//span[text()='Admin']")).click();

        // Validación CA1
        if (driver.getPageSource().contains("System Users")) {
            System.out.println("✅ Acceso al módulo Admin validado.");
        }

        // Búsqueda de usuario existente (CA2)
        buscarUsuario(driver, "Admin");

        // Búsqueda de usuario inexistente (CA3)
        buscarUsuario(driver, "usuario_inventado_123");

        driver.quit();
    }

    public static void buscarUsuario(WebDriver driver, String nombreUsuario) {
        WebElement input = driver.findElement(By.xpath("//label[text()='Username']/following::input[1]"));
        input.clear();
        input.sendKeys(nombreUsuario);
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        esperar(2000);

        WebElement tabla = driver.findElement(By.xpath("//div[@class='oxd-table-body']"));

        if (tabla.getText().contains(nombreUsuario)) {
            System.out.println("✅ Usuario encontrado: " + nombreUsuario);
        } else if (tabla.getText().contains("No Records Found")) {
            System.out.println("✅ Usuario no encontrado: " + nombreUsuario);
        } else {
            System.out.println("❌ Resultado inesperado para: " + nombreUsuario);
        }
    }

    public static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
