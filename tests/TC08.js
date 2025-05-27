// tests/TC08_employeeEntitlements.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC08_employeeEntitlements() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('Leave')).click();
    await driver.findElement(By.xpath("//span[text()='Entitlements']")).click();
    await driver.findElement(By.xpath("//a[text()='Employee Entitlements']")).click();
    console.log('TC08 passed: Accessed Employee Entitlements.');
  } catch (e) {
    console.error('TC08 failed:', e);
  } finally {
    await driver.quit();
  }
})();