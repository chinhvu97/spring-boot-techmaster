package com.tiki.bookstore.controller;

import com.tiki.bookstore.request.BMIrequest;
import com.tiki.bookstore.response.BMIresponse;
import com.tiki.bookstore.service.BMIService;
import com.tiki.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bmi")
public class BMIController {
    @Autowired
    private BMIService bmiService;
    @GetMapping()
    public String getBMIData(Model model) {
        model.addAttribute("bmiRequest", new BMIrequest());
        model.addAttribute("bmiResult", null);
        return "bmi";
    }

    @PostMapping()
    public String handleBMIData(@ModelAttribute BMIrequest request, BindingResult bindingResult, Model model) {
        BMIresponse response = null;
        if (bindingResult.hasErrors()){
            System.out.println("There was error");
        } else {
            response = bmiService.cal(request);
        }
        model.addAttribute("bmiRequest", request);
        model.addAttribute("bmiResult", response);
        return "bmi";
    }
}
