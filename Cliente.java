package pcmania.model;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] pcs;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pcs = new Computador[10]; 
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Computador[] getPcs() {
        return pcs;
    }

    public void comprarPC(Computador c) {
        for (int i = 0; i < pcs.length; i++) {
            if (pcs[i] == null) {
                pcs[i] = c;
                break;
            }
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < pcs.length; i++) {
            if (pcs[i] != null) {
                total += pcs[i].getPreco();
            }
        }
        return total;
    }

    public int getQuantidadeComprada() {
        int cont = 0;
        for (int i = 0; i < pcs.length; i++) {
            if (pcs[i] != null) {
                cont++;
            }
        }
        return cont;
    }
}
