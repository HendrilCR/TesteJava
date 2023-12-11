import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Aluno extends Pessoa implements Autenticavel{ //Solução temporária
    private String matricula;
    public String getNome(){return this.nome;}
    public String getMatricula(){return this.matricula;}

    public boolean autenticar(String nome, String senha){
        if(matricula == this.matricula && senha == this.senha){return true;}
        else{return false;}}
    }

interface Autenticavel {
    boolean autenticar(String nome, String senha);
}

class Coordenador extends Professor {
    private List<Disciplina> disciplinas;

    public Coordenador(String titulacao, String areaAtuacao) {
        super(titulacao, areaAtuacao);
        this.disciplinas = new ArrayList<>();
    }

    public void criarDisciplina(String nomeDisciplina) {
        Disciplina disciplina = new Disciplina(nomeDisciplina);
        disciplinas.add(disciplina);
    }

    public void definirProfessorParaDisciplina(String nomeDisciplina, Professor professor) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nomeDisciplina)) {
                disciplina.setProfessor(professor);
                break;
            }
        }
    }

    public void cadastrarAlunosNaDisciplina(String nomeDisciplina, List<Aluno> alunos) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nomeDisciplina)) {
                disciplina.adicionarAlunos(alunos);
                break;
            }
        }
    }
}

class Data{
    private int dia; 
    private int mes; 
    private int ano; 

    Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;}

    public int[] getData(){
        int[] data = new int[3];
        data[0] = this.dia;
        data[1] = this.mes;
        data[2] = this.ano;
        return data;
    }
}

class Disciplina{ //Solução temporária
    private String nome;
    private Professor professor;
    private List<Aluno> alunos;

    Disciplina(String nome){this.nome = nome;}

    String getNome(){return this.nome;}
    Professor getProfessor(){return this.professor;}
    void adicionarAlunos(Aluno[] alunos){this.alunos = alunos;}
    void setProfessor(Professor professor){this.professor = professor;}
}

abstract class Pessoa{
    protected String nome;
    protected int cpf;
    protected Data dataNascimento;
    protected Data dataEntradaIfpi;
    protected String senha;
}

class Menu{
    private Scanner s1 = new Scanner(System.in);

    public int menuLogin(){
        int state = 1;
        int opcao = -1;

        while(state == 1){
            System.out.print("Insira como deseja fazer login: \n[1-Aluno]\n[2-Coordenador]\n[3-Professor]\n[0-Sair]\n--> ");
            String str = s1.nextLine();

            try{
                opcao = Integer.parseInt(str);
                state = 0;

                switch(opcao){
                    case 0:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    case 1: 
                        System.out.println("Aluno selecionado");
                        break;
                    case 2: 
                        System.out.println("Coordenador selecionado");
                        break;
                    case 3: 
                        System.out.println("Professor selecionado");
                        break;
                    default:
                        System.out.println("Insira uma opção válida!");
                        state = 1;
                        break;}}

            catch(Exception e){
                System.out.println("Digite apenas valores numéricos válidos!");}}

        return(opcao);}

    public void menuAutenticacao(int tipo){
        if(tipo == 1){System.out.print("Insira a matrícula: ");}
        else{System.out.print("Insira o nome de usuário: ");}
        
        String usuario = s1.nextLine();
        System.out.print("Insira a senha: ");
        String senha = s1.nextLine();

    }
}

class Professor extends Pessoa{
    protected String titulacao;
    protected String areaAtuacao;
    
    public String getTitulacao(){return this.titulacao;}
    public String getArea(){return this.areaAtuacao;}
    
    public void setTitulacao(String tit){this.titulacao = tit;}
    public void setArea(String are){this.areaAtuacao = are;}
}

class Secretario implements Autenticavel {
    private String nome;
    private String senha;
    private Aluno[] alunos;
    private int contadorAlunos;

    public Secretario(String nome, String senha, int capacidadeAlunos) {
        this.nome = nome;
        this.senha = senha;
        this.alunos = new Aluno[capacidadeAlunos];
        this.contadorAlunos = 0;
    }
    
    public void cadastrarAluno(Aluno aluno) {
        if (contadorAlunos < alunos.length) {
            alunos[contadorAlunos] = aluno;
            contadorAlunos++;
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Capacidade máxima de alunos atingida.");
        }
    }

    public void listarAlunos() {
        if (contadorAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < contadorAlunos; i++) {
                System.out.println("Nome: " + alunos[i].getNome() + ", Matrícula: " + alunos[i].getMatricula());
            }
        }
    }

    public void atualizarAluno(String matricula, Aluno novoAluno) {
        for (int i = 0; i < contadorAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                alunos[i] = novoAluno;
                System.out.println("Dados do aluno atualizados com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    public void excluirAluno(String matricula) {
        for (int i = 0; i < contadorAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                for (int j = i; j < contadorAlunos - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[contadorAlunos - 1] = null;
                contadorAlunos--;
                System.out.println("Aluno excluído com sucesso!");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }
    public boolean autenticar(String nome, String senha){
        if(nome == this.nome && senha == this.senha){return true;}
        else{return false;}}
    }
