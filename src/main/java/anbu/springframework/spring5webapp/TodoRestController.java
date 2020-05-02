package anbu.springframework.spring5webapp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TodoRestController {
    @Autowired
    private BookInfoService service;

    @RequestMapping(value = "/rest/books", method = RequestMethod.GET)
    public List<BookInfo> listAllTodos() {
        List<BookInfo> books = service.retriveBooks("anbu");
        return books;
    }

    @RequestMapping(value = "/rest/books/{id}", method = RequestMethod.GET)
    public BookInfo retrieveTodo(@PathVariable("id") Long id) {
        return service.retrieveTodo(id);
    }
}