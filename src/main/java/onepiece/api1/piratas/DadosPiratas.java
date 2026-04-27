package onepiece.api1.piratas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPiratas(

        @NotBlank
        String nome,

        @NotNull
        int idade,

        @NotNull
        Bando bando,

        @NotNull
        Funcao funcao)
{
}
