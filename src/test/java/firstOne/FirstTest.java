package firstOne;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");


// Тест 1
// Достаем валюту с товаров
        List<WebElement> elements = driver.findElements(By.className("price"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

// Достаем валюту с шапки сайта
        String currency = driver.findElement(By.cssSelector("#_desktop_currency_selector > div > span.expand-more._gray-darker.hidden-sm-down")).getText();
        System.out.println(currency);


// Достаем символ валюты и выводим в консоль
        String currencySymbol = currency.substring(currency.length() - 1);
        System.out.println(currencySymbol);


// Сверяем символ с концом на всех товарах
        for (WebElement element : elements) {
            assertTrue(element.getText().endsWith(currencySymbol));
        }


// Тест 2
//        driver.findElement(By.cssSelector("#_desktop_currency_selector > div")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id=\"_desktop_currency_selector\"]/div/ul/li[3]/a")));




// Тест 3
// Ищем dress
        WebElement searchBox = driver.findElement(By.name("s"));
        searchBox.sendKeys("dress");
        driver.findElement(By.cssSelector("#search_widget > form > button")).click();











    }
}
