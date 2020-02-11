package be.vdab.luigi.restclients;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(ECBKoersClient.class)
@PropertySource("application.properties")
class ECBKoersClientTest {
    private final ECBKoersClient client;

    ECBKoersClientTest(ECBKoersClient client) {
        this.client = client;
    }

    @Test
    void deKoersMoetPositiefZijn() {
        assertThat(client.getDollarKoers()).isPositive();
    }
}