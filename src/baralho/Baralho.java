package baralho;

import java.security.SecureRandom;

/**
 *
 * @author AlexPh7
 */
//Representa um jogo de Baralho
public class Baralho {

    private Carta[] baralho;//array de Objeto Cartas que sera preenchido com as 52 cartas do baralho
    private int cartaAtual;
    private static final int NUMERO_DE_CARTAS = 52; //Numero de Cartas Do Baralho
    private static final SecureRandom random = new SecureRandom();

    /*Os elementos do Objeto Baralho são null por padrão, assim o construtor usa uma instrução for para preencher o Baralho com Objetos de Cartas.
        O loop inicializa a variável de controle i para 0 e faz um loop enquanto i é menor do que baralho.length, fazendo com que i suponha cada valor de inteiro de 0 a 51, Cada Carta é instanciada e inicializada com duas Strings — uma do array do numero da carta e outra dos simbolos. */
    public Baralho() {
        String[] numero = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] simbolo = {"Espadas", "Paus", "Copas", "Ouro"};

        baralho = new Carta[NUMERO_DE_CARTAS]; //Cria Objeto Baralho No Construtor com Numero de Cartas Numa Constante
        cartaAtual = 0;

        for (int i = 0; i < baralho.length; i++) {
            baralho[i] = new Carta(numero[i % 13], simbolo[i / 13]);//O cálculo i % 13 sempre resulta em um valor de 0 a 12 (os 13 índices do array de Numeros Az a Rei), e o cálculo i/13 sempre resulta em um valor de 0 a 3 (os quatro índices do array de Simbolos copas, ouros, espada e paus).
        }
    }

    // embaralha as cartas
    public void embaralhar() {
        // a próxima chamada para o método embaralhar deve começar no Baralho[0] novamente
        cartaAtual = 0;

        // para cada Carta, seleciona outra Carta aleatória (0-51) e as compara
        for (int primeira = 0; primeira < baralho.length; primeira++) {
            // seleciona um número aleatório entre 0 e 51
            int segunda = random.nextInt(NUMERO_DE_CARTAS);

            /* compara Carta atual com Carta aleatoriamente selecionad, O método faz um loop por todas as 52 Cards Para cada Carta, um número entre 0 e 51 é escolhido aleatoriamente para selecionar outra Carta. Em seguida, o objeto Carta atual e o objeto Carta aleatoriamente selecionado são trocados no array. Essa troca é realizada pelas três atribuições, A variável extra temp armazena temporariamente um dos dois objetos Carta sendo comparados. A comparação não pode ser
realizada apenas com as duas instruções, Se baralho[primeira] for "Az" de "Espada" e baralho[segunda] for "Dama" de "Copas", depois da primeira atribuição, ambos os elementos do array conterão "dama" de "copas", e o "Az" de "Espadas" será perdido — daí a variável extra temp ser necessária.
Depois de o loop 'for' terminar, os objetos Carta são ordenados aleatoriamente. Um total de apenas 52 trocas é feito em uma única passagem pelo array inteiro e o array dos objetos Carta é embaralhado!
[Observação: é recomendável usar um algoritmo de embaralhamento imparcial para jogos reais de cartas. Esse algoritmo assegura a probabilidade de que todas as sequências possíveis das cartas embaralhadas ocorram. A Questão 7.35 solicita que se pesquise o algoritmo de embaralhamento imparcial popular Fisher-Yates e use-o para reimplementar o método Embaralhar DeckOfCards */
            Carta temp = baralho[primeira];
            baralho[primeira] = baralho[segunda];
            baralho[segunda] = temp;

        }
    }

    // distribui uma Carta
    public Carta tirarCarta() {
        // determina se ainda há Cards a serem distribuídas
        if (cartaAtual < baralho.length) {
            return baralho[cartaAtual++];
        } else {
            return null;  // retorna nulo para indicar que todos as Cards foram distribuídas
        }
    }
}// fim da classe DeckOfCards
