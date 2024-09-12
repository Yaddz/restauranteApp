import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<ItemMenu> itens = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    public static void main(String[] args) {
        itens.add(new ItemMenu("Macarrão","Comida", 35.00));
        itens.add(new ItemMenu("Hamburguer", "Comida", 30.00));

        Scanner.scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[1] Cadastrar Cliente");
            System.out.println("[2] Visualizar Menu");
            System.out.println("[3] Fazer Pedido");
            System.out.println("[4] Acompanhar Pedido");
            System.out.printf("Escolha uma opção:");
        }

    }
}
