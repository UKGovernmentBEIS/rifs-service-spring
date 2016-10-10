package uk.gov.rifs.business.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by bendishman on 06/10/2016.
 */
@Entity
@Table(name = "application_section")
public class ApplicationSectionDB {

    private long id;
    private long applicationId;
    private long sectionNumber;
    private String title;
    private boolean started;

    /**
     * Constructor with domain attributes
     * @param sectionNumber
     * @param applicationId
     * @param sectionTitle
     * @param started
     */
    public ApplicationSectionDB(long id, long applicationId, long sectionNumber, String title, boolean started) {
        super();
        this.sectionNumber = sectionNumber;
        this.applicationId = applicationId;
        this.title = title;
        this.started = started;
    }

    public ApplicationSectionDB()
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

//    @OneToMany(fetch=FetchType.EAGER)
//    @JoinColumn(name = "application_id", referencedColumnName="id")
    @Column(name = "application_id")
    public Long getApplicationId() {
        return this.applicationId;
    }

    @Column(name = "section_number")
    public Long getSectionNumber() {
        return this.sectionNumber;
    }

    @Column(name = "title")
    public String getTitle() {
        return this.title;
    }

    @Column(name = "started")
    public boolean isStarted() {
        return this.started;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
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





