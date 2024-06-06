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

    public Author updateAuthor(Long id, Author updatedAuthor) {
        return authorRepository.findById(id).map(author -> {
            author.setName(updatedAuthor.getName());
            author.setLastName(updatedAuthor.getLastName());
            author.setBorn(updatedAuthor.getBorn());
            author.setCountry(updatedAuthor.getCountry());
            author.setBooks(updatedAuthor.getBooks());
            return authorRepository.save(author);
        }).orElseThrow(() -> new IllegalStateException("Author with id " + id + " does not exist"));
    }

}
