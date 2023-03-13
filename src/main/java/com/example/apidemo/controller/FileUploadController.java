package com.example.apidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FileUploadController {
    @GetMapping("/fileForm")
    public ModelAndView fileForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/fileForm");
        return mv;
    }
}
