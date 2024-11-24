package Board;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private List<Casa> casas;

    public Tabuleiro() {
        this.casas = new ArrayList<>();
    }

    public void adicionarCasa(Casa casa) {
        casas.add(casa);
    }

    public Casa getCasa(int posicao) {
        return casas.get(posicao % casas.size());
    }
}


















