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

public class TestandoCursos {
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
    public void tesandoCursos() {
        driver.get("https://testando.eveclass.com/pt/cursos");
        driver.manage().window().setSize(new Dimension(1296, 696));
        js.executeScript("window.scrollTo(0,380.4444580078125)");
        driver.switchTo().defaultContent();
               driver.findElement(By.cssSelector(".no-link-style:nth-child(4) > .img-wrapper > .bg-img")).click();
        js.executeScript("window.scrollTo(0,0)");
        js.executeScript("window.scrollTo(0,399.1111145019531)");
        driver.findElement(By.cssSelector(".bundle-content-course:nth-child(1) .bundle-content-course-action")).click();

    }
}
