package br.com.edernilson.sb3valueobjects.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edernilson.sb3valueobjects.core.exceptions.GenericAPIException;
import br.com.edernilson.sb3valueobjects.services.PersonService;
import lombok.RequiredArgsConstructor;

/**
 * @author: github.com/edernilson
 * @user: eder.nilson
 * @created: 09/12/2024, segunda-feira
 */
@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonAPI {
    private final PersonService personService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody @Validated PersonCreateRequest request) throws GenericAPIException {
        var person = personService.createPerson(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
//                .location(
//                        ServletUriComponentsBuilder
//                                .fromCurrentRequest()
//                                .path("/{id}")
//                                .buildAndExpand(person.id())
//                                .toUri()
//                )
                .body(person);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }
}