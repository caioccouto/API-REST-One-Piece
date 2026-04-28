package onepiece.api1.piratas;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/piratas")
public class PirataController {

    @Autowired
    private PirataRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosPiratas dadosPiratas){
        repository.save(new Pirata(dadosPiratas));
    }

    @GetMapping
    public Page<DadosListagemPiratas> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable).map(DadosListagemPiratas::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPiratas dadosPiratas){
        Pirata pirata = repository.getReferenceById(dadosPiratas.id());
        pirata.atualizarDados(dadosPiratas);
    }
}
