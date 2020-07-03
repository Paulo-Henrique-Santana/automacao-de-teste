package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntregaPage {

    private By inpTerms = By.xpath("//label[@for='cgv']");
    private By btnProceed = By.name("processCarrier");
    WebDriver driver;

    public EntregaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void aceitarTermos(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inpTerms));
        element.click();
        driver.findElement(btnProceed).click();
    }
}
