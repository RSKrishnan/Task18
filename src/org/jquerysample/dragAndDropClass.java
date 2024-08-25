package org.jquerysample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class dragAndDropClass {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		//Switched to frame based on the index
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));
		WebElement drop = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
		//dragAndDrop() method is performed to move the object
		Actions actionsObj = new Actions(driver);
		actionsObj.dragAndDrop(drag, drop).build().perform();
		//id is taken for getting the CssValue of background-color
		 WebElement dropDown = driver.findElement(By.id("droppable"));
		 //stored in attribute variable
	     String attribute = dropDown.getCssValue("background-color");
	     //done conversion of color to hex decimal
	    String asHex = Color.fromString(attribute).asHex();
		//assertEquals() method is used to check whether the test case pass or not
		Assert.assertEquals(asHex, "#fffa90");
		//getText() method is used to retrieve the value from the object
		String text = dropDown.getText();
		//assertEquals() method is used to check whether the test case pass or not
		Assert.assertEquals(text, "Dropped!");
		
	}
}
