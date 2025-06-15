package tarea3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TareaTres {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        esperar(3000);
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        // Validación CA1
        if (driver.getPageSource().contains("Employee Information")) {
            System.out.println("✅ Acceso al módulo PIM validado.");
        }

        buscarEmpleado(driver, "Linda"); // Usa un nombre real del sistema demo

        driver.quit();
    }

    public static void buscarEmpleado(WebDriver driver, String nombre) {
        WebElement input = driver.findElement(By.xpath("//label[text()='Employee Name']/following::input[1]"));
        input.sendKeys(nombre);
        esperar(2000);
        driver.findElement(By.xpath("//div[@role='option']")).click(); // selecciona sugerencia
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        esperar(2000);

        WebElement tabla = driver.findElement(By.xpath("//div[@class='oxd-table-body']"));
        if (tabla.getText().contains(nombre)) {
            System.out.println("✅ Empleado encontrado: " + nombre);
        } else {
            System.out.println("❌ Empleado no encontrado: " + nombre);
        }
    }

    public static void esperar(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
