import java.util.List;
import java.util.ArrayList;

interface Autenticavel {
    boolean autenticar(String nome, String senha);
}

abstract class Pessoa{
    protected String nome;
    protected int cpf;
    protected Data dataNascimento;
    protected Data dataEntradaIfpi;
    protected String senha;
}



// 209121932798373792132
//SDJAHDOSAHDOSADASHDSOADADNSA




class Professor extends Pessoa{
    protected String titulacao;
    protected String areaAtuacao;
    
    public String getTitulacao(){return this.titulacao;}
    public String getArea(){return this.areaAtuacao;}
    
    public void setTitulacao(String tit){this.titulacao = tit;}
    public void setArea(String are){this.areaAtuacao = are;}
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
                disciplina.setProfessorResponsavel(professor);
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

class Curso {
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Disciplina> disciplinas;
    
    public Curso(List<Aluno> alunos, List<Professor> professores, List<Disciplina> disciplinas) {
        this.alunos = alunos;
        this.professores = professores;
        this.disciplinas = disciplinas;
    }
    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
    
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}

class Secretario implements Autenticavel {//Linha teste
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
}

class Aluno{}//Falta implementar
class Disciplina{}//Falta implementar
//linha teste