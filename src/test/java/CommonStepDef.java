import io.cucumber.java.en.Given;

public class CommonStepDef extends AbstractStepDefs{

    @Given("Home page is opened")
    public void HomePageIsOpened(){
        HomePage.openPage();
    }

}
