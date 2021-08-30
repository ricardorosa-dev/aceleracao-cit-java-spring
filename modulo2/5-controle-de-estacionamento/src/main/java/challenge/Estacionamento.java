package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Carro> listaCarros = new ArrayList<>();
    private Integer numeroCarros = 0;

    public void estacionar(Carro carro) {
        if (carro.getMotorista().getPontos() > 20) {
            throw new EstacionamentoException("O motorista não pode ter mais de 20 pontos na carteira");
        }
        if (numeroCarros < 10) {
            numeroCarros++;
            listaCarros.add(carro);
        } else {
            boolean estacionou = false;
            for (int i = 0; i < listaCarros.size(); i++) {
                if (listaCarros.get(i).getMotorista().getIdade() < 55) {
                listaCarros.remove(i);
                listaCarros.add(carro);
                estacionou = true;
                }
            }
                if (estacionou == false) {
                    throw new EstacionamentoException("O estacionamento está lotado");
                }
        }
    }

    public int carrosEstacionados() {
        return numeroCarros;
    }

    public boolean carroEstacionado(Carro carro) {
        boolean carroEstaNaLista = false;

        for (Carro meuCarro : listaCarros) {
            if (carro == meuCarro) {
                carroEstaNaLista = true;
            }
        }
        return carroEstaNaLista;
    }
}
