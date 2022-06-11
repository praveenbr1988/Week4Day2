package week4Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[1]"));
		WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"sortable\"]/li[7]"));
		Actions action = new Actions(driver);
		action.clickAndHold(ele1).moveToElement(ele2).release().perform();

	}

}
