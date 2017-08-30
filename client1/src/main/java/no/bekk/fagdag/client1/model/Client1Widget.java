package no.bekk.fagdag.client1.model;

import lombok.Builder;
import lombok.ToString;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@Builder
@ToString
public class Client1Widget {
    private String name;
    private String purpose;
    private String detail;
}
