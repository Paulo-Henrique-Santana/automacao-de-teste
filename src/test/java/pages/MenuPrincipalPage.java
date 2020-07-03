package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPrincipalPage {

    WebDriver driver;

    public MenuPrincipalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selecionarProduto(String nomeProduto){
        driver.findElement(By.xpath("//h5[@itemprop='name']/a[@title='"+nomeProduto+"']")).click();
    }


}
