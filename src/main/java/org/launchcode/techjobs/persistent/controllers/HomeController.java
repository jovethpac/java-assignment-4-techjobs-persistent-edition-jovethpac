package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController { //the HomeController is essentially the JobController, we need to add a field calld employerRepository annotate with @Autowired, maybe need to create a jobrepository...add emptyconstructor
    //exactly what we did in dinomvc  need to find add jobs form    ask Pearce which part of dino-mvc this corresponds to..review DinoEgg Controller..ignore section #3 and #4

    @Autowired
    private EmployerRepository employerRepository; //employerRepository is a variable I just made up

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        return "add";
    }

    @PostMapping("add")//saves a valid Job object
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model) {//I removed the Request parameters

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }
//Part 3...this is in place of section 3 and 4. use the jobRepository to save our newJob to the database

        jobRepository.save(newJob);  //can't get rid of red squiggly, Ive added @AutoWired JobRepository in EmployerController and HomeController
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

        return "view";
    }


}
