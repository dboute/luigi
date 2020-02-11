package be.vdab.luigi.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import be.vdab.luigi.exceptions.KoersClientException;
import be.vdab.luigi.restclients.KoersClient;

@Service
class DefaultEuroService implements EuroService {
    private final KoersClient[] koersClients;

    DefaultEuroService(KoersClient[] koersClients) {
        this.koersClients = koersClients;
    }

    @Override
    public BigDecimal naarDollar(BigDecimal euro) {
        Exception laatsteException = null;
        for (KoersClient koersClient : koersClients) {
            try {
                return euro.multiply(koersClient.getDollarKoers())
                        .setScale(2, RoundingMode.HALF_UP);
            } catch (KoersClientException ex) {
                laatsteException = ex;
            }
        }
        throw new KoersClientException("Kan dollar koers nergens lezen.",
                laatsteException);
    }
} 