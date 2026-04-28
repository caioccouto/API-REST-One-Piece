package onepiece.api1.piratas;

public record DadosListagemPiratas(Long id, String nome, int idade, Bando bando, Funcao funcao) {

    public DadosListagemPiratas(Pirata p){
        this(p.getId(), p.getNome(), p.getIdade(), p.getBando(), p.getFuncao());
    }
}
