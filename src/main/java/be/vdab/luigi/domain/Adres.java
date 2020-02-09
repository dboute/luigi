package be.vdab.luigi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Adres {
    private final String straat;
    private final String huisNr;
    private final int postcode;
    private final String gemeente;

}
