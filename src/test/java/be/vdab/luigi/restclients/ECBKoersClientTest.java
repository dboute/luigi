package be.vdab.luigi.restclients;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// enkele imports
class ECBKoersClientTest {
    private ECBKoersClient client;
    @BeforeEach
    void beforeEach() {
        client = new ECBKoersClient();
    }
    @Test
    void deKoersMoetPositiefZijn() {
        assertThat(client.getDollarKoers()).isPositive();
    }
}