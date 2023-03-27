import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date hora1 = new Date();
        Date hora2 = new Date();
        Date hora3 = new Date();
        Date hora4 = new Date();
        hora1.setTime(1679918400000L);
        hora2.setTime(hora1.getTime() + 28800000);
        hora3.setTime(1679925600000L);
        hora4.setTime(hora3.getTime() + 28800000);
        Chefe c1 = new Chefe("chefe");
        Empregado e1 = new Empregado("empregado1");
        Empregado e2 = new Empregado("empregado2");
        e1.adicionarPonto(hora1, hora2);
        e2.adicionarPonto(hora3, hora4);
        c1.addSubordinado(e1);
        c1.addSubordinado(e2);
        ArrayList<FuncionarioBase> users = new ArrayList<>();
        users.add(c1);
        users.add(e1);
        users.add(e2);
        TelaLogin tela = new TelaLogin(users);
    }
}