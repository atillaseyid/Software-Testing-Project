import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.junit.Assert.fail;

public class CreateAccountStepDefs extends AbstractStepDefs {

    @Given("Create an account {string} is filled with {string}")
    public void CreateAccountFieldFilled(String field,String parameter){
        HomePage.FillField(field,parameter);
    }
    @When("Create an account button is clicked")
    public void CreateAccountButtonClicked(){
        HomePage.GetCreateAccountButton().click();
    }
    @Then("{string} create account error message shown")
    public void CreateAccountErrorMessageShown(String msg){
        Optional<String> ErrorMessage = HomePage.GetAccountError();
        if (ErrorMessage.isPresent())
            Assert.assertEquals(msg,ErrorMessage.get());
        else
            fail();
    }

}
