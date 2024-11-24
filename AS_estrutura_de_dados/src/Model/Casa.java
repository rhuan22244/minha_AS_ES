package Model;

public class Casa {
    public String nome;
    public String tipo;  // "Imóvel", "Prisão", "Sorte", "Revés"
    double valor;
    double aluguel;
    Jogador proprietario;

    public Casa(String nome, String tipo, double valor, double aluguel) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.aluguel = aluguel;
    }

    public Casa(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Jogador getProprietario() {
        return proprietario;
    }

    public double efeitoCasa() {
        if (this.tipo.equals("Sorte")) {
            return 1000;
        } else if (this.tipo.equals("Revés")) {
            return -1000;
        }
        return 0;
    }
}













