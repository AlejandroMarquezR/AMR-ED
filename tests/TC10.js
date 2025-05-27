// tests/TC10_assignLeave.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC10_assignLeave() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('Leave')).click();
    await driver.findElement(By.xpath("//a[text()='Assign Leave']")).click();
    await driver.findElement(By.css('input[placeholder="Type for hints..."]')).sendKeys('Juan');
    console.log('TC10 passed: Assign Leave form opened.');
  } catch (e) {
    console.error('TC10 failed:', e);
  } finally {
    await driver.quit();
  }
})();