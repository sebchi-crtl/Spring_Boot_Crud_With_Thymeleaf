package com.example.thyme.controller;

import com.example.thyme.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping(value = "/testing")
public class PersonController {

    @GetMapping
    public String sayHello(Model model)
    {
        model.addAttribute("word", "Hello Word");
        model.addAttribute("people", Arrays.asList(
                new Person(
                        100022,
                        "Nelson Ebere",
                        19
                ),
                new Person(
                        100023,
                        "sam Chuks",
                        29
                ),
                new Person(
                        100024,
                        "Maria Mike",
                        24
                ),
                new Person(
                        100025,
                        "Boot Hurt",
                        27
                )
        ));

        return "hello";
    }

}
