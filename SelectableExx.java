package week4Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableExx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		
		
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[2]"));
		WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li[3]"));
		Actions action = new Actions(driver);
		action.clickAndHold(ele1).clickAndHold(ele2).build().perform();
		
		
		
	}

}
