package com.example.countchars;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String get(SampleForm form, Model model) {
        model.addAttribute("sample", form);
        return "sample";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String post(@ModelAttribute("sample") @Validated SampleForm form, BindingResult result, Model model) {
        System.out.println("***** POST");
        System.out.println(form.getText());
        System.out.println("*****");
        if (result.hasErrors()) {
            System.out.println("***** ERROR");
        }
        return get(form, model);
    }
}
