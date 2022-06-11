package week4Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(ele, 300, 0).build().perform();
		
	
	
	}

}
