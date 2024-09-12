import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<ItemMenu> itens = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        itens.add(new ItemMenu("Macarrão", "Comida", 35.00));
        itens.add(new ItemMenu("Hamburguer", "Comida", 30.00));
        itens.add(new ItemMenu("Pizza", "Comida", 45.00));
        itens.add(new ItemMenu("Coca-Cola", "Bebida", 8.00));
        itens.add(new ItemMenu("Água", "Bebida", 5.00));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n==============================");
            System.out.println("         Menu Principal        ");
            System.out.println("==============================");
            System.out.println("[1] Cadastrar Cliente");
            System.out.println("[2] Visualizar Menu");
            System.out.println("[3] Fazer Pedido");
            System.out.println("[4] Acompanhar Pedido");
            System.out.println("[5] Sair");
            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n==============================");
                    System.out.println("   Cadastro de Novo Cliente    ");
                    System.out.println("==============================");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    clientes.add(new Cliente(nome, telefone, endereco));
                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.println("\n==============================");
                    System.out.println("          Menu do Dia          ");
                    System.out.println("==============================");
                    for (ItemMenu item : itens) {
                        System.out.println(item);
                    }
                    System.out.println();
                    break;

                case 3:
                    if (clientes.isEmpty()) {
                        System.out.println("\nNenhum cliente cadastrado! Por favor, cadastre um cliente antes de fazer um pedido.\n");
                        continue;
                    }

                    System.out.println("\nSelecione um cliente:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("[" + (i + 1) + "] " + clientes.get(i).getNome());
                    }

                    int clienteIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                        System.out.println("\nCliente inválido!\n");
                        continue;
                    }

                    Cliente cliente = clientes.get(clienteIndex);
                    System.out.println("\nCliente selecionado: " + cliente.getNome());

                    Pedido pedido = new Pedido(10);
                    pedido.setStatus("Em preparo");

                    while (true) {
                        System.out.println("\nEscolha um item para adicionar ao pedido:");
                        for (int i = 0; i < itens.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + itens.get(i));
                        }
                        System.out.println("[0] Finalizar Pedido");

                        int itemIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (itemIndex == -1) {
                            break;
                        }

                        if (itemIndex < 0 || itemIndex >= itens.size()) {
                            System.out.println("\nItem inválido!\n");
                            continue;
                        }

                        ItemMenu item = itens.get(itemIndex);
                        pedido.adicionarItem(item);
                        System.out.println("Item " + item.getNome() + " adicionado ao pedido.");
                    }

                    pedidos.add(pedido);
                    System.out.println("\nPedido realizado com sucesso!");
                    System.out.println(pedido);

                    new Thread(() -> {
                        try {
                            Thread.sleep(30000);
                            pedido.setStatus("Finalizado");
                            System.out.println("\nStatus do pedido atualizado: Finalizado\n");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    break;

                case 4:
                    if (pedidos.isEmpty()) {
                        System.out.println("\nNenhum pedido foi realizado até agora.\n");
                        continue;
                    }

                    System.out.println("\nPedidos realizados:");
                    for (int i = 0; i < pedidos.size(); i++) {
                        System.out.println("[" + (i + 1) + "] Pedido " + (i + 1));
                    }

                    System.out.print("\nEscolha um pedido para visualizar: ");
                    int pedidoIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (pedidoIndex < 0 || pedidoIndex >= pedidos.size()) {
                        System.out.println("\nPedido inválido!\n");
                        continue;
                    }

                    System.out.println("\nDetalhes do pedido:");
                    System.out.println(pedidos.get(pedidoIndex));
                    break;

                case 5:
                    System.out.println("\nSaindo...\n");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        }
    }
}
