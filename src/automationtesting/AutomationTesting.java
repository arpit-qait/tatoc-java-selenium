/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.util.Set;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Cookie;
//package automationtesting;

/**
 *
 * @author Arpitagarwal
 */
public class AutomationTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WebDriver driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc");
        WebElement findUrl = driver.findElement(By.tagName("div"));
        
        
        findUrl.findElement(By.linkText("Basic Course")).click();
        driver.findElement(By.className("greenbox")).click();
        driver.switchTo().frame(0);
        String box_Color = driver.findElement(By.tagName("div")).getAttribute("class"));
//        System.out.println(box_Color);
        
        driver.switchTo().frame(0);
        String box_Color1 = driver.findElement(By.tagName("div")).getAttribute("class"));
        while(!box_Color.equals(box_Color1)){
            driver.switchTo().parentFrame();
            driver.findElement(By.linkText("Repaint Box 2")).click();
            driver.switchTo().frame(0);
        box_Color1 = driver.findElement(By.tagName("div")).getAttribute("class"));
        
//        System.out.println(box_Color1);
        }
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Proceed")).click();
            
            
            
        
//        System.out.println(box_Color1);
WebElement point =  driver.findElement(By.id("dropbox"));
        
        WebElement point1 =  driver.findElement(By.id("dragbox"));
    Actions act = new Actions(driver);
    act.dragAndDrop(point1, point).build().perform();
//        while()
driver.findElement(By.linkText("Proceed")).click();
driver.findElement(By.linkText("Launch Popup Window")).click();
String parentWindow = driver.getWindowHandle();
Set<String> windows = driver.getWindowHandles();
//System.out.println(parentWindow);
List<String> popups =new ArrayList<>(windows);
String popupWindow = popups.get(popups.size()-1);
//System.out.println(popupWindow);
driver.switchTo().window(popupWindow);
driver.findElement(By.id("name")).sendKeys("Arpit");
driver.findElement(By.id("submit")).click();
driver.switchTo().window(parentWindow);
driver.findElement(By.linkText("Proceed")).click();
//driver.switchTo().window(;
driver.findElement(By.linkText("Generate Token")).click();
String token = driver.findElement((By.id("token"))).getText();
//System.out.println(token.substring(7));
driver.manage().addCookie(new Cookie("Token", token.substring(7)));
   driver.findElement(By.linkText("Proceed")).click();
    }
        
        
        

    }
    
}
