package uk.gov.rifs.business.entity;

import javassist.expr.Instanceof;

import javax.persistence.*;
import java.lang.Comparable;

/**
 * Created by bendishman on 06/10/2016.
 */
@Entity
@Table(name = "paragraph")
public class ParagraphDB implements Comparable <ParagraphDB> {

        @Id
        @GeneratedValue(strategy= GenerationType.SEQUENCE)
        @Column(name = "id")
        private long id;

        @Column(name = "section_id")
        private long sectionId;

        @Column(name = "paragraph_number")
        private long paragraphNumber;

        @Column(name = "text")
        private String description;

        /**
         * Constructor with domain attributes
         * @param sectionId
         * @param paragraphNumber
         * @param description
         */
        public ParagraphDB(long sectionId, long paragraphNumber, String description) {
            super();
            this.sectionId = sectionId;
            this.paragraphNumber = paragraphNumber;
            this.description = description;
        }

        public ParagraphDB()
        {}

        public int compareTo (ParagraphDB otherParagraph)
        {
            return (int) (this.getParagraphNumber() - otherParagraph.getParagraphNumber());
        }

    /**
         * @return the id
         */
        public Long getId() {
            return this.id;
        }

        public String getDescription() {
            return this.description;
        }

        public Long getSectionId() {
            return this.sectionId;
        }

        public Long getParagraphNumber() {
            return this.paragraphNumber;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setSectionId(Long sectionId) {
            this.sectionId = sectionId;
        }

        public void setParagraphNumber(Long paragraphNumber) {
            this.paragraphNumber = paragraphNumber;
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
