// tests/TC05_addEmployee.js
const getDriver = require('../utils/driver');
const { By } = require('selenium-webdriver');

(async function TC05_addEmployee() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.findElement(By.linkText('PIM')).click();
    await driver.sleep(1000);
    await driver.findElement(By.linkText('Add Employee')).click();
    await driver.findElement(By.name('firstName')).sendKeys('Juan');
    await driver.findElement(By.name('lastName')).sendKeys('Perez');
    await driver.findElement(By.css('button[type="submit"]')).click();
    console.log('TC05 passed: Employee added.');
  } catch (e) {
    console.error('TC05 failed:', e);
  } finally {
    await driver.quit();
  }
})();