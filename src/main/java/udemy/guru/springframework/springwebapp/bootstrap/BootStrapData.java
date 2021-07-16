package udemy.guru.springframework.springwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.guru.springframework.springwebapp.domain.Author;
import udemy.guru.springframework.springwebapp.domain.Book;
import udemy.guru.springframework.springwebapp.domain.Publisher;
import udemy.guru.springframework.springwebapp.repositories.AuthorRepository;
import udemy.guru.springframework.springwebapp.repositories.BookRepository;
import udemy.guru.springframework.springwebapp.repositories.PublisherRepository;

/**
 * @author NH 2021-07-16
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher bezigeBij = new Publisher("Bezige Bij","Apollopad 41", "Boxtel", "Nl","5283KG");
        publisherRepository.save(bezigeBij);

        ddd.setPublisher(bezigeBij);
        bookRepository.save(ddd);
        bezigeBij.getBooks().add(noEJB);
        bezigeBij.getBooks().add(ddd);
        publisherRepository.save(bezigeBij);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publushers: " + publisherRepository.count());
        System.out.println("publisher number of books: " + bezigeBij.getBooks().size());
    }
}
