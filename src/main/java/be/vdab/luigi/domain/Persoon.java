package be.vdab.luigi.domain;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Persoon {
  private final String voornaam;
  private final String familienaam;
  private final int aantalKinderen;
  private final boolean gehuwd;
  @DateTimeFormat(style="S-")
  private final LocalDate geboorte;
  private final Adres adres;

  public String getNaam() {
    return voornaam + ' ' + familienaam;
  }
}