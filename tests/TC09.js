// tests/TC09_leaveReports.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC09_leaveReports() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('Leave')).click();
    await driver.findElement(By.xpath("//span[text()='Reports']")).click();
    await driver.findElement(By.xpath("//a[text()='Leave Entitlements and Usage Report']")).click();
    console.log('TC09 passed: Accessed Leave Usage Report.');
  } catch (e) {
    console.error('TC09 failed:', e);
  } finally {
    await driver.quit();
  }
})();