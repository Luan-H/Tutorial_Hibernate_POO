# Configuração de Projeto Java Web com Hibernate e MySQL

**Autor:** Luan Henrique Ribeiro de Sousa  
**Instituição:** IFMT — Instituto Federal de Mato Grosso  
**Curso:** Tecnologia em Sistemas para Internet  

---

## 📝 Resumo
Este tutorial apresenta, de maneira clara e objetiva, os passos necessários para criar um projeto Java utilizando **Hibernate** e **MySQL** no **NetBeans**. São descritos os procedimentos que vão desde a verificação da compatibilidade entre as versões até a configuração completa do ambiente e teste de persistência no banco de dados.

---

## 1. Introdução
Este documento apresenta o procedimento completo para configurar o ambiente de desenvolvimento e criar um projeto Java utilizando o framework Hibernate, o banco de dados MySQL e a IDE NetBeans. 

O propósito é oferecer um guia estruturado, com instruções claras e organizadas em formato passo a passo, a fim de facilitar a compreensão e a reprodução do processo.

---

## 2. Downloads e Configurações Iniciais
Nesta etapa, realizaremos os downloads necessários para montar o ambiente de desenvolvimento.

### 2.1. Hibernate
Utilizaremos a versão **5.4.33**. O download pode ser realizado no site oficial:
* [Hibernate ORM Releases](https://hibernate.org/orm/releases/5.4/)
*(Compatível com Java 8 ou superior).*

### 2.2. Java (JDK 17)
Realize o download do JDK 17 no site da Adoptium:
* [Adoptium Temurin 17](https://adoptium.net/pt-BR/temurin/releases?version=17)

### 2.3. MySQL e Connector/J
Baixe o banco de dados e o driver de conexão:
* **MySQL Community Server:** [Download](https://dev.mysql.com/downloads/mysql/)
* **MySQL Connector/J:** [Download](https://dev.mysql.com/downloads/connector/j/)

### 2.4. IDE NetBeans
Utilizaremos o **Apache NetBeans 28**:
* [Download NetBeans](https://netbeans.apache.org/front/main/index.html)

---

## 3. Criação do Projeto no NetBeans

### 3.1. Criando o Projeto Web
1. Acesse **File** → **New Project**.
2. Selecione a categoria **Java with Ant**, escolha **Java Web** e, no quadro ao lado, **Web Application**. Clique em **Next**.
3. Defina o nome do projeto e o diretório, clique em **Next**.
4. Clique em **Add...**, selecione **GlassFish Server** e clique em **Next**.
5. Selecione o local de instalação, marque **Local Domain** e aceite o contrato de licença.
6. Clique em **Download Now...**, aguarde o término e clique em **Next**.
7. Clique em **Finish**, depois em **Next** e, finalmente, em **Finish** na última tela.

### 3.2. Configurando o JDK 17
1. No NetBeans, acesse **Tools** → **Java Platforms** e clique em **Add Platform**.
2. Selecione **Java Standard Edition** e escolha a pasta raiz do seu JDK 17 (ex: `C:\Program Files\Eclipse Adoptium\...`).
3. Clique com o botão direito no seu projeto, vá em **Properties** → **Libraries** e, em **Java Platform**, selecione o JDK 17.

---

## 4. Configuração do Hibernate

### 4.1. Adicionando Bibliotecas
1. No projeto, vá em **Properties** → **Libraries**.
2. Clique em **Add JAR/Folder** e adicione todos os arquivos `.jar` das pastas do Hibernate:
   - `lib/required`
   - `lib/jpa-metamodel-generator`
   - `lib/optional/c3p0`
3. Adicione também o arquivo **mysql-connector-j** baixado anteriormente.
4. Clique em **OK**.

### 4.2. Configurando o persistence.xml
1. Em **Web Pages**, clique com o botão direito na pasta **META-INF**.
2. Selecione **New** → **Persistence Unit...**.
3. Nomeie como `persistence.xml`, selecione sua conexão em **Database Connection** e clique em **Finish**.
4. No arquivo gerado, utilize o seguinte código de configuração:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="[http://xmlns.jcp.org/xml/ns/persistence](http://xmlns.jcp.org/xml/ns/persistence)"
             xmlns:xsi="[http://www.w3.org/2001/XMLSchema-instance](http://www.w3.org/2001/XMLSchema-instance)"
             xsi:schemaLocation="[http://xmlns.jcp.org/xml/ns/persistence](http://xmlns.jcp.org/xml/ns/persistence) [http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd](http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd)">
    <persistence-unit name="filme">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3307/filme?createDatabaseIfNotExist=true"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="123123123"/>
            
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```
## 5. Testando o Banco de Dados
### 5.1. Criando a entidade filme
1. Em Source Packages →, clique com o botão direito e crie uma classe chamada Filme.java:
```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String diretor;
    private String genero;
    private int anoLancamento;
    private String sinopse;
    private int duracaoEmMinutos;

    public Filme() {}

    // Getters e Setters
    public String getTitulo(){ return this.titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDiretor(){ return this.diretor; }
    public void setDiretor(String diretor) { this.diretor = diretor; }
    public String getGenero(){ return this.genero; }
    public void setGenero(String genero){ this.genero = genero; }
    public int getAnoLancamento(){ return this.anoLancamento; }
    public void setAnoLancamento(int ano){ this.anoLancamento = ano; }
    public String getSinopse(){ return this.sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }
    public int getDuracaoEmMinutos(){ return this.duracaoEmMinutos; }
    public void setDuracaoEmMinutos(int duracao) { this.duracaoEmMinutos = duracao; }
    public Long getId(){ return this.id; }
}
```

### 5.2. Crie a classe app.java para testar a inserção de dados:
1. Em Source Packages →, clique com o botão direito e crie uma classe chamada app.java:
```java
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class app {
    public static void main(String[] args) {
        // Inicializa a fábrica de entidades com o nome da unidade definido no persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("filme");
        EntityManager em = factory.createEntityManager();

        // Cria e popula o objeto
        Filme filme = new Filme();
        filme.setTitulo("Interestelar");
        filme.setDiretor("Christopher Nolan");
        filme.setAnoLancamento(2014);
        filme.setGenero("Ficção Científica");
        filme.setDuracaoEmMinutos(169);
        filme.setSinopse("Em um futuro próximo, a humanidade busca um novo lar entre as estrelas.");

        // Realiza a transação
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(filme);
        tx.commit();

        // Finaliza as conexões
        em.close();
        factory.close();
    }
}
```
### 5.3. Testando o banco de dados de fato.
1 - Agora, no arquivo app.java, clique com o botão direito sobre o código e clique em "Run File". Se tudo deu certo, irá aparecer **BUILD SUCCESSFUL** em verde no seu terminal.
