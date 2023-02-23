package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {

    @Autowired
    private EmployerRepository employerRepository; //employerRepository is a variable I just made up

    @Autowired
    private JobRepository jobRepository;


    //name an index  method, do I need to use paramenters what view do I need? pass in a list of all the employers in the database add model.addAttribute  use Model, mode.  what should I name my model attribute?
    //employer : ${employers} is based on index.html  what is the attribute and collection (look at dino mvc as well), look at their index and controller
    @GetMapping
    public String index (Model model){
        model.addAttribute("employers", employerRepository.findAll());
        return "employers/index";
    }


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")//saves a valid Employer object
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        //Use the employerRepository to save our newEmployer to the database (look at dinomvc example)

        employerRepository.save(newEmployer);
        return "redirect:";
    }

    @GetMapping("view/{employerId}")  //different from what we've seen. only need to change 1 thing..only used to view an individual employer object  findbyID takes in
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        //use the findByID method of the employerRepository along with the employerID parameter to get a specific single employer from the database    usesomethinglike findByID(employerID)??
        Optional optEmployer = employerRepository.findById(employerId);  //change null to a different method
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
