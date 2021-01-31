import java.util.ArrayList;

public class Library 
{
	// Add the missing implementation to this class
	private String address;
	private ArrayList<Book> books;
	public static final String OPENINGTIME = "9am";
	public static final String CLOSINGTIME = "5pm";
	
	public Library(String address) 
	{
		this.address = address;
		books = new ArrayList<Book>();
	}
	
	private static void printOpeningHours() 
	{
		System.out.println("Libraries are open daily from " + OPENINGTIME + " to " + CLOSINGTIME + ".");
	}
	
	private void printAddress() 
	{
		System.out.println(this.address);
	}
	
	public void addBook(Book book) 
	{
		books.add(book);
	}
	
	private void borrowBook(String bookTitle) 
	{
		boolean bookPresent = false;
		
		//loop through all the books in the catalog
		for(int i=0; i<books.size(); i++)
		{
			//check each book title and compare to the book to be borrowed
			if(books.get(i).getTitle().equals(bookTitle))
			{
				//if book is found, check the borrowed status. If book is borrowed, update user and break out of the loop, no need to continue. 
				if(books.get(i).isBorrowed())
				{
					System.out.println("Sorry, this book is already borrowed.");
					bookPresent = true;
					break;
				}
				//if book is not borrowed, allow user to borrow, then update book status to reflect same. After break from the loop, no need to continue.
				else
				{
					System.out.println("You succesfully borrowed " + bookTitle);
					books.get(i).borrowed();
					bookPresent = true;
					break;
				}
			}
		}
		//if book is not present in our library, update user that book is not in our catalog.
		if(!bookPresent)
			System.out.println("Sorry, this book is not in our catalog.");
	}
	
	
	private void printAvailableBooks() 
	{
		//check if there are books in the library, if not update user
		if(books.size()==0)
			System.out.println("No book in catalog");
		
		//if there are books, loop through all of them
		for(int i=0; i<books.size(); i++)
		{
			//check if book is borrowed, and get title of only those are are not borrowed.
			if(!books.get(i).isBorrowed())
				System.out.println(books.get(i).getTitle());
		}
	}
	
	private void returnBook(String bookTitle) 
	{
		boolean bookPresent = false;
		
		//loop through all the books in the catalog.
		for(int i=0; i<books.size(); i++)
		{
			//check each book title and compare to the book to be returned.
			if(books.get(i).getTitle().equals(bookTitle))
			{
				//if book is found, check the borrowed status. If book is borrowed, accept the book and break out of the loop, no need to continue. 
				if(books.get(i).isBorrowed())
				{
					System.out.println("You successfully returned " + bookTitle);
					books.get(i).returned();
					bookPresent = true;
					break;
				}
				else
				{
					//else if book is not borrowed, update the user and break out of the loop, no need to continue.
					System.out.println("This book was not borrowed.");
					bookPresent = true;
					break;
				}
			}
		}
		//if book is not found in the library, update the user that book is not in the catalog.
		if(!bookPresent)
			System.out.println("Sorry, this book is not in our catalog.");
	}

	public static void main(String[] args) 
	{
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		
		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));
		firstLibrary.addBook(new Book("Le Petit Prince"));
		firstLibrary.addBook(new Book("A Tale of Two Cities"));
		firstLibrary.addBook(new Book("The Lord of the Rings"));
		
		// Print opening hours and the addresses
		System.out.println("Library hours:");
		printOpeningHours();
		System.out.println();
		System.out.println("Library addresses:");
		firstLibrary.printAddress();
		secondLibrary.printAddress();
		System.out.println();
		
		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");
		firstLibrary.borrowBook("The Lord of the Rings");
		firstLibrary.borrowBook("The Lord of the Rings");
		secondLibrary.borrowBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
		System.out.println();
		System.out.println("Books available in the second library:");
		secondLibrary.printAvailableBooks();
		System.out.println();
		
		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}

}