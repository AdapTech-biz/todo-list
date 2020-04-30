package xyd.programming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {

    private int id;
    private LocalDate deadline;
    private String description;
    private String title;

    public TodoItem(LocalDate deadline, String description, String title) {
        this.deadline = deadline;
        this.description = description;
        this.title = title;
    }
}
