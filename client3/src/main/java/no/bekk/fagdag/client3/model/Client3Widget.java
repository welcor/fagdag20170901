package no.bekk.fagdag.client3.model;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@Builder
@ToString
@Value
public class Client3Widget {
    private String name;
    private String purpose;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate creationDate;
}
