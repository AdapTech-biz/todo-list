package xyd.programming.model;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;

@Slf4j
public class TodoData {

    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    // === Constructor ==

    public TodoData() {
        addItems(new TodoItem(LocalDate.now(), "Description", "First Item"));
        addItems(new TodoItem(LocalDate.now(), "Description", "Second Item"));
        addItems(new TodoItem(LocalDate.now(), "Description", "Third Item"));
    }

    // == Public Methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItems(TodoItem toAdd) {
        //Using optional to see if null
        Optional<TodoItem> newItem = Optional.of(toAdd);
        newItem.ifPresent((item) -> {
            item.setId(idValue);
            items.add(item);
            idValue++;
        });
    }

    public void removeItem(int id) {
        log.debug("TodoData.removeItem() -> {}", items.toString());
        items.removeIf(item -> item.getId() == id);
        log.debug("TodoData.removeItem() after Stream Operation-> {}", items.toString());
    }

    public TodoItem getItem(int id) {
       return items.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
    }

    public void updateItem(TodoItem toUpdate) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();

        while (itemListIterator.hasNext()){

           TodoItem todoItem = itemListIterator.next();

          if(todoItem.equals(toUpdate)) {
              itemListIterator.set(toUpdate);
              break;
          }
        }
    }
}
