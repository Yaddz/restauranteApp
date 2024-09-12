import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<ItemMenu> itens = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        // Initializing menu items
        itens.add(new ItemMenu("Macarrão", "Comida", 35.00));
        itens.add(new ItemMenu("Hamburguer", "Comida", 30.00));

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("[1] Cadastrar Cliente");
                System.out.println("[2] Visualizar Menu");
                System.out.println("[3] Fazer Pedido");
                System.out.println("[4] Acompanhar Pedido");
                System.out.println("[5] Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                switch (opcao) {
                    case 1:
                        // Register a new customer
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.println("Endereco: ");
                        String endereco = scanner.nextLine();
                        clientes.add(new Cliente(nome, telefone, endereco));
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;

                    case 2:
                        // View the menu
                        System.out.println("Menu:");
                        for (ItemMenu item : itens) {
                            System.out.println(item);
                        }
                        break;

                    case 3:
                        // Make an order
                        if (clientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado!");
                            continue;
                        }

                        System.out.println("Escolha um cliente:");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + clientes.get(i));
                        }

                        int clienteIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Limpa o buffer

                        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                            System.out.println("Cliente inválido!");
                            continue;
                        }

                        Cliente cliente = clientes.get(clienteIndex);
                        Pedido pedido = new Pedido(cliente);

                        while (true) {
                            System.out.println("Escolha um item para adicionar ao pedido:");
                            for (int i = 0; i < itens.size(); i++) {
                                System.out.println("[" + (i + 1) + "] " + itens.get(i));
                            }
                            System.out.println("[0] Finalizar Pedido");

                            int itemIndex = scanner.nextInt() - 1;
                            scanner.nextLine(); // Limpa o buffer

                            if (itemIndex == -1) {
                                break;
                            }

                            if (itemIndex < 0 || itemIndex >= itens.size()) {
                                System.out.println("Item inválido!");
                                continue;
                            }

                            ItemMenu item = itens.get(itemIndex);
                            pedido.adicionarItem(item);
                            System.out.println("Item adicionado ao pedido.");
                        }

                        pedidos.add(pedido);
                        System.out.println("Pedido realizado com sucesso!");
                        System.out.println(pedido);
                        break;

                    case 4:
                        // Track an order
                        if (pedidos.isEmpty()) {
                            System.out.println("Nenhum pedido realizado.");
                            continue;
                        }

                        System.out.println("Pedidos realizados:");
                        for (int i = 0; i < pedidos.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + pedidos.get(i));
                        }

                        System.out.print("Escolha um pedido para visualizar: ");
                        int pedidoIndex = scanner.nextInt() - 1;
                        scanner.nextLine(); // Limpa o buffer

                        if (pedidoIndex < 0 || pedidoIndex >= pedidos.size()) {
                            System.out.println("Pedido inválido!");
                            continue;
                        }

                        System.out.println("Detalhes do pedido:");
                        System.out.println(pedidos.get(pedidoIndex));
                        break;

                    case 5:
                        // Exit
                        System.out.println("Saindo...");
                        return;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }
}
