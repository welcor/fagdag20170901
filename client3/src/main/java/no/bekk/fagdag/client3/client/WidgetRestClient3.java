package no.bekk.fagdag.client3.client;

import no.bekk.fagdag.client3.model.Client3Widget;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.util.Collections.singletonMap;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@Component
public class WidgetRestClient3 {

    int port;

    public List<Client3Widget> getWidgets() {
        return new RestTemplate()
                .exchange(
                        "http://localhost:{port}/widgets",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<List<Client3Widget>>() {},
                        singletonMap("port", port)).getBody();
    }

}
