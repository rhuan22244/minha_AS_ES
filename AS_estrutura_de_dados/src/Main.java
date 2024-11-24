import jogo.Jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de jogadores (mínimo 2): ");
        int numJogadores = scanner.nextInt();
        while (numJogadores < 2) {
            System.out.print("Número de jogadores deve ser no mínimo 2. Digite novamente: ");
            numJogadores = scanner.nextInt();
        }

        System.out.print("Digite o número de rodadas: ");
        int numRodadas = scanner.nextInt();

        System.out.print("Digite o saldo inicial para os jogadores: ");
        double saldoInicial = scanner.nextDouble();

        scanner.nextLine();
        String[] nomesJogadores = new String[numJogadores];
        for (int i = 0; i < numJogadores; i++) {
            System.out.print("Digite o nome do jogador " + (i + 1) + ": ");
            nomesJogadores[i] = scanner.nextLine();
        }

        Jogo jogo = new Jogo();
        jogo.iniciar(numJogadores, nomesJogadores, saldoInicial);

        for (int i = 0; i < numRodadas; i++) {
            System.out.println("\nRodada " + (i + 1));
            jogo.jogarRodada();
        }

        scanner.close();
    }
}









