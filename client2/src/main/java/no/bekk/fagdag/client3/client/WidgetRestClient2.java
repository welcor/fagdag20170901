package no.bekk.fagdag.client3.client;

import no.bekk.fagdag.client3.model.Client2Widget;

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
public class WidgetRestClient2 {

    int port = 8080;

    public List<Client2Widget> getWidgets() {
        return new RestTemplate()
                .exchange(
                        "http://localhost:{port}/widgets",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<List<Client2Widget>>() {},
                        singletonMap("port", port)).getBody();
    }

}
