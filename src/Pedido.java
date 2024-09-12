public class Pedido {
    private Item[] itens;
    private int count;

    public Pedido(int tamanho) {
        itens = new Item[tamanho];  // Initialize array with specified size
        count = 0;
    }

    public void adicionarItem(Item item) {
        if (count < itens.length) {  // Correct length property
            itens[count++] = item;
        } else {
            System.out.println("O quadro de itens está cheio. Não é possível adicionar mais itens.");
        }
    }

    // Calcula o total do pedido
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {  // Correct loop syntax
            total += itens[i].getPreco();  // Ensure method name is correct
        }
        return total;
    }

    // Exibe os itens do pedido
    public void exibirItens() {
        System.out.println("Itens do pedido:");
        for (int i = 0; i < count; i++) {
            System.out.println(itens[i]);  // Assumes Item class has a proper toString method
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        for (int i = 0; i < count; i++) {
            sb.append(itens[i].toString()).append("\n");  // Assumes Item class has a proper toString method
        }
        sb.append("Total: ").append(calcularTotal());
        return sb.toString();
    }
}
