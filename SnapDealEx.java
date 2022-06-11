package week4Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealEx {

	public static void main(String[] args) {
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
		
		WebElement asianshoeEle = driver.findElement(By.xpath("//source[@title=\"ASIAN Running Shoes\"]/parent::picture"));
		WebElement quickviewEle = driver.findElement(By.xpath("//div[@class=\"product-tuple-image \"]//div/div[contains(text(), 'Quick View')]"));
		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(asianshoeEle).click(quickviewEle).perform();
		
	}

}
