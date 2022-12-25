package baralho;

/**
 *
 * @author AlexPh7
 */
public class BaralhoTeste {

    public static void main(String[] args) {
        Baralho objBaralho = new Baralho();

        objBaralho.embaralhar();

        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", objBaralho.tirarCarta());
            if (i % 4 == 0) { // gera uma nova linha após cada quarta carta
                System.out.println();
            }
        }
    }
}
