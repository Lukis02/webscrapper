import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        private static Webdriver driver = null;
public static void Chrome()
        { String exePath = "C:\\Users\\user02\\Downloads\\chromedriver_win32";
       System.setProperty("webdriver.chrome.driver", exePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);

        }

    }
}
