package no.bekk.fagdag.client1.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import no.bekk.fagdag.client1.model.Client1Widget;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
public class WidgetRestClient1Test {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("WidgetServer",this);

    @Pact(consumer="client1")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .uponReceiving("Fetch of widgets")
                .path("/widgets")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(PactDslJsonArray.arrayMinLike(3)
                            .stringType("name", "foo")
                            .stringType("detail", "A splendid foo, indeed")
                            .stringType("purpose", "Being demoed")
                        .closeObject()
                        )
                .toPact();
    }

    @PactVerification
    @Test
    public void shouldFetchWidgets() {
        WidgetRestClient1 client1 = new WidgetRestClient1();
        client1.port = mockProvider.getPort();

        List<Client1Widget> widgets = client1.getWidgets(); 

        assertThat(widgets, hasSize(3));

        Client1Widget fooWidget = widgets.get(0);
        assertThat(fooWidget.getName(), is("foo"));
        assertThat(fooWidget.getDetail(), is("A splendid foo, indeed"));
        assertThat(fooWidget.getPurpose(), is("Being demoed"));
    }

}