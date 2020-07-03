package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutenticacaoPage {

    private By msgAuthentication = By.xpath("//h1[contains(text(), 'Authentication')]");
    private By txtEmail = By.id("email_create");
    private By btnCreateAccount = By.id("SubmitCreate");
    WebDriver driver;

    public AutenticacaoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(msgAuthentication)).isDisplayed();
    }

    public void validarEmail(String email){
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(btnCreateAccount).click();
    }

}
