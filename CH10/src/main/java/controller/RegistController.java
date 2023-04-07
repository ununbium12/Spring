package controller;

import chapter10.DuplicationMemberException;
import chapter10.MemberRegisterService;
import chapter10.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegistController {

    @RequestMapping("/step1")
    public String handleStep1() {
        System.out.println("step1 >>>");
        return "register/step1";
    }

//    @RequestMapping("/step2")
//    public String handleStep2(HttpServletRequest request) { // HttpServletRequest 이용
//        System.out.println("step2 >>>");
//        String agree = request.getParameter("agree");
//        System.out.println("step2::agree" + agree);
//        if (agree == null || !agree.equals("true")) {
//            return "register/step1";
//        }
//        return "register/step2";
//    }

    @RequestMapping("/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree
    , Model model) { // @RequestParam 어노테이션 이용
        System.out.println("step2 >>>");
        System.out.println("step2::agree " + agree);
        if (agree == null || !agree) {
            return "redirect:/register/step1";
        }
        model.addAttribute("registerRequest",new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/step2")
    public String handleStep2Get() {
        System.out.println("[GET] step2 >>>");
    return "redirect:/register/step1";
}
//    @RequestMapping("/step3")
//    public String handleStep3() {
//        return "register/step3";
//    }

//    @PostMapping("/step3")
//    public String handleStep3(HttpServletRequest request) {
//        System.out.println("[POST] step3 >>>");
//        String email = request.getParameter("email");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        String confirmPassword = request.getParameter("confirmPassword");
//
//        RegisterRequest regReq = new RegisterRequest();
//        regReq.setEmail(email);
//        regReq.setName(name);
//        regReq.setPassword(password);
//        regReq.setConfirmPassword(confirmPassword);
//        try {
//            memberRegisterService.regist(regReq);
//            return "register/step3";
//        } catch (DuplicationMemberException ex) {
//            return "register/step2";
//        }
//    }

    @Autowired
    private MemberRegisterService memberRegisterService;

    @PostMapping("/step3")
    public String handleStep3(@ModelAttribute("forData") RegisterRequest registerRequest) {
        System.out.println("[POST] step3 >>>");
        try {
            memberRegisterService.regist(registerRequest);
            return "register/step3";
        } catch (DuplicationMemberException ex) {
            return "register/step2";
        }
    }
}
