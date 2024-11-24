package Model;

public class Jogador {
    public String nome;
    public double saldo;
    public int posicao;
    public boolean prisao;
    int rodadasNaPrisao;

    public Jogador(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
        this.posicao = 0;
        this.prisao = false;
        this.rodadasNaPrisao = 0;
    }

    public void prender(int rodadas) {
        this.prisao = true;
        this.rodadasNaPrisao = rodadas;
        System.out.println(nome + " foi preso por " + rodadas + " rodadas.");
    }

    public void atualizarPrisao() {
        if (prisao) {
            rodadasNaPrisao--;
            if (rodadasNaPrisao <= 0) {
                prisao = false;
                System.out.println(nome + " foi libertado da prisão.");
            }
        }
    }

    public boolean falido() {
        return saldo <= 0;
    }

    public void mover(int dado) {
        if (!prisao) {
            posicao = (posicao + dado) % 40;  // Tabuleiro com 40 casas (mod 40)
        } else {
            System.out.println(nome + " está preso e não pode jogar.");
        }
    }

    public void comprarImovel(Casa casa) {
        if (saldo >= casa.valor) {
            saldo -= casa.valor;
            casa.proprietario = this;
            System.out.println(nome + " comprou o imóvel " + casa.nome + " por R$" + casa.valor);
        } else {
            System.out.println(nome + " não tem saldo suficiente para comprar " + casa.nome);
        }
    }

    public void pagarAluguel(Casa casa) {
        if (saldo >= casa.aluguel) {
            saldo -= casa.aluguel;
            casa.proprietario.saldo += casa.aluguel;
            System.out.println(nome + " pagou R$" + casa.aluguel + " de aluguel para " + casa.proprietario.nome);
        } else {
            System.out.println(nome + " não tem saldo suficiente para pagar aluguel.");
        }
    }
}













