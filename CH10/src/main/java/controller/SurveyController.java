package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import survey.Survey;
import survey.SurveyDao;
import survey.SurveyRegisterService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    private SurveyRegisterService surveyRegisterService;


    @Autowired
    public SurveyController(SurveyRegisterService surveyRegisterService) {
        this.surveyRegisterService = surveyRegisterService;
    }

    @GetMapping("/surveyForm")
    public String surveyForm(Model model) {
        model.addAttribute("surveyCommand", new SurveyCommand());
        return "survey/surveyForm";
    }

    @PostMapping("/surveyForm")
    public String handleSurveyFormPost(
            @ModelAttribute("surveyCommand") @Valid SurveyCommand surveyCommand, Errors errors) {
        if (errors.hasErrors()) {
            return "/survey/surveyForm";
        }
        surveyRegisterService.update(surveyCommand);
        return "redirect:/survey/surveyComplete";
    }

    @PostMapping("/surveyComplete")
    public String surveyComplete(@Valid @ModelAttribute("surveyCommand") SurveyCommand surveyCommand, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "survey/surveyForm";
        }
        Survey survey = new Survey(surveyCommand);
        surveyDao.insert(survey);
        model.addAttribute("surveyCommand", surveyCommand);
        return "survey/surveyComplete";
    }

    @Autowired
    private SurveyDao surveyDao;

    @RequestMapping(value = "/surveyList")
    public ModelAndView list() {
        List<Survey> list = surveyDao.selectAll();
        ModelAndView mav = new ModelAndView("survey/surveyList");
        mav.addObject("list", list);
        return mav;
    }
}
