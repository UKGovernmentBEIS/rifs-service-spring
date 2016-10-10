package uk.gov.rifs.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.rifs.business.model.Application;
import uk.gov.rifs.business.model.Opportunity;
import uk.gov.rifs.business.service.OpportunityService;

import java.util.List;

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

        return new ResponseEntity<>(opps, HttpStatus.OK);
    }

    @RequestMapping(value="/open/summaries", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Opportunity>> getOpportunitySummries() {

        List<Opportunity> opps = opportunityService.getAllSummaries();

        return new ResponseEntity<>(opps, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Opportunity> getSingleOpportunity(@PathVariable("id") long id) {

        Opportunity opp = opportunityService.getOpportunity(id);

        return new ResponseEntity<>(opp, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}/application", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Application> getInitialOpportunityApplication(@PathVariable("id") long id) {

        Application app = opportunityService.getOpportunityApplication(id);

        return new ResponseEntity<>(app, HttpStatus.OK);
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
