package biblioteca.biblioteca.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import biblioteca.biblioteca.models.State;
import biblioteca.biblioteca.services.StateService;

@RestController
@RequestMapping("/api/states")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @PostMapping
    public void addState(@RequestBody State state) {
        stateService.addState(state);
    }

    @DeleteMapping("/{id}")
    public void deleteState(@PathVariable("id") Long id) {
        stateService.deleteState(id);
    }

    @PutMapping("/{id}")
    public void updateState(@PathVariable("id") Long id, @RequestBody State updatedState) {
        stateService.updateState(id, updatedState);
    }
}
