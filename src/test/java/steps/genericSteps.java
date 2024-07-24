package steps;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import utils.RestUltils;

public class genericSteps {
    @Entao("valido que recebo status {int} no response")
    public void validoQueReceboStatusNoResponse(int status) {
        Assert.assertEquals(status, RestUltils.getResponse().getStatusCode());

    }
}
