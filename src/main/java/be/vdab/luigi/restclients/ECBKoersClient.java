package be.vdab.luigi.restclients;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import be.vdab.luigi.exceptions.KoersClientException;

//@Qualifier("ECB")
@Order(2)
@Component
class ECBKoersClient implements KoersClient {
    private final URL url;

    ECBKoersClient(@Value("${ecbKoersURL}") URL url) {
        this.url = url;
    }

    @Override
    public BigDecimal getDollarKoers() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try (InputStream stream = url.openStream()) {
            XMLStreamReader reader = factory.createXMLStreamReader(stream);
            try {
                while (reader.hasNext()) {
                    if (reader.next() == XMLStreamConstants.START_ELEMENT
                            && "USD".equals(reader.getAttributeValue(null, "currency"))) {
                        return new BigDecimal(reader.getAttributeValue(null, "rate"));
                    }
                }
                throw new KoersClientException("XML van ECB bevat geen USD.");
            } finally {
                reader.close();
            }
        } catch (IOException | NumberFormatException | XMLStreamException ex) {
            throw new KoersClientException("Kan koers niet lezen via ECB.", ex);
        }
    }
} 