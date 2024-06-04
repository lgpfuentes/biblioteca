package biblioteca.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.biblioteca.models.State;
import biblioteca.biblioteca.repositories.StateRepository;

@Service
public class StateService {

    private final StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public Optional<State> getStateById(Long id) {
        return stateRepository.findById(id);
    }

    public State addState(State state) {
        return stateRepository.save(state);
    }

    public void deleteState(Long id) {
        boolean stateExists = stateRepository.existsById(id);
        if (!stateExists) {
            throw new IllegalStateException("State with id " + id + " does not exist");
        }
        stateRepository.deleteById(id);
    }

}
