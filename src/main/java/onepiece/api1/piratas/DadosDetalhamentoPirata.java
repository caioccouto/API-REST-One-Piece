package onepiece.api1.piratas;

public record DadosDetalhamentoPirata(Long id, String nome, int idade, Bando bando, Funcao funcao) {

    public DadosDetalhamentoPirata(Pirata p){
        this(p.getId(), p.getNome(), p.getIdade(), p.getBando(), p.getFuncao());
    }
}
