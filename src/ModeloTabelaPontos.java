import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaPontos extends AbstractTableModel implements Observador {

    private List<Ponto> pontos;
    private DateFormat formatadorHora = new SimpleDateFormat("HH:mm:ss");
    private String[] colunas = {"Nome", "Hora de entrada", "Hora de saída", "Horas trabalhadas"};

    public ModeloTabelaPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    @Override
    public int getRowCount() {
        return pontos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ponto ponto = pontos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ponto.getNomeFuncionario();
            case 1:
                return formatadorHora.format(ponto.getHoraEntrada());
            case 2:
                if(ponto.getHoraSaida() != null) {
                    return formatadorHora.format(ponto.getHoraSaida());
                }
                    return null;
            case 3:
                if(ponto.getHoraSaida() != null) {
                    long duracao = ponto.getHoraSaida().getTime() - ponto.getHoraEntrada().getTime();
                    int horas = (int) (duracao / (1000 * 60 * 60));
                    int minutos = (int) ((duracao / (1000 * 60)) % 60);
                    return String.format("%d:%02d", horas, minutos);
                }
                return null;
            default:
                return null;
        }
    }

    @Override
    public void atualizar(List<Ponto> novaLista) {
        pontos = novaLista;
        fireTableDataChanged();
    }
}