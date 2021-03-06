package be.vdab.luigi.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import be.vdab.luigi.restclients.KoersClient;

@ExtendWith(MockitoExtension.class)
class DefaultEuroServiceTest {
    @Mock
    private KoersClient koersClient;
    private final EuroService euroService;

    DefaultEuroServiceTest(EuroService euroService) {
        this.euroService = euroService;
    }

    @Test
    void naarDollar() {
        when(koersClient.getDollarKoers()).thenReturn(BigDecimal.valueOf(1.5));
        assertThat(euroService.naarDollar(BigDecimal.valueOf(2)))
                .isEqualByComparingTo("3");
        verify(koersClient).getDollarKoers();
    }
}