package webTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.*;

public class VisitanteEveclass {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //aponta onde esta o chrome
        //System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver.exe");
        driver = new ChromeDriver(options);  // instacia/liga o chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void VisitanteTestando() throws InterruptedException {
        driver.get("https://testando.eveclass.com/pt/auth/registrar");
        driver.manage().window().setSize(new Dimension(1280, 680));
        driver.findElement(By.cssSelector("input[data-vv-as=\"Seu nome completo\"]")).click();
        driver.findElement(By.cssSelector("input[data-vv-as=\"Seu nome completo\"]")).sendKeys("tomaz bruno");
        driver.findElement(By.cssSelector("input[data-vv-as=\"Seu email\"]")).click();
        driver.findElement(By.cssSelector("input[data-vv-as=\"Seu email\"]")).sendKeys("Tomazbruno97@gmail.com");
        driver.findElement(By.cssSelector("input[data-vv-as=\"Confirme seu email\"]")).sendKeys("Tomazbruno97@gmail.com");
        //driver.findElement(By.cssSelector(".button-text > span")).click();
        Thread.sleep(1000); //VALOR EM MILISEGUNDOSThread.sleep(3000); //VALOR EM MILISEGUNDOS
        driver.findElement(By.xpath("//*[@id='auth-panel']/div[2]/div/div/div/div/div/div[2]/div/form/div[2]/button")).click();
        //*[@id="auth-panel"]/div[2]/div/div/div/div/div/div[2]/div/form/div[2]/button
        //driver.findElement(By.cssSelector("input[data-vv-as=\"Sua Senha\"]")).sendKeys("Senha@123");
        Thread.sleep(1000); //VALOR EM MILISEGUNDOSThread.sleep(3000); //VALOR EM MILISEGUNDOS
        driver.findElement(By.cssSelector("input[id*=\"signupcreatepasswordpassword-i-\"]")).click();
        driver.findElement(By.cssSelector("input[id*=\"signupcreatepasswordpassword-i-\"]")).sendKeys("Senha@123");
        driver.findElement(By.cssSelector("input[id*=\"signupcreatepasswordrepeatpassword-i-\"]")).click();
        driver.findElement(By.cssSelector("input[id*=\"signupcreatepasswordrepeatpassword-i-\"]")).sendKeys("Senha@123");
        driver.findElement(By.cssSelector(".button-text > span")).click();
        driver.findElement(By.cssSelector("span:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".no-link-style:nth-child(2) > .img-wrapper > .bg-img"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".button-text:nth-child(2) > span")).click();
        js.executeScript("window.scrollTo(0,350)");
        driver.findElement(By.cssSelector(".no-link-style:nth-child(4) > .img-wrapper > .bg-img")).click();
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.linkText("Comprar")).click();
        js.executeScript("window.scrollTo(0,0)");
    }
}

