import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SubscriptionNewsletterStepDef extends AbstractStepDefs{

    @Given("Newsletter subscription {string} is filled with {string}")
    public void NewsletterSubscriptionFilled(String field, String parameter){
        HomePage.FillField(field, parameter);
    }
    @When("Newsletter button clicked")
    public void NewsletterButtonClicked(){
        HomePage.GetNewsletterButton().click();
    }

    @Then("{string} message is shown")
    public void NewsletterErrorMsg(String error_msg){
        Optional<String> ErrorMessage = HomePage.GetNewsletterError();
        if (ErrorMessage.isPresent())
            Assert.assertEquals(error_msg,ErrorMessage.get());
        else
            fail();
    }


}
