package no.bekk.fagdag.client3.client;

import no.bekk.fagdag.client3.model.Client3Widget;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
public class WidgetRestClient3Test {

    @Test
    public void shouldFetchWidgets() {
        List<Client3Widget> widgets = new WidgetRestClient3().getWidgets(); // !

        assertThat(widgets, hasSize(3));

        Client3Widget fooWidget = widgets.get(0);
        assertThat(fooWidget.getName(), is("foo"));
        assertThat(fooWidget.getPurpose(), is("Being demoed"));
        assertThat(fooWidget.getCreationDate(), is(LocalDate.now()));
    }

}