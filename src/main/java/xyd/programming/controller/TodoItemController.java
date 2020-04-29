package xyd.programming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import xyd.programming.model.TodoData;
import xyd.programming.util.Mappings;
import xyd.programming.util.ViewNames;

@Controller
public class TodoItemController {

    // == Model Attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // == Mappings ==
    //http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
