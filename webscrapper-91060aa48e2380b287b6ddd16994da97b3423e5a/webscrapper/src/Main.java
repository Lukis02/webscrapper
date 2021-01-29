
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class Main {
    private static ChromeDriver driver = null;


    public static void Amazon() {

        String exePath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.es/gp/browse.html?node=931491031&ref_=nav_em__tele_0_2_13_3");
    }

    public static void carrefour() {

        String exePath = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.carrefour.es/");
    }

    public static void main(String[] args) {
        Amazon();
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el producto que desee:");
        String Busqueda = sc.nextLine();
        WebElement cajaBusqueda =
                driver.findElement(By.id("twotabsearchtextbox"));
        cajaBusqueda.sendKeys(Busqueda);
        cajaBusqueda.submit();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 2; i < 7; i++) {
            try {


                String modelo = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[" + i + "]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).getText();
                String precio = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/span[3]/div[2]/div[" + i + "]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div/a/span[1]/span[2]/span[1]")).getText();
                System.out.println(modelo);
                System.out.println(precio + "€");
            } catch (Exception g) {

            }

        }

        driver.quit();

        carrefour();
        System.out.println("Introduzca el producto que desee:");
        String Busqueda1 = sc.nextLine();
        WebElement cajaBusqueda1 =
                driver.findElement(By.id("search-input"));
        cajaBusqueda1.sendKeys(Busqueda1);
        cajaBusqueda1.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 2; i < 7; i++) {
            try {
                String modelo = driver.findElement(By.xpath("/html/body/section/section[1]/section/article["+i+"]/div/a[2]/h1")).getText();
                String precio = driver.findElement(By.xpath("/html/body/section/section[1]/section/article["+i+"]/div/p/strong")).getText();
                System.out.println(modelo);
                System.out.println(precio);
            }catch (Exception e) {
                }
            }
        }
    }




