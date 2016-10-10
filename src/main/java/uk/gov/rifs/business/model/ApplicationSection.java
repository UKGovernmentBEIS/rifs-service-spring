package uk.gov.rifs.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationSection {

    private long sectionNumber;
    private String title;
    private boolean started;

    public ApplicationSection(long sectionNumber, String title, boolean started) {
        this.sectionNumber = sectionNumber;
        this.title = title;
        this.started = started;
    }

    public ApplicationSection()
    {}

    public Long getSectionNumber() {
        return this.sectionNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean getStarted() {
        return this.started;
    }

    public void setSectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}
