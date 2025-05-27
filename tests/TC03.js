// tests/TC03_nationalities.js
const getDriver = require('../utils/driver');
const { By, until } = require('selenium-webdriver');

(async function TC03_nationalities() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();

    await driver.findElement(By.linkText('Admin')).click();
    await driver.sleep(1000);
    await driver.findElement(By.xpath("//span[text()='Nationalities']")).click();

    await driver.findElement(By.css('button.oxd-button--secondary')).click();
    await driver.findElement(By.css('input[placeholder="Type here"]')).sendKeys('Argentino');
    await driver.findElement(By.css('button[type="submit"]')).click();
    console.log('TC03 passed: Nationality added.');
  } catch (e) {
    console.error('TC03 failed:', e);
  } finally {
    await driver.quit();
  }
})();