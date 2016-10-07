package uk.gov.rifs.business.service;

import java.util.*;

import uk.gov.rifs.business.entity.OpportunityDB;
import uk.gov.rifs.business.entity.ParagraphDB;
import uk.gov.rifs.business.entity.SectionDB;

import uk.gov.rifs.business.model.Opportunity;
import uk.gov.rifs.business.model.Description;
import uk.gov.rifs.business.model.Value;

/**
 * Created by bendishman on 06/10/2016.
 */
public interface OpportunityService {

    /** Gets an Opportunity Response by id **/
    Opportunity getOpportunity(long id);

    /** Gets a list of all Opportunities **/
    List<Opportunity> getAllOpportunities();

    /** Gets a list of all Opportunities **/
    List<Opportunity> getAllSummaries();

}
