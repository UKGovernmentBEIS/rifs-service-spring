package uk.gov.rifs.business.service;

import uk.gov.rifs.business.model.Application;
import uk.gov.rifs.business.model.Opportunity;

import java.util.List;

public interface OpportunityService {

    Opportunity getOpportunity(long id);

    List<Opportunity> getAllOpportunities();

    List<Opportunity> getAllSummaries();

    /** Gets an Application - will move to Application controller if we use it I guess but currently copying the existing format  **/
    Application getOpportunityApplication(long id);

}
