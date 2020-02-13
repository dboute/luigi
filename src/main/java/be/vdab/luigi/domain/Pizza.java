package be.vdab.luigi.domain;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pizza { 
  private final long id;
  @NotBlank
  private final String naam;
  @NotNull
  @PositiveOrZero
  @NumberFormat(pattern = "0.00")
  private final BigDecimal prijs;
  private final boolean pikant;
}