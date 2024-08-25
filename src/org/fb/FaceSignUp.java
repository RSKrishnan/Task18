package org.fb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FaceSignUp {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Facebook URL is launched
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		// title of facebook is stored in string to verify
		String title = driver.getTitle();
		// Verification of the facebook homepage is done
		Assert.assertEquals(title, "Facebook – log in or sign up");

		// Clicked on create new account button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		driver.findElement(By.cssSelector("input[placeholder='First name']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("User");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("ramakrishnanr013@gmail.com");

		driver.findElement(By.cssSelector("input#password_step_input")).sendKeys("Test@0657$");

		// xpath of dropbox is passed in select class and selectByValue() method is used
		// to select the value
		WebElement selectDay = driver.findElement(By.id("day"));
		Select select1 = new Select(selectDay);
		select1.selectByValue("11");

		WebElement selectMonth = driver.findElement(By.id("month"));
		Select select2 = new Select(selectMonth);
		select2.selectByValue("5");

		WebElement selectYr = driver.findElement(By.id("year"));
		Select select3 = new Select(selectYr);
		select3.selectByValue("1985");
		// click method is used to select the Gender
		driver.findElement(By.xpath("//label[text()='Male']")).click();

		// Clicked on Submit button
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		//getTitle() method is used to get the title
		String title2 = driver.getTitle();
		//assertEquals() method is used to whether the test is getting pass or failed
		Assert.assertEquals(title2, "Facebook");

	}
}
