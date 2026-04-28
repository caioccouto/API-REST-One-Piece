package onepiece.api1.piratas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPiratas(

        @NotNull
        Long id,
        String nome,
        Bando bando,
        Funcao funcao)
{
}
