package be.vdab.luigi.restclients;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import be.vdab.luigi.exceptions.KoersClientException;

@Component
class FixerKoersClient implements KoersClient {
  private static final Pattern PATTERN = Pattern.compile(".*\"USD\":");
  private final URL url;
  FixerKoersClient() {
    try {
      url = new URL( 
        "http://data.fixer.io/api/latest?access_key=5ba687921d1fb7f0080f60220c8b30b5&symbols=USD");
    } catch (MalformedURLException ex) {
      throw new KoersClientException("Fixer URL is verkeerd.");
    }
  }
  @Override
  public BigDecimal getDollarKoers() {
    try (Scanner scanner = new Scanner(url.openStream())) {
      scanner.skip(PATTERN);
      scanner.useDelimiter("}");
      return new BigDecimal(scanner.next());
    } catch (IOException | NumberFormatException ex) {
      throw new KoersClientException("Kan koers niet lezen via Fixer.", ex);
    }
  }
} 
 