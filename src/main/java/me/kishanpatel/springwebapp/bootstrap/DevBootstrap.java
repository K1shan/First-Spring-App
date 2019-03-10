package me.kishanpatel.springwebapp.bootstrap;

import me.kishanpatel.springwebapp.model.Author;
import me.kishanpatel.springwebapp.model.Book;
import me.kishanpatel.springwebapp.repositories.AuthorRepository;
import me.kishanpatel.springwebapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Kishan Object
        Author kishan = new Author("Kishan", "Patel");
        Book bPhotography = new Book("Beginner to Photography", "1234", "Canon");
        bPhotography.getAuthors().add(kishan);

        authorRepository.save(kishan);
        bookRepository.save(bPhotography);

        //Eric Object
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "23444", "Harper Collins");
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

    }
}
