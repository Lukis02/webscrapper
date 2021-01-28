
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.SysexMessage;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static ChromeDriver driver = null;


    public static void Chrome() {

        String exePath = "C:\\Users\\user02\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.es/gp/browse.html?node=931491031&ref_=nav_em__tele_0_2_13_3");
    }

    public static void main(String[] args) {
        Chrome();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el producto que desee:");
        String Busqueda = sc.nextLine();
        WebElement cajaBusqueda =
                driver.findElement(By.id("twotabsearchtextbox"));
        cajaBusqueda.sendKeys(Busqueda);
        cajaBusqueda.submit();


        // Obtener cada uno de los artículos

        int j=1;

        for (int i=4; i<5;i++)
        {
            String modelo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div["+i+"]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div/a/span/span[2]/span[1]")).getText();
        String precio = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div["+i+"]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div/a/span/span[2]/span[1]")).getText();
            System.out.println(modelo);
            System.out.println(precio);
        }
    }
}


