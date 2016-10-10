package uk.gov.rifs.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Application {

    private Long id;
    private Long opportunityId;
    private List <ApplicationSection> sections;

    public Long getId() {
        return this.id;
    }

    public Long getOpportunityId() {
        return this.opportunityId;
    }

    public List <ApplicationSection> getSections() {
        return this.sections;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public void setSections(List <ApplicationSection> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}
