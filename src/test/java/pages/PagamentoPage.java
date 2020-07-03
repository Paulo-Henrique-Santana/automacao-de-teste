package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagamentoPage {

    private By msgPaymant = By.xpath("//h1[contains(text(), 'Please choose your payment method')]");
    private By btnConfirm = By.xpath("//p[@id='cart_navigation']/button");
    private By btnBackToOrders = By.xpath("//a[@title='Back to orders']");
    WebDriver driver;

    public PagamentoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selecionarPagamento(String formaPagamento){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(msgPaymant)).isDisplayed();
        driver.findElement(By.className(formaPagamento)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirm)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(btnBackToOrders)).click();
    }


}
