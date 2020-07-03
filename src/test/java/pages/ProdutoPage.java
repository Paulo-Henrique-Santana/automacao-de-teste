package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProdutoPage {

    private By lblQuantity = By.id("quantity_wanted_p");
    private By btnAddToCart = By.name("Submit");
    private By btnCheckout = By.xpath("//a[@title='Proceed to checkout']");
    WebDriver driver;

    public ProdutoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(lblQuantity)).isDisplayed();
    }

    public void adicionarAoCarrinho(){
        driver.findElement(btnAddToCart).click();
    }

    public void prosseguirAoCarrinho(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnCheckout));
        element.click();
    }

}
