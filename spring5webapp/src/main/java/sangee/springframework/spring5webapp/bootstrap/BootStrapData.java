package sangee.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sangee.springframework.spring5webapp.domain.Author;
import sangee.springframework.spring5webapp.domain.Book;
import sangee.springframework.spring5webapp.domain.Publisher;
import sangee.springframework.spring5webapp.repositories.AuthorRepository;
import sangee.springframework.spring5webapp.repositories.BookRepository;
import sangee.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("St Petersburg");
		publisher.setState("FL");

		publisherRepository.save(publisher);

		System.out.println("Publisher Count: " + publisherRepository.count());

		Author rowling = new Author("JK", "Rowling");
		Book potter = new Book("Harry Potter", "12345");
		rowling.getBooks().add(potter);
		potter.getAuthors().add(rowling);
		potter.setPublisher(publisher);
		publisher.getBooks().add(potter);

		authorRepository.save(rowling);
		bookRepository.save(potter);

		Author tolkien = new Author("JD", "Tolkien");
		Book hobbit = new Book("The Hobbit", "12346");
		tolkien.getBooks().add(hobbit);
		hobbit.getAuthors().add(tolkien);
		hobbit.setPublisher(publisher);
		publisher.getBooks().add(hobbit);

		authorRepository.save(tolkien);
		bookRepository.save(hobbit);
		publisherRepository.save(publisher);

		System.out.println("Started Spring");
		System.out.println("No of books in repository : " + bookRepository.count());
		System.out.println("No of publishers : " + publisherRepository.count());

	}

}
