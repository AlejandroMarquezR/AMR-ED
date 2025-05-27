// tests/TC02_jobTitle.js
const getDriver = require('../utils/driver');
const { By, until, Key } = require('selenium-webdriver');

(async function TC02_jobTitle() {
  const driver = await getDriver();
  try {
    await driver.get('https://opensource-demo.orangehrmlive.com');
    await driver.findElement(By.name('username')).sendKeys('Admin');
    await driver.findElement(By.name('password')).sendKeys('admin123');
    await driver.findElement(By.css('[type="submit"]')).click();
    await driver.wait(until.elementLocated(By.linkText('Admin')), 10000);

    await driver.findElement(By.linkText('Admin')).click();
    await driver.sleep(1000);
    await driver.findElement(By.xpath("//span[text()='Job']")).click();
    await driver.sleep(1000);
    await driver.findElement(By.xpath("//a[text()='Job Titles']")).click();

    await driver.wait(until.elementLocated(By.css('[class*="orangehrm-header-container"] button')), 10000);
    await driver.findElement(By.css('[class*="orangehrm-header-container"] button')).click();
    await driver.findElement(By.xpath('//input[@placeholder="Job Title"]')).sendKeys('QA Engineer');
    await driver.findElement(By.css('button[type="submit"]')).click();
    console.log('TC02 passed: Job title added.');
  } catch (e) {
    console.error('TC02 failed:', e);
  } finally {
    await driver.quit();
  }
})();