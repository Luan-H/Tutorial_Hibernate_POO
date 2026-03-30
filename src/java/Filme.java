import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    titulo, diretor, anoLancamento, genero, duracaoEmMinutos, sinopse
*/
@Entity
@Table(name="filme")
public class Filme {
    String titulo;
    String diretor;
    String genero;
    int anoLancamento;
    String sinopse;
    int duracaoEmMinutos;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    public Filme() {
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDiretor(){
        return this.diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    public String getGenero(){
        return this.genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    public int getAnoLancamento(){
        return this.anoLancamento;
    }
    public void setAnoLancamento(int duracao){
        this.anoLancamento = duracao;
    }
    public String getSinopse(){
        return this.sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public int getDuracaoEmMinutos(){
        return this.duracaoEmMinutos;
    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public Long getId(){
        return this.id;
    }
}
