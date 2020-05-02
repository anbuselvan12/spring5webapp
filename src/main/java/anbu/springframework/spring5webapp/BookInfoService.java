package anbu.springframework.spring5webapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookInfoService {
	
	static List<BookInfo> bookInfos = new ArrayList<BookInfo>();
	 private static Long todoCount = 4L;
	static {
		bookInfos.add(new BookInfo(1L,"C", "123456", "Mc hill", 390.00,new Date()));
		bookInfos.add(new BookInfo(2L,"anbu", "123456", "Mc hill", 390.00,new Date()));
		bookInfos.add(new BookInfo(3L,"C++", "123457", "Mc hill", 395.00,new Date()));
		bookInfos.add(new BookInfo(4L,"Java", "123458", "Sun micro System", 396.00,new Date()));
	}
	
	public List<BookInfo> retriveBooks(String name ){
		
		return bookInfos.stream().filter(p -> p.getTitle().equalsIgnoreCase(name)).map(p1-> p1).collect(Collectors.toList());
	}
	
	public void addBook(String title,String isbn,String publisher,double amount,Date date) {
		//Long value = bookInfos.stream().max(Comparator.comparing(BookInfo::getId)).get().getId();
		bookInfos.add(new BookInfo(++todoCount,title, isbn, publisher, amount,date));
	}
	
	public void removeBook(Long id) {
		
		List<BookInfo> book = bookInfos.stream().filter(p ->p.getId().equals(id) ).map(p1 ->p1).collect(Collectors.toList());
		if(book != null && !book.isEmpty() ) {
			bookInfos.removeAll(book);
		}
	}
	
	public BookInfo retrieveTodo(Long id ) {
		
		return bookInfos.stream().filter(p ->p.getId().equals(id)).map(p ->p).findFirst().get();
		
		
	}

	public void updateBook(BookInfo bookInfo) {
		bookInfos.remove(bookInfo);
		bookInfos.add(bookInfo);
	}

}
