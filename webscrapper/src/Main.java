
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        amazon();
        Scanner sc = new Scanner(System.in);



        pccomponentes();


        // Obtener cada uno de los artículos






    }
    private static ChromeDriver driver = null;


    public static void amazon() {

        String exePath = "C:\\Users\\user02\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.es/gp/browse.html?node=931491031&ref_=nav_em__tele_0_2_13_3");

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
                    String modelo = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul/li["+i+"]/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]")).getText();
                    String precio = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul/li["+i+"]/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]/span[1]")).getText();
                System.out.println(modelo);
                System.out.println(precio);
        }catch (Exception e) {

                }

    }}

    public static void pccomponentes() {
        String exePath = "C:\\Users\\user02\\Downloads\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.pccomponentes.com/smartphone-moviles");

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el producto que desee:");
        String Busqueda = sc.nextLine();
        WebElement cajaBusqueda =
                driver.findElement(By.name("query"));
        cajaBusqueda.sendKeys(Busqueda);
        cajaBusqueda.submit();


        for (int i = 2; i < 6; i++) {

            try {


                String modelo1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/div/div[" + i + "]/article/div/div/header/h3/a")).getText();
                String precio1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/div/div[" + i + "]/article/div/div/div[2]/div/span")).getText();
                System.out.println(modelo1);
                System.out.println(precio1 + "€");
            } catch (Exception e) {

            }

        }
    }

}