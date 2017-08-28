package no.bekk.fagdag.server.model;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@lombok.Builder
public class Widget {
    private String name;
    private String purpose;
    private String detail;
    private Double price;

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate creationDate;
}
