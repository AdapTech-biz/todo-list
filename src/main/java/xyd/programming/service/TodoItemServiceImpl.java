package xyd.programming.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import xyd.programming.model.TodoData;
import xyd.programming.model.TodoItem;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Getter //using lombok to provide getter method
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem toAdd) {
        data.addItems(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem updatedItem) {
        data.updateItem(updatedItem);
    }

}
