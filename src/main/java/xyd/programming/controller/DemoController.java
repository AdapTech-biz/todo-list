package xyd.programming.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyd.programming.model.TodoData;
import xyd.programming.service.DemoService;

@Slf4j
@Controller
public class DemoController {

    // == Fields ==
    public final DemoService demoService;
    public final TodoData todoData;

    // == Constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
        this.todoData = new TodoData();
    }

    // == Request methods ==

    // http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
       return todoData.getItem(1).toString();
//        return "hello"; //resolves a view without the ResponseBody annotation
//        return todoData.getItems().toString();
    }

    // http://localhost:8080/todo-list/welcome?user=Xavier&age=27
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam int age, Model model) {
        model.addAttribute("helloMessage", demoService.getWelcomeMessage(user));
        model.addAttribute("age", age);
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
