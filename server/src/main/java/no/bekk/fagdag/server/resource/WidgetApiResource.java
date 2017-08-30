package no.bekk.fagdag.server.resource;

import no.bekk.fagdag.server.model.Widget;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@RestController
public class WidgetApiResource {

    @RequestMapping("/widgets")
    public List<Widget> listWidgets() {
        Widget widget = Widget.builder()
                .name("foo")
                .detail("A splendid foo, indeed")
                .creationDate(LocalDate.now())
                .purpose("Being demoed")
                .price(100.0)
                .build();
        Widget widget2 = Widget.builder()
                .name("bar")
                .detail("Where to go?")
                .creationDate(LocalDate.now())
                .purpose("Being demoed")
                .price(1000.0)
                .build();
        Widget widget3 = Widget.builder()
                .name("baz")
                .detail("Is this a fish?")
                .creationDate(LocalDate.now())
                .purpose("Being demoed")
                .price(40.0)
                .build();

        return asList(widget, widget2, widget3);
    }
}
