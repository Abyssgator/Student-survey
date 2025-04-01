/* 
<!-- Team Members
 Name: Ashrith Bhooka Ravinandan
 Gno. G01455956

 Name:Rishith Reddy Pendli
 Gno. G01411978

 Name: Sathwik Reddy Bojja
 Gno. G01461462 
 
 This file has all the api are declared and crud operations are executed after the api calls are invoked.
 -->
*/

package com.swesurvey.surveybackend;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

//import com.swesurvey.surveybackend.service.SurveyService;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api")
public class SurveybackendController {
	
    private final SurveyBackendRepo backendRepository;

@Autowired
public SurveybackendController(SurveyBackendRepo backendRepository) {
    this.backendRepository = backendRepository;
}

@GetMapping("/index")
public String getIndex(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name,Model model) {
	model.addAttribute("name", name);
	return "index";
}

@PostMapping(path = "/uploadData",consumes = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public ResponseEntity<JSONResponse> uploadData(@RequestBody SurveyModel model) {
	System.out.println(model.getFirstName());
	backendRepository.save(model);
			return ResponseEntity.ok(new JSONResponse("Survey data created successfully."));
}


@PutMapping(path = "/updateData/{id}")
@ResponseBody
public ResponseEntity<JSONResponse> updateData(@PathVariable long id, @RequestBody SurveyModel surveyModel) {
    SurveyModel model = backendRepository.findById(id).orElse(null);
    if (model != null) {
        // Update fields
        model.setFirstName(surveyModel.getFirstName());
        model.setLastName(surveyModel.getLastName());
        model.setStreetAddress(surveyModel.getStreetAddress());
        model.setCity(surveyModel.getCity());
        model.setState(surveyModel.getState());
        model.setZip(surveyModel.getZip());
        model.setTelephone(surveyModel.getTelephone());
        model.setEmail(surveyModel.getEmail());
        model.setDateOfSurvey(surveyModel.getDateOfSurvey());
        model.setLikedMost(surveyModel.getLikedMost());
        model.setInterestedBy(surveyModel.getInterestedBy());
        model.setLikelihood(surveyModel.getLikelihood());
        model.setComments(surveyModel.getComments());

        backendRepository.save(model);  // Save the updated survey
        return ResponseEntity.ok(new JSONResponse("Survey data updated successfully."));
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Survey with id " + id + " not found."));
    }
}

@GetMapping("/getData")
public @ResponseBody List<SurveyModel> getData(SurveyModel model){
	List<SurveyModel> surveyList = backendRepository.findAll();
	return surveyList;
}
    
@DeleteMapping("/deleteData/{id}")
public ResponseEntity<String> deleteSurvey(@PathVariable Long id) {
    if (!backendRepository.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Survey with ID " + id + " does not exist.");
    }
    
    backendRepository.deleteById(id); // Deletes the survey by ID
    return ResponseEntity.ok("Survey deleted successfully.");
}
@GetMapping("/getData/{id}")
public ResponseEntity<SurveyModel> getSurveyById(@PathVariable Long id) {
    Optional<SurveyModel> survey = backendRepository.findById(id);
    if (survey.isPresent()) {
        return ResponseEntity.ok(survey.get());
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}


}
