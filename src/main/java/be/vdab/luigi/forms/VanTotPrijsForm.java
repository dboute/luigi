package be.vdab.luigi.forms;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VanTotPrijsForm {
    @NotNull
    @PositiveOrZero
    private final BigDecimal van;
    @NotNull
    @PositiveOrZero
    private final BigDecimal tot;
}