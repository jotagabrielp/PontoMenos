import java.util.Date;

public class Ponto {

    private Date horaEntrada;
    private Date horaSaida;
    private String nomeFuncionario;

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {this.horaEntrada = horaEntrada;}
    public void setHoraSaida(Date horaSaida) {this.horaEntrada = horaSaida;}
    public Date getHoraSaida() {
        return horaSaida;
    }
    public String getNomeFuncionario() { return nomeFuncionario; }
    public static Ponto registrarEntrada(String nome) { return new Ponto(new Date(), nome); }
    public void registrarSaida() { this.horaSaida = new Date(); }


    private Ponto(Date horaEntrada, String nomeFuncionario) {
        this.horaEntrada = horaEntrada;
        this.nomeFuncionario = nomeFuncionario;
    }
    public Ponto(Date horaEntrada, Date horaSaida, String nomeFuncionario) {
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.nomeFuncionario = nomeFuncionario;
    }
}
