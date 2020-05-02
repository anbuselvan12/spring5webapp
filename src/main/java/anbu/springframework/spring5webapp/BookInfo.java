package anbu.springframework.spring5webapp;

import java.util.Date;

import javax.validation.constraints.Size;

public class BookInfo {

	private Long id;
	@Size(min=4, message="Enter at least 4 Characters...")
    private String title;
	@Size(min=4, message="Enter at least 4 Characters...")
    private String isbn;
	@Size(min=5, message="Enter at least 5 Characters...")
    private String publisher;
    private double amount;
    private Date date;
    
    public BookInfo() {
		// TODO Auto-generated constructor stub
	}	
    
    public BookInfo(Long id,String title,String isbn, String publisher, double amount,Date date) {
    	this.id =id;
    	this.title = title;
    	this.isbn =isbn;
    	this.publisher = publisher;
    	this.amount = amount;
    	this.date = date;
	}	
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
    
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id.intValue();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BookInfo other = (BookInfo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "BookInfo [title=%s, isbn=%s, publisher=%s, amount=%f,date=%s]", title,
                isbn, publisher, amount,date);
    }
}
