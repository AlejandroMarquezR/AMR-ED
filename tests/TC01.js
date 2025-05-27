// tests/TC01_login.js
const getDriver = require('../utils/driver');
const { By, until } = require('selenium-webdriver');

(async function TC01_login() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.wait(until.urlContains('dashboard'), 10000);
    console.log('TC01 passed: Login successful.');
  } catch (e) {
    console.error('TC01 failed:', e);
  } finally {
    await driver.quit();
  }
})();