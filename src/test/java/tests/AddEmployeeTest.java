package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

public class AddEmployeeTest extends WebDriverSetup {
    @Test(dependsOnMethods = "testValidLogin")
    public void testAddEmployee() {
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.linkText("Add Employee")).click();
        driver.findElement(By.name("firstName")).sendKeys("Juan");
        driver.findElement(By.name("lastName")).sendKeys("Pérez");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assert.assertTrue(driver.getPageSource().contains("Successfully Saved"));
    }
}