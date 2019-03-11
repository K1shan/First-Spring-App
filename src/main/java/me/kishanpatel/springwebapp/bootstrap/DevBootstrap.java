package me.kishanpatel.springwebapp.bootstrap;

import me.kishanpatel.springwebapp.model.Author;
import me.kishanpatel.springwebapp.model.Book;
import me.kishanpatel.springwebapp.model.Publisher;
import me.kishanpatel.springwebapp.repositories.AuthorRepository;
import me.kishanpatel.springwebapp.repositories.BookRepository;
import me.kishanpatel.springwebapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        //Kishan Object
        Author kishan = new Author("Kishan", "Patel");
        Book bPhotography = new Book("Beginner to Photography", "1234", publisher);
        bPhotography.getAuthors().add(kishan);

        authorRepository.save(kishan);
        bookRepository.save(bPhotography);

        //Eric Object
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "23444", publisher);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

    }
}
