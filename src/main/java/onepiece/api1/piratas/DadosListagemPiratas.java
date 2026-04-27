package onepiece.api1.piratas;

public record DadosListagemPiratas(String nome, int idade, Bando bando, Funcao funcao) {

    public DadosListagemPiratas(Pirata p){
        this(p.getNome(), p.getIdade(), p.getBando(), p.getFuncao());
    }
}
