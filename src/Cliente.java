import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private String nome;
    private String telefone;
    private String endereco;

    private static List<Cliente> clientes = new ArrayList<>();
    public Cliente(String nome, String telefone, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String registrarCliente() {
        clientes.add(this);
        return "Cliente registrado com sucesso!";
    }

    public String visualizarCliente(){
        return "Nome: " + this.nome + "\n" +
                "Telefone: " + this.telefone + "\n" +
                "Endereço: " + this.endereco;
    }
}
