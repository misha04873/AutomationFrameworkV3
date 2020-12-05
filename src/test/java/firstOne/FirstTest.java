package firstOne;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();



        driver.get("https://dota2.ru/");
        driver.quit();
    }
}
