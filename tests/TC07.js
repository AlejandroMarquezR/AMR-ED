// tests/TC07_searchEmployee.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC07_searchEmployee() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('PIM')).click();
    await driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys('Juan');
    await driver.findElement(By.css('button[type="submit"]')).click();
    console.log('TC07 passed: Search Employee executed.');
  } catch (e) {
    console.error('TC07 failed:', e);
  } finally {
    await driver.quit();
  }
})();