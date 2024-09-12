public class ItemMenu {
    private String nome;
    private String categoria;
    private double preco;

    //Construct
    public ItemMenu(String nome, String categoria, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public String getnome(){
        return nome;
    }

    public String getcategoria() {
        return categoria;
    }

    public double getpreco() {
        return preco;
    }

    public void getDetalhesItem () {
        System system = null;
        System.out.println("Categoria: "+categoria + "\n"+ nome + "R$: "+preco);
    }
}