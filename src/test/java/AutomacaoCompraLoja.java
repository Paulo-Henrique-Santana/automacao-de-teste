import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class AutomacaoCompraLoja {

    MenuPrincipalPage menuPrincipalPage;
    ProdutoPage produtoPage;
    ConfimarCarrinhoPage confimarCarrinhoPage;
    AutenticacaoPage autenticacaoPage;
    CadastroPage cadastroPage;
    EnderecoPage enderecoPage;
    EntregaPage entregaPage;
    PagamentoPage pagamentoPage;
    WebDriver driver;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" http://automationpractice.com/index.php");
    }

    @Test
    public void comprarProduto(){

        menuPrincipalPage = new MenuPrincipalPage(driver);
        menuPrincipalPage.selecionarProduto("Printed Dress");

        produtoPage = new ProdutoPage(driver);
        Assert.assertTrue(produtoPage.isPresent());
        produtoPage.adicionarAoCarrinho();
        produtoPage.prosseguirAoCarrinho();

        confimarCarrinhoPage = new ConfimarCarrinhoPage(driver);
        Assert.assertTrue(confimarCarrinhoPage.isPresent());
        confimarCarrinhoPage.confirmarCarrinho();

        autenticacaoPage = new AutenticacaoPage(driver);
        Assert.assertTrue(autenticacaoPage.isPresent());
        autenticacaoPage.validarEmail("1234567teste@teste.com");

        cadastroPage = new CadastroPage(driver);
        Assert.assertTrue(cadastroPage.isPresent());
        cadastroPage.realizarCadastro("teste", "teste", "teste", "teste", "teste",
                "Alabama", "00000", "12345678", "teste");

        enderecoPage = new EnderecoPage(driver);
        enderecoPage.prosseguir();

        entregaPage = new EntregaPage(driver);
        entregaPage.aceitarTermos();

        pagamentoPage = new PagamentoPage(driver);
        // cheque ou bankwire
        pagamentoPage.selecionarPagamento("cheque");
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
