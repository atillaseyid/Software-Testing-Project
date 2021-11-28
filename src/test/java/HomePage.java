import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";

    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");
    private static final By SEARCH_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/p[1]");
    private static final By SEARCH_RESULT = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/h1[1]/span[2]");
    private static final By REGISTRATION_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]");
    private static final By CART_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[1]");
    private static final By CREATE_ACCOUNT_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]");
    private static final By NEWSLETTER_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/p[1]");
    private static final By CONTACT_US_RESULT = By.xpath("/html/body/div/div[2]/div/div[3]/div/p");

    @FindBy(className = "login")
    private WebElement SignInLink;

    @FindBy(id = "SubmitLogin")
    private WebElement SignInButton;

    @FindBy(id = "contact-link")
    private WebElement ContactUsLink;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
    private WebElement SearchButton;

    @FindBy(id = "submitMessage")
    private WebElement SendButton;

    @FindBy(id = "SubmitCreate")
    private WebElement CreateAccountButton;

    @FindBy(id = "submitAccount")
    private WebElement RegisterButton;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[3]/footer[1]/div[1]/div[1]/div[1]/form[1]/div[1]/button[1]")
    private WebElement newsletterButton;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
    private WebElement cartLink;

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void openPage(){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver,this);
    }

    private Optional<WebElement> GetError(By errorLocator){
        List<WebElement> elements = driver.findElements(errorLocator);
        if(elements.size()>0){
            return Optional.of(elements.get(0));
        }
        else{
            return Optional.empty();
        }
    }

    private Optional<String> GetErrorMessage(By errorLocator){
        Optional<WebElement> error = GetError(errorLocator);
        if(error.isPresent()){
            WebElement ErrorElement = error.get();
            return Optional.of(ErrorElement.getText());
        }
        else
            return Optional.empty();
    }

    public Optional<String> GetLoginError() {
        return GetErrorMessage(LOGIN_ERROR);
    }
    public Optional<String> GetContactError(){return GetErrorMessage(CONTACT_ERROR);}
    public Optional<String> GetSearchError() {
        return GetErrorMessage(SEARCH_ERROR);
    }
    public Optional<String> GetSearchResult() {
        return GetErrorMessage(SEARCH_RESULT);
    }
    public Optional<String> GetRegistrationError() {
        return GetErrorMessage(REGISTRATION_ERROR);
    }
    public Optional<String> GetAccountError() {
        return GetErrorMessage(CREATE_ACCOUNT_ERROR);
    }
    public Optional<String> GetCartError() {
        return GetErrorMessage(CART_ERROR);
    }
    public Optional<String> GetNewsletterError() {
        return GetErrorMessage(NEWSLETTER_ERROR);
    }
    public Optional<String> GetContactUsResult(){ return GetErrorMessage(CONTACT_US_RESULT);}



    public WebElement GetField(By locator){
        return driver.findElement(locator);
    }
    public void FillField(String field, String value){
        GetField(By.id(field)).sendKeys(value);
    }
    public WebElement GetSignInLink(){
        return SignInLink;
    }
    public WebElement GetContactUsLink(){
        return ContactUsLink;
    }
    public WebElement GetSignInButton(){
        return SignInButton;
    }
    public WebElement GetSendButton(){
        return SendButton;
    }
    public WebElement GetSearchButton(){
        return SearchButton;
    }
    public WebElement GetCreateAccountButton(){
        return CreateAccountButton;
    }
    public WebElement GetCartLink(){
        return cartLink;
    }
    public WebElement GetRegisterButton(){
        return RegisterButton;
    }
    public WebElement GetNewsletterButton(){
        return newsletterButton;
    }








}
