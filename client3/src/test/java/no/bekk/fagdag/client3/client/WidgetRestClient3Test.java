package no.bekk.fagdag.client3.client;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import no.bekk.fagdag.client3.model.Client3Widget;

import java.time.LocalDate;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
public class WidgetRestClient3Test {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("WidgetServer",this);

    @Pact(consumer="client3")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .uponReceiving("Fetch of widgets")
                .path("/widgets")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(PactDslJsonArray.arrayMinLike(3)
                        .stringType("name", "foo")
                        .stringType("purpose", "Being demoed")
                        .stringMatcher("creationDate", "\\d\\d\\d\\d-\\d\\d-\\d\\d", LocalDate.now().toString())
                        .closeObject()
                )
                .toPact();
    }

    @PactVerification
    @Test
    public void shouldFetchWidgets() {
        WidgetRestClient3 client3 = new WidgetRestClient3();
        client3.port = mockProvider.getPort();

        List<Client3Widget> widgets = client3.getWidgets(); // !

        assertThat(widgets, hasSize(3));

        Client3Widget fooWidget = widgets.get(0);
        assertThat(fooWidget.getName(), is("foo"));
        assertThat(fooWidget.getPurpose(), is("Being demoed"));
        assertThat(fooWidget.getCreationDate(), is(LocalDate.now()));
    }

}