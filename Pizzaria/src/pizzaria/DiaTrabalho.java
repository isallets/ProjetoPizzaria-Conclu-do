
package pizzaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DiaTrabalho {
    private int id;
    private LocalDate data;
    private List<Pedidos> pedidos;
    
    public DiaTrabalho(int id, LocalDate data, List<Pedidos> pedidos) {
        this.id = id;
        this.data = data;
        this.pedidos = pedidos;
    }
    
    
    public DiaTrabalho(int id) {
        this.id = id;
        this.pedidos = new ArrayList<>();
    }
    
    public DiaTrabalho(int id, LocalDate data) {
        this.id = id;
        this.data = data;
    }
   
    public DiaTrabalho(int id, List<Pedidos> pedidos) {
        this.id = id;
        this.pedidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = new ArrayList<>();
    }
    
    public void adicionarPedido(Pedidos pedido) {
        if (this.pedidos == null) {
        this.pedidos = new ArrayList<>();
        }
    this.pedidos.add(pedido);
    }
    
    
}
