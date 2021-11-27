import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class ShoppingCartStepDef extends AbstractStepDefs{
    @When("Shopping Cart link clicked")
    public void CartLinkClicked(){
        HomePage.GetCartLink().click();
    }
    @Then("{string} shopping cart error message shown")
    public void ShoppingCartErrorMessage(String str){
        Optional<String> ErrorMessage = HomePage.GetCartError();
        if(ErrorMessage.isPresent()){
            Assert.assertEquals(str,ErrorMessage.get());
        }
        else
            fail();
    }




}
