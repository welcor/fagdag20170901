package no.bekk.fagdag.client1.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@Builder
@ToString
@Value
public class Client1Widget {
    private String name;
    private String purpose;
    private String detail;
}
