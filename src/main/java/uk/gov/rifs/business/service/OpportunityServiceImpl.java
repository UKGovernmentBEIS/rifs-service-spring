package uk.gov.rifs.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.rifs.business.entity.ApplicationDB;
import uk.gov.rifs.business.entity.OpportunityDB;
import uk.gov.rifs.business.entity.ParagraphDB;
import uk.gov.rifs.business.entity.SectionDB;
import uk.gov.rifs.business.model.*;
import uk.gov.rifs.business.repository.ApplicationRepository;
import uk.gov.rifs.business.repository.OpportunityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("opportunityService")
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED)
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

//    @Autowired
//    private ParagraphRepository paragraphRepository;
//
//    @Autowired
//    private SectionRepository sectionRepository;

    /**
     * Gets a list of all Opportunities
     **/
    @Override
    @Transactional(readOnly = true)
    public List<Opportunity> getAllOpportunities() {

        List<OpportunityDB> opportunities = opportunityRepository.findAll();

//        for (OpportunityDB opportunity : opportunities) {
//            System.out.println ("Size = " + opportunity.getSectionDB().size());
//        }

        return opportunities.stream().map
                (o -> new Opportunity
                        (o.getId(), o.getOpportunityTitle(), o.getStartDate(), o.getValueUnit(), o.getValue().doubleValue(),
                                o.getSections().stream().map
                                        (d -> new Description(d.getSectionNumber(), d.getSectionTitle(), d.getParagraphDB().stream().sorted().map(ParagraphDB::getDescription).collect(Collectors.toList()))).collect(Collectors.toList())
                        )
                ).collect(Collectors.toList());

    }

    /**
     * Gets an Opportunity by id
     **/
    @Override
    @Transactional(readOnly = true)
    public Opportunity getOpportunity(long id) {

        OpportunityDB opportunity = opportunityRepository.findOne(id);

        Opportunity opportunityModel = new Opportunity();
        opportunityModel.setId(opportunity.getId());
        opportunityModel.setTitle(opportunity.getOpportunityTitle());
        opportunityModel.setStartDate(opportunity.getStartDate());
        opportunityModel.setValue(new Value(opportunity.getValueUnit(), opportunity.getValue().doubleValue()));
        List<Description> descriptions = new ArrayList<>();

        //System.out.println ("Size = " + opportunity.getSectionDB().size());
        List<Long> sectionsProcessed = new ArrayList<>();

        for (SectionDB s : opportunity.getSections()) {
            //System.out.println ("IN the Section loop.  Sectionid = " + s.getSectionNumber());
            //Bug return 1 is reeturn some kind of cartesian join - temp 'fix'
            if (!sectionsProcessed.contains(s.getId())) {

                List<String> paras = s.getParagraphDB().stream().sorted().map(ParagraphDB::getDescription).collect(Collectors.toList());
                Description d = new Description(s.getSectionNumber(), s.getSectionTitle(), paras);
                descriptions.add(d);

                sectionsProcessed.add(s.getId());
            }
        }

        /* USE to iunvestigate bug
                 for (SectionDB s : opportunity.getSections())
        {
                //List<String> paras = s.getParagraphDB().stream().sorted().map(ParagraphDB::getDescription).collect(Collectors.toList());
                for (ParagraphDB p : s.getParagraphDB())
                {
                    Description d = new Description(s.getSectionNumber(), s.getSectionTitle(), null);
                    descriptions.add(d);
                }

        }

         */

        opportunityModel.setDescription(descriptions);

        return opportunityModel;
    }

    /**
     * Gets a list of all Opportunities
     **/
    @Override
    @Transactional(readOnly = true)
    public List<Opportunity> getAllSummaries() {

        List<OpportunityDB> opportunities = opportunityRepository.findAll();
        final List<Description> descriptions = new ArrayList<>();

        return opportunities.stream().map
                (o -> new Opportunity(o.getId(), o.getOpportunityTitle(), o.getStartDate(), o.getValueUnit(), o.getValue().doubleValue(), descriptions)
                ).collect(Collectors.toList());
    }

    /**
     * Gets an Application by id
     **/
    @Override
    @Transactional(readOnly = true)
    public Application getOpportunityApplication(long id) {

        ApplicationDB application = applicationRepository.findOne(id);

        Application applicationModel = new Application();
        applicationModel.setId(application.getId());
        applicationModel.setOpportunityId(application.getOpportunityId());

        applicationModel.setSections(
                application.getSections().stream().map(
                        as -> new ApplicationSection(as.getSectionNumber(), as.getTitle(), as.isStarted())
                ).collect(Collectors.toList())
        );

        return applicationModel;
    }


}

