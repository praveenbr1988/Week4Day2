package week4Day2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailTableEx {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MS"+Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU"+Keys.ENTER);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainlist = driver.findElements(By.xpath("//table[@class=\"DataTable TrainList TrainListHeader\"]//tr//td[2]"));
		int listsize = trainlist.size();
		for (WebElement webElement : trainlist)
			System.out.println(webElement.getText());	
		Set<WebElement> trainset = new HashSet<WebElement>(trainlist);
		int setsize = trainset.size();
		if(listsize==setsize)
			System.out.println("No duplicate train names");
		else
			System.out.println("duplicate train names present");
	}
}
