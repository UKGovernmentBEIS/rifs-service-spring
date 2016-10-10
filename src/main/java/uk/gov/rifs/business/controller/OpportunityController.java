package uk.gov.rifs.business.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uk.gov.rifs.business.repository.OpportunityRepository;
import uk.gov.rifs.business.entity.OpportunityDB;

import uk.gov.rifs.business.repository.ParagraphRepository;
import uk.gov.rifs.business.entity.ParagraphDB;

import uk.gov.rifs.business.repository.SectionRepository;
import uk.gov.rifs.business.entity.SectionDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

import java.util.List;

import uk.gov.rifs.business.service.OpportunityService;
import uk.gov.rifs.business.model.Opportunity;
import uk.gov.rifs.business.model.Application;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

//    @Autowired
//    private OpportunityRepository opportunityRepository;
//
//    @Autowired
//    private ApplicationRepository applicationRepository;

    @Autowired
    private OpportunityService opportunityService;

    @RequestMapping(value="/open", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Opportunity>> getAllOpportunities() {

        List<Opportunity> opps = opportunityService.getAllOpportunities();

        return new ResponseEntity<List<Opportunity>>(opps, HttpStatus.OK);
    }

    @RequestMapping(value="/open/summaries", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Opportunity>> getOpportunitySummries() {

        List<Opportunity> opps = opportunityService.getAllSummaries();

        return new ResponseEntity<List<Opportunity>>(opps, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Opportunity> getSingleOpportunity(@PathVariable("id") long id) {

        Opportunity opp = opportunityService.getOpportunity(id);

        return new ResponseEntity<Opportunity>(opp, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/application", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> getInitialOpportunityApplication(@PathVariable("id") long id) {

        Application app = opportunityService.getOpportunityApplication(id);

        return new ResponseEntity<Application>(app, HttpStatus.OK);
    }

//    @RequestMapping("/paragraph")
//    public List<ParagraphDB> getParagraphTest() {
//
//        System.out.println("in here at point 2");
//        return paragraphRepository.findAll();
//    }
//
//    @RequestMapping("/section")
//    public List<SectionDB> getSectionTest() {
//
//        System.out.println("in here at point 3");
//        return sectionRepository.findAll();
//    }
}
