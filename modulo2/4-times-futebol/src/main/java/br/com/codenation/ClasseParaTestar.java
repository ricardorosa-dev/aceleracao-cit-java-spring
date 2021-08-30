package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class ClasseParaTestar {
    public static void main(String[] args) {
        DesafioMeuTimeApplication application = new DesafioMeuTimeApplication();

        application.incluirTime(1L, "Barcelona", LocalDate.of(1999, Month.JANUARY, 1), "vermelho", "roxo");
        application.incluirTime(2L, "Jamborei", LocalDate.of(1934, Month.JUNE, 19), "verde", "amarelo");
        application.incluirTime(3L, "Xarious", LocalDate.of(1979, Month.NOVEMBER, 4), "rosa", "branco");

        application.incluirJogador(4L, 1L, "Roberto", LocalDate.of(1989, Month.FEBRUARY, 17), 87, new BigDecimal(443));
        application.incluirJogador(5L, 1L, "Jackson", LocalDate.of(1954, Month.JULY, 3), 12, new BigDecimal(119));
        application.incluirJogador(6L, 1L, "Jeremias", LocalDate.of(1969, Month.MARCH, 23), 119, new BigDecimal(230));

        application.definirCapitao(4L);
        System.out.print(application.buscarTopJogadores(2));

    }
}
