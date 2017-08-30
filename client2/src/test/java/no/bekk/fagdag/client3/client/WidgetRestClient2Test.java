package no.bekk.fagdag.client3.client;

import no.bekk.fagdag.client3.model.Client2Widget;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
public class WidgetRestClient2Test {

    @Test
    public void shouldFetchWidgets() {
        List<Client2Widget> widgets = new WidgetRestClient2().getWidgets(); // !

        assertThat(widgets, hasSize(3));

        Client2Widget fooWidget = widgets.get(0);
        assertThat(fooWidget.getName(), is("foo"));
        assertThat(fooWidget.getDetail(), is("A splendid foo, indeed"));
        assertThat(fooWidget.getCreationDate(), is(LocalDate.now()));
    }

}