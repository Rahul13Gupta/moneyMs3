package moneycontrol;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class moneycontrol {
public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");

WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.moneycontrol.com/");
System.out.println(driver.getTitle());
//step 1
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Actions action=new Actions(driver);
action.moveToElement(driver.findElement(By.linkText("Personal Finance"))).build().perform();
driver.findElement(By.linkText("Income Tax Calculator")).click();
//step 2
Set<String> str=driver.getWindowHandles();
Iterator <String> it=str.iterator();
String SScreen=it.next();
System.out.println(SScreen);
String screen=it.next();
driver.switchTo().window(screen);
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.xpath("//div[@class='tax_container']//input[@value='without']")).click();
//step 3
////enter age
driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
//step 4
Select ss =new Select(driver.findElement(By.id("custselect")));

ss.selectByVisibleText("Stay in non metro city");
//step 5
driver.findElement(By.cssSelector("[title=Next]")).click();
////click
//step 6
//enter annual amount
driver.findElement(By.cssSelector("['id=annual_salary']")).sendKeys("15000");
driver.findElement(By.cssSelector("['id=other_income']")).sendKeys("15000");
driver.findElement(By.id("income_tab_next")).click();
//step 7
driver.findElement(By.id("tax_saving_investment")).sendKeys("2000");
driver.findElement(By.cssSelector("[title=Next]")).click();
//step 8
WebElement pd=driver.findElement(By.className("summary_text"));
System.out.println(pd.getText());
//step 9
action.moveToElement(driver.findElement(By.linkText("Mutual Funds"))).build().perform();
driver.findElement(By.linkText("Top Ranked funds")).click();
//step 10
driver.findElement(By.className("robo_medium")).click();



}
}