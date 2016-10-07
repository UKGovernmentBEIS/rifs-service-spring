package uk.gov.rifs.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    private String unit;
    private Double amount;

    public Value (String unit, Double amount)
    {
        this.unit = unit;
        this.amount = amount;
    }

    public String getUnit() {
        return this.unit;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
