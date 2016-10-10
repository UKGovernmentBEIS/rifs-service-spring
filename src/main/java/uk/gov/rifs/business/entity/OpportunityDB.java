package uk.gov.rifs.business.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "opportunity")
public class OpportunityDB {

    private long id;
    private String opportunityTitle;
    private String startDate;
	private Integer duration;
    private String durationUnits;
	private BigDecimal value;
    private String valueUnits;
    private List<SectionDB> sections;


        /**
     * Constructor with domain attributes
     * @param opportunityTitle
     * @param startDate
     * @param duration
     * @param durationUnits
     * @param value
     * @param valueUnits
     * @param sections
     */


     public OpportunityDB(String opportunityTitle, String startDate, Integer duration, String durationUnits,
                             BigDecimal value, String valueUnits, List<SectionDB> sections) {
        super();
        this.opportunityTitle = opportunityTitle;
        this.startDate = startDate;
        this.duration = duration;
        this.durationUnits = durationUnits;
        this.value = value;
        this.valueUnits = valueUnits;
        this.sections = sections;
    }

    public OpportunityDB()
    {}

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "opportunity_id", referencedColumnName="id")
    public List<SectionDB> getSections() {
        return this.sections;
    }

    public void setSections(List<SectionDB> sections) {
        this.sections = sections;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
//        Validate.isTrue(id > 0);
        this.id = id;
    }

    /**
     * @return the opportunityTitle
     */
    @Column(name = "title")
    public String getOpportunityTitle() {
        return opportunityTitle;
    }

    /**
     * @param opportunityTitle the opportunityTitle to set
     */
    public void setOpportunityTitle(String opportunityTitle) {

//        Validate.notNull(opportunityTitle, "Title must not be null");
//        Validate.notBlank(opportunityTitle,"Title must not be Blank");
//        Validate.inclusiveBetween(0, 150, opportunityTitle.length(), "Title length must be between 0 and 150 Characters ");

        this.opportunityTitle = opportunityTitle;
    }

    /**
     * @return the startDate
     */
    @Column(name = "start_date")
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {

        this.startDate = startDate;
    }

    /**
     * @return the duration
     */
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {

        this.duration = duration;
    }

    /**
     * @return the durationUnits
     */
    @Column(name = "duration_units")
    public String getDurationUnits() {
        return durationUnits;
    }

    /**
     * @param durationUnits the durationUnits to set
     */
    public void setDurationUnits(String durationUnits) {
        this.durationUnits = durationUnits;
    }

    /**
     * @return the value
     */
    @Column(name = "value")
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the valueUnits
     */
    @Column(name = "value_units")
    public String getValueUnit() {
        return valueUnits;
    }

    /**
     * @param valueUnits the value to set
     */
    public void setValueUnit(String valueUnits) {
        this.valueUnits = valueUnits;
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

//
//    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "title")
//    private String opportunityTitle;
//
//    @Column(name = "start_date")
//    private String startDate;
//
//    @Column(name = "duration")
//    private Integer duration;
//
//    @Column(name = "duration_units")
//    private String durationUnits;
//
//    @Column(name = "value")
//    private BigDecimal value;
//
//    @Column(name = "value_units")
//    private String valueUnits;
//
//    /**
//     * Constructor with domain attributes
//     * @param opportunityTitle
//     * @param startDate
//     * @param duration
//     * @param durationUnits
//     * @param value
//     * @param valueUnits
//     */
//    public OpportunityDB(String opportunityTitle, String startDate, Integer duration, String durationUnits,
//                         BigDecimal value, String valueUnits) {
//        super();
//        this.opportunityTitle = opportunityTitle;
//        this.startDate = startDate;
//        this.duration = duration;
//        this.durationUnits = durationUnits;
//        this.value = value;
//        this.valueUnits = valueUnits;
//    }
//
//    public OpportunityDB()
//    {}
//
//    /**
//     * @return the id
//     */
//    public long getId() {
//        return id;
//    }
//
//    /**
//     * @param id the id to set
//     */
//    public void setId(long id) {
////        Validate.isTrue(id > 0);
//        this.id = id;
//    }
//
//    /**
//     * @return the opportunityTitle
//     */
//    public String getOpportunityTitle() {
//        return opportunityTitle;
//    }
//
//    /**
//     * @param opportunityTitle the opportunityTitle to set
//     */
//    public void setOpportunityTitle(String opportunityTitle) {
//
////        Validate.notNull(opportunityTitle, "Title must not be null");
////        Validate.notBlank(opportunityTitle,"Title must not be Blank");
////        Validate.inclusiveBetween(0, 150, opportunityTitle.length(), "Title length must be between 0 and 150 Characters ");
//
//        this.opportunityTitle = opportunityTitle;
//    }
//
//    /**
//     * @return the startDate
//     */
//    public String getStartDate() {
//        return startDate;
//    }
//
//    /**
//     * @param startDate the startDate to set
//     */
//    public void setStartDate(String startDate) {
//
//        this.startDate = startDate;
//    }
//
//    /**
//     * @return the duration
//     */
//    public Integer getDuration() {
//        return duration;
//    }
//
//    /**
//     * @param duration the duration to set
//     */
//    public void setDuration(Integer duration) {
//
//        this.duration = duration;
//    }
//
//    /**
//     * @return the durationUnits
//     */
//    public String getDurationUnits() {
//        return durationUnits;
//    }
//
//    /**
//     * @param durationUnits the durationUnits to set
//     */
//    public void setDurationUnits(String durationUnits) {
//        this.durationUnits = durationUnits;
//    }
//
//    /**
//     * @return the value
//     */
//    public BigDecimal getValue() {
//        return value;
//    }
//
//    /**
//     * @param value the value to set
//     */
//    public void setValue(BigDecimal value) {
//        this.value = value;
//    }
//
//    /**
//     * @return the valueUnits
//     */
//    public String getValueUnit() {
//        return valueUnits;
//    }
//
//    /**
//     * @param valueUnits the value to set
//     */
//    public void setValueUnit(String valueUnits) {
//        this.valueUnits = valueUnits;
//    }
