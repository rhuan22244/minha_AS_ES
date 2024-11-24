package jogo;
import Board.Tabuleiro;
import Model.Casa;
import Model.Jogador;

import java.util.List;
import java.util.ArrayList;

public class Jogo {
    List<Jogador> jogadores;
    Tabuleiro tabuleiro;
    int rodadaAtual;
    int totalRodadas;

    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
        this.rodadaAtual = 0;
        this.totalRodadas = totalRodadas;
    }

    public void iniciar(int numJogadores, String[] nomesJogadores, double saldoInicial) {
        tabuleiro.adicionarCasa(new Casa("Casa do Bosque", "Imóvel", 200000, 1100));
        tabuleiro.adicionarCasa(new Casa("Apartamento Central", "Imóvel", 350000, 1800));
        tabuleiro.adicionarCasa(new Casa("Vila das Flores", "Imóvel", 400000, 2200));
        tabuleiro.adicionarCasa(new Casa("Pousada da Praia", "Imóvel", 500000, 2700));
        tabuleiro.adicionarCasa(new Casa("Mansão da Colina", "Imóvel", 600000, 3300));
        tabuleiro.adicionarCasa(new Casa("Residência do Lago", "Imóvel", 450000, 2500));
        tabuleiro.adicionarCasa(new Casa("Cobertura Diamante", "Imóvel", 700000, 3700));
        tabuleiro.adicionarCasa(new Casa("Edifício Horizonte", "Imóvel", 550000, 2900));
        tabuleiro.adicionarCasa(new Casa("Chácara do Sol", "Imóvel", 300000, 1600));
        tabuleiro.adicionarCasa(new Casa("Fazenda Boa Vista", "Imóvel", 250000, 1300));
        tabuleiro.adicionarCasa(new Casa("Prisão", "Prisão"));
        tabuleiro.adicionarCasa(new Casa("Sorte", "Sorte", 0, 0));
        tabuleiro.adicionarCasa(new Casa("Revés", "Revés", 0, 0));

        for (int i = 0; i < numJogadores; i++) {
            jogadores.add(new Jogador(nomesJogadores[i], saldoInicial));
        }
    }

    public void jogarRodada() {

        for (Jogador jogador : jogadores) {
            if (jogador.falido()) {
                System.out.println(jogador.nome + " está falido e não pode jogar.");
                continue;
            }

            if (jogador.prisao) {
                System.out.println(jogador.nome + " está preso e não pode jogar.");
                jogador.atualizarPrisao();
                continue;
            }

            int dado = (int) (Math.random() * 6) + 1;
            System.out.println(jogador.nome + " jogou o dado e tirou " + dado);

            jogador.mover(dado);
            Casa casa = tabuleiro.getCasa(jogador.posicao);
            System.out.println(jogador.nome + " parou na casa: " + casa.nome);

            if (casa.tipo.equals("Imóvel")) {
                if (casa.getProprietario() == null) {
                    jogador.comprarImovel(casa);
                } else {
                    jogador.pagarAluguel(casa);
                }
            } else if (casa.tipo.equals("Sorte") || casa.tipo.equals("Revés")) {
                double efeito = casa.efeitoCasa();
                jogador.saldo += efeito;
                if (efeito > 0) {
                    System.out.println(jogador.nome + " ganhou R$" + efeito + " de sorte.");
                } else {
                    System.out.println(jogador.nome + " perdeu R$" + Math.abs(efeito) + " de revés.");
                }
            } else if (casa.tipo.equals("Prisão")) {
                jogador.prender(2);
            }
        }

        rodadaAtual++;

        if (rodadaAtual >= totalRodadas) {
            mostrarVencedor();
        }
    }

    void mostrarVencedor() {
        Jogador vencedor = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.saldo > vencedor.saldo && !jogador.falido()) {
                vencedor = jogador;
            }
        }
        System.out.println("O vencedor é " + vencedor.nome + " com um saldo de R$" + vencedor.saldo);
    }
}



















