package no.bekk.fagdag.client3;

import no.bekk.fagdag.client3.client.WidgetRestClient2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Thomas Arp - thomas.arp@bekk.no
 */
@SpringBootApplication
public class Client2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Client2Application.class, args);
    }

    @Autowired private WidgetRestClient2 client;

    @Override public void run(String... args) throws Exception {
        System.out.println();
        System.out.println(client.getWidgets());
        System.out.println();
    }
}
