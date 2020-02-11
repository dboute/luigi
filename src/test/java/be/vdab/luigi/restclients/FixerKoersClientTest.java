package be.vdab.luigi.restclients;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@Import(FixerKoersClient.class)
@PropertySource("application.properties")
class FixerKoersClientTest {
    private final FixerKoersClient client;

    FixerKoersClientTest(FixerKoersClient client) {
        this.client = client;
    }

    @Test
    void deKoersMoetPositiefZijn() {
        assertThat(client.getDollarKoers()).isPositive();
    }
}