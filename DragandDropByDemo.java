package week4Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDropByDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
		
		WebElement ele1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement ele2 = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(ele1, ele2).build().perform();
		
		
		
	}

}
