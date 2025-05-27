// tests/TC06_pimReports.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC06_pimReports() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('PIM')).click();
    await driver.findElement(By.xpath("//a[text()='Reports']")).click();
    console.log('TC06 passed: Accessed PIM Reports.');
  } catch (e) {
    console.error('TC06 failed:', e);
  } finally {
    await driver.quit();
  }
})();