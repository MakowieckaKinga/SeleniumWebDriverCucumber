package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AddNewAddressSteps {
    public String keyword;
    private WebDriver driver;


    @Given("the user logs in to the MyStore website")
    public void the_user_logs_in_to_the_my_store_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        driver.findElement(By.id("field-email")).sendKeys("ydlivzqbnxpgnfwyqz@cazlv.com"); // email z utworzonego wcześniej konta Użytkownika
        driver.findElement(By.id("field-password")).sendKeys("1qaz2wsx"); // hasło z utworzonego wcześniej konta Użytkownika
        driver.findElement(By.id("submit-login")).click();
    }

    @When("the user goes to the Addresses section")
    public void the_user_goes_to_the_addresses_section() {
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
    }

    @When("the user clicks on Create new address")
    public void the_user_clicks_on_create_new_address() {
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php?controller=address");
    }

    @When("^the user fills out the form with the following (.*) (.*) (.*) (.*) (.*)$")
    public void the_user_fills_out_the_form_with_the_following(String alias, String address, String city, String postalCode, String phone) {

        driver.findElement(By.id("field-alias")).sendKeys(alias);
        driver.findElement(By.id("field-address1")).sendKeys(address);
        driver.findElement(By.id("field-city")).sendKeys(city);
        driver.findElement(By.id("field-postcode")).sendKeys(postalCode);

        Select countryDropdown = new Select(driver.findElement(By.id("field-id_country")));
        countryDropdown.selectByVisibleText("United Kingdom");

        driver.findElement(By.id("field-phone")).sendKeys(phone);

    }

    @When("the user submits the form")
    public void the_user_submits_the_form() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }
}
