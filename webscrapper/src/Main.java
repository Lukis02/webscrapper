
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.SysexMessage;
import java.util.List;

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


        WebElement cajaBusqueda =
                driver.findElement(By.id("twotabsearchtextbox"));
        cajaBusqueda.sendKeys("Iphone");
        cajaBusqueda.submit();

        List<WebElement>listaElementos =
        driver.findElements(By.xpath("//*[contains(@class, 'article-itemGroup')]"));
        System.out.println("Número de elementos de la lista: " + listaElementos.size());
        // Obtener cada uno de los artículos
        WebElement elementoActual, navegacion;
        int j=1;

        for (int i=0; i<listaElementos.size();i++)
        {
        elementoActual = listaElementos.get(i);
        navegacion =
        elementoActual.findElement(By.xpath("/html/body/div[4]/div/div[6]/ul/li["+ j +
                "]" + "/div/div[2]/div/p[1]/a"));
            System.out.println(j + " " +navegacion.getText());j++;
        }
    }
}


