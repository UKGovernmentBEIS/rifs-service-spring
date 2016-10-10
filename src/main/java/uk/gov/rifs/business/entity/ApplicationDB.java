package uk.gov.rifs.business.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "application")
public class ApplicationDB {

    private long id;
    private long opportunityId;
    private List<ApplicationSectionDB> sections;

    public ApplicationDB(long opportunityId) {
        super();
        this.opportunityId = opportunityId;
    }

    public ApplicationDB() {
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    @OneToMany(fetch=FetchType.EAGER)
//    @JoinColumn(name = "opportunity_id", referencedColumnName="id")
    @Column(name = "opportunity_id")
    public long getOpportunityId() {
        return this.opportunityId;
    }

    public void setOpportunityId(long opportunityId) {
        this.opportunityId = opportunityId;
    }

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "application_id", referencedColumnName="id")
    public List<ApplicationSectionDB> getSections() {
        return this.sections;
    }

    public void setSections(List<ApplicationSectionDB> sections) {
        this.sections = sections;
    }
}


