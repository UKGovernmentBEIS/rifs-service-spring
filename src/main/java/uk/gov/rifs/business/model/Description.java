package uk.gov.rifs.business.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Description {

    private Long sectionNumber;
    private String title;
    private List<String> paragraphs;

    public Description (Long sectionNumber, String title, List<String> paragraphs)
    {
        this.sectionNumber = sectionNumber;
        this.title = title;
        this.paragraphs = paragraphs;
    }

    public Long getSectionNumber() {
        return this.sectionNumber;
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getParagraphs() {
        return this.paragraphs;
    }

    public void setSectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this);
    }

}
