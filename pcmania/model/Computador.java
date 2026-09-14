package pcmania.model;

public class Computador {
    private String marca;
    private float preco;
    private SistemaOperacional so;
    private HardwareBasico[] hardwares;
    private MemoriaUSB musb;

    public Computador(String marca, float preco, String nomeSo, int tipoSo, 
                      String procNome, float procCap, 
                      String ramNome, float ramCap, 
                      String hdNome, float hdCap) {
        this.marca = marca;
        this.preco = preco;
        this.so = new SistemaOperacional(nomeSo, tipoSo);
        
        this.hardwares = new HardwareBasico[3];
        this.hardwares[0] = new HardwareBasico(procNome, procCap);
        this.hardwares[1] = new HardwareBasico(ramNome, ramCap);
        this.hardwares[2] = new HardwareBasico(hdNome, hdCap);
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.musb = musb;
    }

    public float getPreco() {
        return preco;
    }

    public void mostraPCConfigs() {
        System.out.println("--- PC " + marca + " ---");
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("SO: " + so.getNome() + " (" + so.getTipo() + " bits)");
        
        for (int i = 0; i < hardwares.length; i++) {
            if (hardwares[i] != null) {
                String unidade = "";
                if (hardwares[i].getNome().contains("Pentium")) {
                    unidade = " Mhz";
                } else if (hardwares[i].getNome().contains("Memória") || hardwares[i].getNome().equals("HD")) {
                    unidade = " Gb";
                }
                
                int capacidadeInteira = (int) hardwares[i].getCapacidade();
                System.out.println("Hardware: " + hardwares[i].getNome() + " - " + capacidadeInteira + unidade);
            }
        }
        
        if (musb != null) {
            String unidadeUsb = musb.getNome().contains("HD") ? " Tb" : " Gb";
            System.out.println("Acompanha: " + musb.getNome() + " de " + musb.getCapacidade() + unidadeUsb);
        }
    }
}
