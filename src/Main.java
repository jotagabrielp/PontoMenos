import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date hora1 = c.getTime();
        Date hora2 = new Date();
        hora2.setTime(hora1.getTime() + 28800000);
        Chefe c1 = new Chefe("chefe 1");
        Empregado e1 = new Empregado("empregado 1");
        e1.adicionarPonto(hora1, hora2);
        c1.addSubordinado(e1);
        ArrayList<FuncionarioBase> users = new ArrayList<>();
        users.add(c1);
        users.add(e1);
        TelaLogin tela = new TelaLogin(users);
    }
}