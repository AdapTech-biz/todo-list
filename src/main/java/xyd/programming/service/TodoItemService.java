package xyd.programming.service;

import xyd.programming.model.TodoData;
import xyd.programming.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem toAdd);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem updatedItem);
    TodoData getData();
}
