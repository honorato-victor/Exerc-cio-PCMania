package pcmania.main;

import pcmania.model.Cliente;
import pcmania.model.Computador;
import pcmania.model.MemoriaUSB;
import pcmania.util.ProcessarPedido;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        Cliente cliente = new Cliente("Victor Honorato", "123.456.789-00");
        float matricula = 9877; 

        System.out.println("Bem-vindo à PC Mania!");

        while (true) {
            System.out.println("\nMenu de Compras:");
            System.out.println("1 - Promoção 1 (Apple)");
            System.out.println("2 - Promoção 2 (Samsung)");
            System.out.println("3 - Promoção 3 (Dell)");
            System.out.println("0 - Finalizar e sair");
            System.out.print("Sua escolha: ");
            
            int opcao = entrada.nextInt();

            if (opcao == 0) {
                if (cliente.getQuantidadeComprada() < 2 && cliente.getQuantidadeComprada() > 0) {
                    System.out.println(">> ATENÇÃO: A regra da loja exige a compra de no mínimo 2 PCs.");
                } else {
                    break; 
                }
            } else if (opcao == 1) {
                Computador pc = new Computador("Apple", matricula, "macOS Sequoia", 64, 
                                               "Pentium Core i5", 2200, 
                                               "Memória RAM", 8, 
                                               "HD", 500);
                
                pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
                cliente.comprarPC(pc);
                System.out.println(">> PC Apple adicionado ao carrinho!");

            } else if (opcao == 2) {
                Computador pc = new Computador("Samsung", matricula + 1, "Windows 8", 64, 
                                               "Pentium Core i7", 3370, 
                                               "Memória RAM", 16, 
                                               "HD", 1000);
                
                pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
                cliente.comprarPC(pc);
                System.out.println(">> PC Samsung adicionado ao carrinho!");

            } else if (opcao == 3) {
                Computador pc = new Computador("Dell", matricula + 2, "Windows 10", 64, 
                                               "Pentium Core i7", 4500, 
                                               "Memória RAM", 32, 
                                               "HD", 2000);
                
                pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1));
                cliente.comprarPC(pc);
                System.out.println(">> PC Dell adicionado ao carrinho!");

            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        if (cliente.getQuantidadeComprada() >= 2) {
            System.out.println("        RESUMO DA COMPRA");
            System.out.println("Cliente: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
            System.out.println();
            
            Computador[] comprados = cliente.getPcs();
            for (int i = 0; i < comprados.length; i++) {
                if (comprados[i] != null) {
                    comprados[i].mostraPCConfigs();
                    System.out.println();
                }
            }
            
            System.out.printf("Total a pagar: R$ %.2f\n", cliente.calculaTotalCompra());
            ProcessarPedido.helper(cliente.getPcs());
        } else {
            System.out.println("\nNenhuma compra foi efetivada.");
        }
        
        entrada.close();
    }
}
