
package pizzaria;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
    private int id;
    private List<Pizza> pizzas;
    Cliente cliente;

    public Pedidos(int id) {
        this.id = id;
        this.pizzas = new ArrayList<>();
    }
    public Pedidos(int id, List<Pizza> pizzas, Cliente cliente){
        this.id = id;
        this.pizzas = pizzas;
        this.cliente = cliente;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

  /*  
    public final double calcularTotal(){
        return pizzas.stream().mapToDouble(Pizza::getPreco).sum();
    }
    */
    public void adicionarCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void adicionarPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    
    @Override
    public String toString() {
        return "\nID do Sabor: " + id + ",\nPizzas:" + getPizzas()+", \nCliente:" + getCliente() + "\n\n";
    }


}
