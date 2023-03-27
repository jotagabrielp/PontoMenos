import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class FuncionarioBase implements Funcionario{

    protected String nome;
    protected List<Ponto> pontosRegistrados = new ArrayList<>();

    private List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.atualizar(pontosRegistrados);
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Ponto> getPontosRegistrados() {
        return pontosRegistrados;
    }
    public List<Funcionario> getSubordinados() {
        return new ArrayList<>();
    }
    public FuncionarioBase(String nome) {
        this.nome = nome;
    }
    public void baterPonto() {
        Ponto ultimoPonto = getUltimoPonto();
        if (ultimoPonto != null && ultimoPonto.getHoraSaida() == null) {
            ultimoPonto.registrarSaida();
        } else {
            Ponto novoPonto = Ponto.registrarEntrada(this.getNome());
            pontosRegistrados.add(novoPonto);
        }
        notificarObservadores();
    }

    public void adicionarPonto(Date horaEntrada, Date horaSaida) {
        pontosRegistrados.add(new Ponto(horaEntrada, horaSaida, nome));
    }

    public void removerPonto(Ponto ponto) {
        pontosRegistrados.remove(ponto);
    }

    private Ponto getUltimoPonto() {
        if (pontosRegistrados.isEmpty()) {
            return null;
        }
        return pontosRegistrados.get(pontosRegistrados.size() - 1);
    }

}
