package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfimarCarrinhoPage {

    private By msgShoppingCart = By.id("cart_title");
    private By btnCheckout = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
    WebDriver driver;


    public ConfimarCarrinhoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPresent(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.presenceOfElementLocated(msgShoppingCart)).isDisplayed();
    }

    public void confirmarCarrinho(){
        driver.findElement(btnCheckout).click();
    }
}
