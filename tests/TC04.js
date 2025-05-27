// tests/TC04_orgInfo.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC04_orgInfo() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('Admin')).click();
    await driver.sleep(1000);
    await driver.findElement(By.xpath("//span[text()='Organization']")).click();
    await driver.sleep(1000);
    await driver.findElement(By.xpath("//a[text()='General Information']")).click();
    console.log('TC04 passed: Accessed Organization - General Information');
  } catch (e) {
    console.error('TC04 failed:', e);
  } finally {
    await driver.quit();
  }
})();