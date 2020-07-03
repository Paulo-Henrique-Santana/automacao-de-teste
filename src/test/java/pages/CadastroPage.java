package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage {

    private By cbbTitle = By.name("id_gender");
    private By txtFirstName = By.id("customer_firstname");
    private By txtLastName = By.id("customer_lastname");
    private By txtPassword = By.id("passwd");
    private By txtAddress = By.id("address1");
    private By txtCity = By.id("city");
    private By cbbState = By.id("id_state");
    private By txtPostalCode = By.id("postcode");
    private By txtPhone = By.id("phone");
    private By txtAliasAddress = By.id("alias");
    private By btnRegister = By.id("submitAccount");

    WebDriver driver;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(cbbTitle)).isDisplayed();
    }

    public void realizarCadastro(String firstName, String lastName, String password, String address, String city,
                                 String state, String postalCode, String phone, String aliasAddress){
        driver.findElement(cbbTitle).click();
        driver.findElement(txtFirstName).sendKeys(firstName);
        driver.findElement(txtLastName).sendKeys(lastName);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        new Select(driver.findElement(cbbState)).selectByVisibleText(state);
        driver.findElement(txtPostalCode).sendKeys(postalCode);
        driver.findElement(txtPhone).sendKeys(phone);
        driver.findElement(txtAliasAddress).clear();
        driver.findElement(txtAliasAddress).sendKeys(aliasAddress);
        driver.findElement(btnRegister).click();

    }
}
