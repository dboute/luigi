package be.vdab.luigi.restclients;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FixerKoersClientTest {
    private FixerKoersClient client;
    @BeforeEach
    void beforeEach() {
        client = new FixerKoersClient();
    }
    @Test
    void deKoersMoetPositiefZijn() {
        assertThat(client.getDollarKoers()).isPositive();
    }
}