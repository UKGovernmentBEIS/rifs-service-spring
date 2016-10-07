package uk.gov.rifs.business.service;

import java.util.List;
import java.util.*;

import uk.gov.rifs.business.entity.OpportunityDB;
import uk.gov.rifs.business.entity.ParagraphDB;
import uk.gov.rifs.business.entity.SectionDB;

import uk.gov.rifs.business.model.Opportunity;
import uk.gov.rifs.business.model.Description;
import uk.gov.rifs.business.model.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.rifs.business.repository.OpportunityRepository;
import uk.gov.rifs.business.repository.ParagraphRepository;
import uk.gov.rifs.business.repository.SectionRepository;

import java.util.List;
import java.util.stream.*;
import java.util.function.*;
import java.util.stream.Collectors.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Created by bendishman on 06/10/2016.
 */
@Service("opportunityService")
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED)
public class OpportunityServiceImpl  implements OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private ParagraphRepository paragraphRepository;

    @Autowired
    private SectionRepository sectionRepository;
    /** Gets a list of all Opportunities **/
    @Override
    @Transactional(readOnly = true)
    public List<Opportunity> getAllOpportunities() {

        List<OpportunityDB> opportunities = opportunityRepository.findAll();
        List<Opportunity> opportunityModels = new ArrayList<Opportunity>();

        for (OpportunityDB opportunity : opportunities) {
            //Value v = new Value(opportunity.getValueUnit(), opportunity.getValue().doubleValue());
            Opportunity opportunityModel = new Opportunity();
            opportunityModel.setId(opportunity.getId());
            opportunityModel.setTitle(opportunity.getOpportunityTitle());
            opportunityModel.setStartDate(opportunity.getStartDate());
            opportunityModel.setValue(new Value(opportunity.getValueUnit(), opportunity.getValue().doubleValue()));
            List<Description> descriptions = new ArrayList<>();

            for (SectionDB s : opportunity.getSectionDB())
            {
                //convert to a stream!
                //sort by
//                List<String> paras = new ArrayList <> ();
//                for (ParagraphDB p : s.getParagraphDB())
//                {
//                    //p.getParagraphNumber();
//                    paras.add(p.getDescription());
//                }
                List<String> paras = s.getParagraphDB().stream().sorted().map(ParagraphDB::getDescription).collect(Collectors.toList());

                Description d = new Description(s.getSectionNumber(), s.getSectionTitle(), paras);
                descriptions.add(d);
            }

            opportunityModel.setDescription(descriptions);
            opportunityModels.add(opportunityModel);
        }

        return opportunityModels;
    }

    /** Gets an Opportunity by id **/
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


        for (SectionDB s : opportunity.getSectionDB())
        {
            List<String> paras = s.getParagraphDB().stream().sorted().map(ParagraphDB::getDescription).collect(Collectors.toList());

            Description d = new Description(s.getSectionNumber(), s.getSectionTitle(), paras);
            descriptions.add(d);
        }

//Get it working and then convert this for into a stream operation (and maybe even the outer loop!)
//        opportunity.getSectionDB().stream().map(s -> s)
//                .forEach(descriptions.add(new Description(SectionDB::getSectionNumber, SectionDB::getSectionTitle(), SectionDB::getParagraphDB().stream().sorted().map(ParagraphDB::getDescription).collect(Collectors.toList()))));

        opportunityModel.setDescription(descriptions);

        return opportunityModel;
    }

    /** Gets a list of all Opportunities **/
    @Override
    @Transactional(readOnly = true)
    public List<Opportunity> getAllSummaries() {

        List<OpportunityDB> opportunities = opportunityRepository.findAll();
        List<Opportunity> opportunityModels = new ArrayList<Opportunity>();

        for (OpportunityDB opportunity : opportunities) {

            Opportunity opportunityModel = new Opportunity();
            opportunityModel.setId(opportunity.getId());
            opportunityModel.setTitle(opportunity.getOpportunityTitle());
            opportunityModel.setStartDate(opportunity.getStartDate());
            opportunityModel.setValue(new Value(opportunity.getValueUnit(), opportunity.getValue().doubleValue()));

            opportunityModels.add(opportunityModel);
        }

        return opportunityModels;
    }

}

