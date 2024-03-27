package org.reservation.system.common.config.other;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class StringToBigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String valueAsString = p.getText();
        if (valueAsString == null || valueAsString.isEmpty()) {
            return null;
        }
        try {
            return new BigDecimal(valueAsString.replace(",", ""));
        } catch (NumberFormatException e) {
            throw new IOException("Cannot convert string to BigDecimal", e);
        }
    }
}
