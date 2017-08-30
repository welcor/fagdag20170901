package no.bekk.fagdag.client1;

import no.bekk.fagdag.client1.client.WidgetRestClient1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@SpringBootApplication
public class Client1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Client1Application.class, args);
    }

    @Autowired private WidgetRestClient1 client;

    @Override public void run(String... args) throws Exception {
        System.out.println();
        System.out.println(client.getWidgets());
        System.out.println();
    }
}
