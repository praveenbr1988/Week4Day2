package week4Day2;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
		
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		WebElement brandsearchbox = driver.findElement(By.id("brandSearchBox"));
		
		Actions action = new Actions(driver);
		action.moveToElement(brand).click(brandsearchbox).release().perform();
		brandsearchbox.sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]")).click();
		String browsertitle = driver.getTitle();
		if(browsertitle.contains("L'Oreal Paris")) {
			
			System.out.println("Title contains: L'Oreal Paris");
		}
		
		driver.findElement(By.xpath("//span[text()=\"Sort By : popularity\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"customer top rated\"]")).click();
		
		driver.findElement(By.xpath("//span[text()=\"Category\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Hair\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Hair Care\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Shampoo\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Concern\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()=\"Color Protection\"]")).click();
		Thread.sleep(3000);
		
		List<WebElement> listoffilters = driver.findElements(By.xpath("//*[@id=\"filters-listing\"]/div[1]/div[2]/div"));
		System.out.println(listoffilters.size());
		for (WebElement webElement : listoffilters) {
			String filter = webElement.getText();
			if (filter.equals("Shampoo")) {
				
				System.out.println("Filter- Shampoo has been applied");
			}
			
			
		}
		
		driver.findElement(By.xpath("//img[@alt=\"L'Oreal Paris Colour Protect Shampoo\"]")).click();		
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
		
		WebElement drpdown = driver.findElement(By.xpath("//*[@title='SIZE']"));
		
		Select select = new Select(drpdown);
		select.selectByIndex(0);
		
		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println(mrp);
		
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		Thread.sleep(3000);
		WebElement frameele = driver.findElement(By.xpath("//*[@id=\"portal-root\"]/div/div[1]/iframe"));
		driver.switchTo().frame(frameele);
		String grandtotal1 = driver.findElement(By.xpath("((//span[text()='Grand Total']/parent::div)/following-sibling::div)[1]")).getText();
		grandtotal1=grandtotal1.replaceAll("[^0-9]", "");
		System.out.println("GrandTotal1 is: "+grandtotal1);
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String grandtotal2 = driver.findElement(By.xpath("//div[text()='Grand Total']/following-sibling::div/span")).getText();
		grandtotal2=grandtotal2.replaceAll("[^0-9]", "");
		System.out.println("GrandTotal2 is: "+grandtotal2);
		if(grandtotal1.equals(grandtotal2)) {
			
			System.out.println("Grandtotals are same");
		}
		
		
		driver.quit();
	}

}
