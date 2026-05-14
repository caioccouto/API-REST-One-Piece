package onepiece.api1.domain.piratas;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPiratas(

        @NotNull
        Long id,
        String nome,
        Bando bando,
        Funcao funcao)
{
}
