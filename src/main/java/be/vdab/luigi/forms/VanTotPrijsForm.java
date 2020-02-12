package be.vdab.luigi.forms;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VanTotPrijsForm {
  private final BigDecimal van;
  private final BigDecimal tot;
}