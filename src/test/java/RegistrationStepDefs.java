import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Optional;
import static org.junit.Assert.fail;

public class RegistrationStepDefs extends AbstractStepDefs{

    @Given("Registration {string} is filled with {string}")
    public void RegistrationFieldIsFilled(String field,String parameter){
        HomePage.FillField(field, parameter);
    }
    @When("Register button is clicked")
    public void RegisterButtonIsClicked(){
        HomePage.GetRegisterButton().click();
    }
    @Then("{string} registration error message is shown")
    public void RegistrationErrorMessageIsShown(String msg){
        Optional<String> ErrorMessage = HomePage.GetRegistrationError();
        if(ErrorMessage.isPresent())
            Assert.assertEquals(msg,ErrorMessage.get());
        else
            fail();
    }
}
