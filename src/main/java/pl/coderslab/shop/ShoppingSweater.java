package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ShoppingSweater {
    public String keyword;
    private WebDriver driver;

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        driver.findElement(By.id("field-email")).sendKeys("ydlivzqbnxpgnfwyqz@cazlv.com");// email z utworzonego wcześniej konta Użytkownika
        driver.findElement(By.id("field-password")).sendKeys("1qaz2wsx"); // hasło z utworzonego wcześniej konta Użytkownika
        driver.findElement(By.id("submit-login")).click();
    }

    @When("User selects Hummingbird Printed Sweater")
    public void user_selects() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[2]/article/div/div[2]/h3/a")).click();
    }

    @When("User selects size M")
    public void user_selects_size() {
        driver.findElement(By.cssSelector("#group_1")).click();
        driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();
    }

    @When("User adds 5 items to the cart")
    public void user_adds_items_to_the_cart() {
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//*[@id=\"quantity_wanted\"]")).sendKeys("5");
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
    }

    @When("User confirms the shipping address")
    public void user_confirms_the_shipping_address() {
        driver.findElement(By.xpath("//*[@id=\"id-address-delivery-address-4270\"]/header")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")).click();
    }

    @When("User chooses Pick up in store as the delivery method")
    public void user_chooses_as_the_delivery_method() {
        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();
    }

    @When("User selects Pay by Check as the payment method")
    public void user_selects_as_the_payment_method() {
        driver.findElement(By.xpath("//*[@id=\"payment-option-1-container\"]/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
    }

    @Then("User takes a screenshot of the order confirmation with the amount")
    public void user_takes_a_screenshot_of_the_order_confirmation_with_the_amount() {
        try {
            Robot robot = new Robot();
            Rectangle rect = new Rectangle(0, 0, 1600, 900);
            BufferedImage screenShot = robot.createScreenCapture(rect);
            ImageIO.write(screenShot, "JPG",
                    new File("C:\\Users\\dawid\\Desktop\\kurs\\screenshot.jpg")); // dodanie ścieżki zapisu screenshota na urządzeniu

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}