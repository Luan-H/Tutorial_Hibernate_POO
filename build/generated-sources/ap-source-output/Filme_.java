import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filme.class)
public abstract class Filme_ {

	public static volatile SingularAttribute<Filme, String> sinopse;
	public static volatile SingularAttribute<Filme, Integer> anoLancamento;
	public static volatile SingularAttribute<Filme, String> genero;
	public static volatile SingularAttribute<Filme, String> titulo;
	public static volatile SingularAttribute<Filme, Long> id;
	public static volatile SingularAttribute<Filme, String> diretor;
	public static volatile SingularAttribute<Filme, Integer> duracaoEmMinutos;

	public static final String SINOPSE = "sinopse";
	public static final String ANO_LANCAMENTO = "anoLancamento";
	public static final String GENERO = "genero";
	public static final String TITULO = "titulo";
	public static final String ID = "id";
	public static final String DIRETOR = "diretor";
	public static final String DURACAO_EM_MINUTOS = "duracaoEmMinutos";

}

