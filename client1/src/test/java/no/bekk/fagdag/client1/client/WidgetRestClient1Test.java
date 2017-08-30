package no.bekk.fagdag.client1.client;

import no.bekk.fagdag.client1.model.Client1Widget;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
public class WidgetRestClient1Test {

    @Test
    public void shouldFetchWidgets() {
        List<Client1Widget> widgets = new WidgetRestClient1().getWidgets(); // !

        assertThat(widgets, hasSize(3));

        Client1Widget fooWidget = widgets.get(0);
        assertThat(fooWidget.getName(), is("foo"));
        assertThat(fooWidget.getDetail(), is("A splendid foo, indeed"));
        assertThat(fooWidget.getPurpose(), is("Being demoed"));
    }

}