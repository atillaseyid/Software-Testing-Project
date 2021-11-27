import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SearchStepDefs extends AbstractStepDefs {

    @Given("Search {string} filled with {string}")
    public void SearchFieldFilled(String field,String parameter){
        HomePage.FillField(field, parameter);
    }
    @When("Search Button clicked")
    public void CartLinkSelected(){
        HomePage.GetSearchButton().click();
    }
    @Then("{string} search error message shown")
    public void SearchErrorMessageIsShown(String msg){
        Optional<String> ErrorMessage = HomePage.GetSearchError();
        if(ErrorMessage.isPresent())
            Assert.assertEquals(msg,ErrorMessage.get());
        else
            fail();
    }
    @Then("{string} search result message shown")
    public void ResultFoundMsgShown(String result_msg){
        Optional<String> ResultMessage = HomePage.GetSearchResult();
        if(ResultMessage.isPresent()){
            Assert.assertEquals(result_msg, ResultMessage.get());
        }
        else
            fail();
    }


}
