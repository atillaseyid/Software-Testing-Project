import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SigInStepDefs extends AbstractStepDefs{

    @Given("{string} is filled with {string}")
    public void FieldIsFilledWithParameter(String field,String parameter){
        HomePage.FillField(field,parameter);
    }
    @When("SignIn button is clicked")
    public void SignInButtonIsClicked(){
        HomePage.GetSignInButton().click();
    }
    @And("SignIn link is clicked")
    public void SignInLinkIsClicked(){
        HomePage.GetSignInLink().click();
    }
    @Then("{string} error msg is shown")
    public void ErrorMessageIsShown(String msg){
        Optional<String> ErrorMessage = HomePage.GetLoginError();
        if (ErrorMessage.isPresent())
            Assert.assertEquals(msg,ErrorMessage.get());
        else
            fail();
    }
}
