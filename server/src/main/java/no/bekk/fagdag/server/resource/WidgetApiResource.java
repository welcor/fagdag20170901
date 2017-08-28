package no.bekk.fagdag.server.resource;

import no.bekk.fagdag.server.model.Widget;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return Collections.nCopies(3, widget);
    }
}
