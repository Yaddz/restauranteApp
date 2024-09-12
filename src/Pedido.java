public class Pedido {
    private ItemMenu[] itens;
    private int count;
    private String status;

    public Pedido(int tamanho) {
        itens = new ItemMenu[tamanho];
        count = 0;
        status = "Em preparo";
    }

    public void adicionarItem(ItemMenu item) {
        if (count < itens.length) {
            itens[count++] = item;
        } else {
            System.out.println("O quadro de itens está cheio. Não é possível adicionar mais itens.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += itens[i].getPreco();
        }
        return total;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido:\n");
        for (int i = 0; i < count; i++) {
            sb.append(itens[i].toString()).append("\n");
        }
        sb.append("Total: ").append(calcularTotal()).append("\n");
        sb.append("Status: ").append(status);
        return sb.toString();
    }
}
