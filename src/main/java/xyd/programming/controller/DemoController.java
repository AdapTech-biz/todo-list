package xyd.programming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import xyd.programming.service.DemoService;

@Slf4j
@Controller
public class DemoController {

    // == Fields ==
    public final DemoService demoService;

    // == Constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == Request methods ==

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello"; //resolves a view without the ResponseBody annotation
    }

    // http://localhost:8080/todo-list/welcome
    @GetMapping("welcome")
    public String welcome(Model model) {
        model.addAttribute("helloMessage", demoService.getWelcomeMessage("Xavier"));
        log.info("model = {}", model);
        return "welcome";
    }


    // == Model Attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("Welcome Message () called");
        return demoService.getWelcomeMessage();
    }
}
