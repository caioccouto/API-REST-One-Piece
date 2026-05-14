package onepiece.api1.controller;

import jakarta.validation.Valid;
import onepiece.api1.domain.piratas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/piratas")
public class PirataController {

    @Autowired
    private PirataRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosPiratas dadosPiratas, UriComponentsBuilder uriBuilder){
        var pirata = new Pirata(dadosPiratas);
        repository.save(pirata);

        var uri = uriBuilder.path("/piratas/{id}").buildAndExpand(pirata.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPirata(pirata));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPiratas>> listar(Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemPiratas::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPiratas dadosPiratas){
        Pirata pirata = repository.getReferenceById(dadosPiratas.id());
        pirata.atualizarDados(dadosPiratas);
        return ResponseEntity.ok(new DadosDetalhamentoPirata(pirata));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id){
        Pirata pirata = repository.getReferenceById(id);
        pirata.remover();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        Pirata pirata = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPirata(pirata));
    }
}
