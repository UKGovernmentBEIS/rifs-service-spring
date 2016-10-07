package uk.gov.rifs.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Opportunity {

    private Long id;
    private String title;
    private String startDate;
    private Value value;
    private List <Description> description;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public Value getValue() {
        return this.value;
    }

    public List <Description> getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Opportunity() {}

    public Opportunity(Long id, String title, String startDate,
             String valueUnit, Double valueAmount, List <Description> description)
    {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.value = new Value (valueUnit, valueAmount);
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setDescription (List <Description> description)
    {
        this.description = description;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}
