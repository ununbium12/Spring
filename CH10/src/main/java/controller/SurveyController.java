package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import survey.SurveyRegisterService;

import javax.validation.Valid;

@Controller
public class SurveyController {

    private SurveyRegisterService surveyRegisterService;

    public void setSurveyController(SurveyRegisterService surveyRegisterService) {
        this.surveyRegisterService = surveyRegisterService;
    }

    // 설문조사 페이지 요청 처리
    @GetMapping("/survey")
    public String surveyForm() {
        return "survey/surveyForm";
    }

    // 설문조사 제출 처리
    @PostMapping("/survey")
    public String submitSurvey(@ModelAttribute("surveyCommand") @Valid SurveyCommand surveyCommand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "survey/surveyForm";
        }

        surveyRegisterService.register(surveyCommand);

        return "survey/submitComplete";
    }
}
