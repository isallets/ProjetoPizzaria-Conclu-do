
package pizzaria;

public abstract class Pizza {
    private int id;
    private String nome;
    private String ingredientes;
    private double preco;
    private int quantidade;

    public Pizza(int id, String nome, String ingredientes, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "\nID do Sabor: " + id + ", \nSabor:" + getNome() + ", \nPreco:" + getPreco()+ ", \nQuantidade:"+ getQuantidade()+"\n\n";
    }

}