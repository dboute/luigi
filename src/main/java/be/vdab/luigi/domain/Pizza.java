package be.vdab.luigi.domain;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pizza { 
  private final long id; 
  private final String naam; 
  private final BigDecimal prijs;
  private final boolean pikant;
}