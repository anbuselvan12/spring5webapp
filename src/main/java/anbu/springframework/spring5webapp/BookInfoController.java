package anbu.springframework.spring5webapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class BookInfoController {
	
	@Autowired
	private BookInfoService bookInfoService;
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value ="/books", method = RequestMethod.GET)
	public String retrieveBookInfo (ModelMap map) {
		
		String name = getLoggedInUserName(map);
		map.put("books",bookInfoService.retriveBooks(name));
		
		return "books";
		
	}
	/*
	 * private String getLoggedInUserName(ModelMap model) { return (String)
	 * model.get("name"); }
	 */
	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
	@RequestMapping(value ="/add-to-book",method = RequestMethod.GET)
	public String showAddedBook(ModelMap map) {
		map.addAttribute("bookInfo", new BookInfo(5L, (String) map.get("title"), "isbn","publisher", 0.0,new Date()));
		return "book";
	}
	
	@RequestMapping(value ="/add-to-book",method = RequestMethod.POST)
	public String addToBook(ModelMap map,@Valid BookInfo bookInfo,BindingResult result) {
		

		if(result.hasErrors()){
			return "book";
		}
		
		bookInfoService.addBook(bookInfo.getTitle(), bookInfo.getIsbn(), bookInfo.getPublisher(), bookInfo.getAmount(),new Date());
		
		return "redirect:/books";
		
	}
	
	@RequestMapping(value = "/delete-book", method = RequestMethod.GET)
	public String deleteBook(ModelMap map , @RequestParam Long id) {
		
		    bookInfoService.removeBook(id);
		    
		    return "redirect:/books";
		    
		
	}
	
	@RequestMapping(value = "/update-book", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam Long id, ModelMap model) {
		BookInfo bookInfo = bookInfoService.retrieveTodo(id);
		model.put("bookInfo", bookInfo);
		return "book";
	}

	@RequestMapping(value = "/update-book", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid BookInfo book, BindingResult result) {

		if (result.hasErrors()) {
			return "book";
		}
		
		book.setId((Long) model.get("id"));
		
		bookInfoService.updateBook(book);

		return "redirect:/books";
	}
	
	

}
