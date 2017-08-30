package no.bekk.fagdag.client3.client;

import no.bekk.fagdag.client3.model.Client3Widget;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@Component
public class WidgetRestClient3 {

    public List<Client3Widget> getWidgets() {
        return new RestTemplate()
                .exchange(
                        "http://localhost:8080/widgets",
                        HttpMethod.GET,
                        HttpEntity.EMPTY,
                        new ParameterizedTypeReference<List<Client3Widget>>() {}).getBody();
    }

}
