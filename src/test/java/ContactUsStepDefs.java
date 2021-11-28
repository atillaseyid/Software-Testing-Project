import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class ContactUsStepDefs extends AbstractStepDefs{

    @Given("Contact Us Link clicked")
    public void ContactUsLinkClicked(){
        HomePage.GetContactUsLink().click();
    }
    @And("Contact Us {string} is filled with {string}")
    public void ContactUsFieldFilled(String field, String parameter){
        HomePage.FillField(field, parameter);
    }

    @When("Send button clicked")
    public void SendButtonClicked(){
        HomePage.GetSendButton().click();
    }
    @Then("{string} contact us error message is shown")
    public void ContactUsErrorMsgShown(String msg){
        Optional<String> ErrorMessage = HomePage.GetContactError();
        if( ErrorMessage.isPresent())
            Assert.assertEquals(msg,ErrorMessage.get());
        else
            fail();
    }

    @Then("{string} ContactUs message is shown")
    public void ContactUsMsgSend(String result_msg){
        Optional<String> ResultMessage = HomePage.GetContactUsResult();
        if(ResultMessage.isPresent()){
            Assert.assertEquals(result_msg, ResultMessage.get());
        }
        else
            fail();
    }




}
