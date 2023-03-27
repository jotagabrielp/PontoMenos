import java.util.ArrayList;
import java.util.List;

public class Chefe extends FuncionarioBase{
    private List<Funcionario> subordinados;
    public Chefe(String nome) {
        super(nome);
        subordinados = new ArrayList<>();
    }
    public void addSubordinado(Funcionario funcionario) {
        subordinados.add(funcionario);
    }

    public void removeSubordinado(Funcionario funcionario) {
        subordinados.remove(funcionario);
    }

    public List<Funcionario> getSubordinados() {
        return subordinados;
    }
    public List<Ponto> getPontosRegistrados() {
        List<Ponto> allPontos = pontosRegistrados;
        for(Funcionario subordinado : subordinados) {
            for(Ponto ponto : subordinado.getPontosRegistrados()) {
                if(!allPontos.contains(ponto)) {
                    allPontos.add(ponto);
                }
            }
        }
        return allPontos;
    }
}
