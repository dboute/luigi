package be.vdab.luigi.sessions;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@SessionScope
public class Identificatie implements Serializable {
  private static final long serialVersionUID = 1L;

  public String getEmailAdres() {
    return emailAdres;
  }

  public void setEmailAdres(String emailAdres) {
    this.emailAdres = emailAdres;
  }

  @Email
  private String emailAdres;
}