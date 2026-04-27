package onepiece.api1.piratas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "piratas")
@Entity(name = "Pirata")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pirata {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @Enumerated(EnumType.STRING)
    private Bando bando;

    @Enumerated(EnumType.STRING)
    private Funcao funcao;

    public Pirata(DadosPiratas dp){
        this.nome = dp.nome();
        this.idade = dp.idade();
        this.bando = dp.bando();
        this.funcao = dp.funcao();
    }
}
