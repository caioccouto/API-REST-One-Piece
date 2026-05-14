package onepiece.api1.domain.piratas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPiratas(

        @NotBlank(message = "{nome.obrigatorio}")
        String nome,

        @NotNull(message = "{idade.obrigatorio}")
        int idade,

        @NotNull(message = "{bando.obrigatorio}")
        Bando bando,

        @NotNull(message = "{funcao.obrigatorio}")
        Funcao funcao)
{
}
