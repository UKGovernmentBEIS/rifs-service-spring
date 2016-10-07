package uk.gov.rifs.business.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bendishman on 06/10/2016.
 */
@Entity
@Table(name = "section")
public class SectionDB {

    private long id;
    private long sectionNumber;
    private long opportunityId;
    private String sectionTitle;
    private List<ParagraphDB> paragraphs;

    /**
     * Constructor with domain attributes
     * @param sectionNumber
     * @param opportunityId
     * @param sectionTitle
     * @param paragraphs
     */
    public SectionDB(long sectionNumber, long opportunityId, String sectionTitle, List<ParagraphDB> paragraphs) {
        super();
        this.sectionNumber = sectionNumber;
        this.opportunityId = opportunityId;
        this.sectionTitle = sectionTitle;
        this.paragraphs = paragraphs;
    }

    public SectionDB()
    {}

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long getId() {
        return this.id;
    }

    @Column(name = "title")
    public String getSectionTitle() {
        return this.sectionTitle;
    }

    @Column(name = "section_number")
    public Long getSectionNumber() {
        return this.sectionNumber;
    }

    @Column(name = "opportunity_id")
    public Long getOpportunityId() {
        return this.opportunityId;
    }

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "section_id", referencedColumnName="id")
    public List<ParagraphDB> getParagraphDB() {
        return this.paragraphs;
    }

    public void setParagraphDB(List<ParagraphDB> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public void setSectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    /**
     * Hibernate requires primary key identity for unique Entity.
     */
    @Override
    public int hashCode() {
//        return new HashCodeBuilder()
//                .append(id)
//                .toHashCode();
        return (int) id;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ((other == null) || (other.getClass() != this.getClass())) { return false; }
        OpportunityDB castOther = (OpportunityDB) other;
        return this.getId()==castOther.getId();

        //return new EqualsBuilder().append(this.getId(), castOther.getId()).isEquals();
    }


}





