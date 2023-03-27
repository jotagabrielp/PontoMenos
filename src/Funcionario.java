import java.util.List;

public interface Funcionario {
    public List<Ponto> getPontosRegistrados();
    public List<Funcionario> getSubordinados();

    void baterPonto();
}
