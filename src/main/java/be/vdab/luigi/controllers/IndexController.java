package be.vdab.luigi.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.luigi.domain.Adres;
import be.vdab.luigi.domain.Persoon;
import be.vdab.luigi.sessions.Identificatie;

@Controller
@RequestMapping("/")
class IndexController {
    private final AtomicInteger aantalKeerBekeken = new AtomicInteger();
    private final Identificatie identificatie;

    IndexController(Identificatie identificatie) {
        this.identificatie = identificatie;
    }

    private String boodschap() {
        int uur = LocalTime.now().getHour();
        if (uur < 12) {
            return "morgen";
        }
        if (uur < 18) {
            return "middag";
        }
        return "avond";
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index",
                "boodschap", boodschap());
        modelAndView.addObject(identificatie);
        modelAndView.addObject("zaakvoerder",
                new Persoon("Luigi", "Peperone", 7, true, LocalDate.of(1966, 1, 31),
                        new Adres("Grote markt", "3", 9700, "Oudenaarde")));
        modelAndView.addObject("aantalKeerBekeken", aantalKeerBekeken.incrementAndGet());
        return modelAndView;
    }
} 