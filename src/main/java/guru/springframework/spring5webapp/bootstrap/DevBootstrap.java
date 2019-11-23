package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRespository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRespository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    BookRepository bookRepository;
    AuthorRespository authorRespository;
    PublisherRespository publisherRespository;

    public DevBootstrap(BookRepository bookRepository,
        AuthorRespository authorRespository, PublisherRespository publisherRespository) {
        this.bookRepository = bookRepository;
        this.authorRespository = authorRespository;
        this.publisherRespository = publisherRespository;
    }

    private void initData() {

        Publisher publisher1 = new Publisher("First Publisher", "Madrid");
        Publisher publisher2 = new Publisher("Second Publiser", "Barcelonaaa");
        Author pepito = new Author("Pepito", "Camarena");
        Author authorJaimito = new Author("Jaimito", "Borromeo");
        Book bookDomain = new Book("Domain Driven Design", "1234", publisher1);
        Book bookOther = new Book("My book", "8743555", publisher2);

        publisherRespository.save(publisher1);
        publisherRespository.save(publisher2);
        authorRespository.save(pepito);
        authorRespository.save(authorJaimito);
        bookRepository.save(bookDomain);
        bookRepository.save(bookOther);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }
}
