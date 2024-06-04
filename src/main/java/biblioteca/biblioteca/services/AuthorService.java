package biblioteca.biblioteca.services;

import java.util.List;

import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.Author;
import biblioteca.biblioteca.repositories.AuthorRepository;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAthor(Long id) {
        boolean authorExists = authorRepository.existsById(id);
        if (!authorExists) {
            throw new IllegalStateException("Auhor with id " + id + " does not exist");
        }
        authorRepository.deleteById(id);
    }

}
