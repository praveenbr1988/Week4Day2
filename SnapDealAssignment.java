package week4Day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.snapdeal.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement mensfasionele = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		WebElement sportsshoesele = driver.findElement(By.xpath("//span[text()=\"Sports Shoes\"]"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(mensfasionele).click(sportsshoesele).perform();
		
		String countofsportsshoes = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		System.out.println("Count of sport shoes: "+countofsportsshoes);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		List<Integer> priceintegerlist = new ArrayList<Integer>();
		List<WebElement> pricelist = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for (WebElement webElement : pricelist) {
			String pricetext = webElement.getText();
			pricetext = pricetext.replaceAll("[^0-9]", "");
			int price = Integer.parseInt(pricetext);
			priceintegerlist.add(price);
		}
		System.out.println(priceintegerlist);
		List<Integer> sortedpricelist = new ArrayList<Integer>(priceintegerlist);		
		Collections.sort(sortedpricelist);
		System.out.println(sortedpricelist);
		boolean sorted = sortedpricelist.equals(priceintegerlist);
		System.out.println(sorted);
		if(sorted)
			System.out.println("Items are sorted correctly");
		else
			System.out.println("Items are not sorted correctly");
		
		WebElement fromvalue = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromvalue.clear();
		fromvalue.sendKeys("400");
		WebElement tovalue = driver.findElement(By.xpath("//input[@name='toVal']"));
		tovalue.clear();
		tovalue.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='View More '])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/parent::div")).click();
		
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='filters-top-selected']/div/div"));
		for (WebElement webElement : findElements) {
			String filter = webElement.getText();
			System.out.println(filter);
		}
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement selectedshoe = driver.findElement(By.xpath("(//img[@class='product-image '])[1]"));
		selectedshoe.click();
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
		
		String cost = driver.findElement(By.xpath("//span[@itemprop='price']")).getText();
		String discount = driver.findElement(By.xpath("//span[@class='pdpDiscount ']")).getText();
		System.out.println("Cost is "+cost+" Discount is: "+discount);
		
		//Taking Screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapdeal.png");
		FileUtils.copyFile(src, dest);
		driver.close();
		driver.quit();
		
	}

}
