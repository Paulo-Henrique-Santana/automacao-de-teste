package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnderecoPage {

    private By btnCheckout = By.name("processAddress");
    WebDriver driver;

    public EnderecoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void prosseguir(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        element.click();
    }


}
