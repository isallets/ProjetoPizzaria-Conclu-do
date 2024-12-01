
package PizzariaDao;

import java.util.ArrayList;
import java.util.List;
import pizzaria.Pedidos;

public class PedidosDao{
    private List<Pedidos> databasePedidos=new ArrayList();
    
    public void adicionarPedidos(Pedidos p){
        databasePedidos.add(p);
    }
    
    public Pedidos listarPedidos(int id){
        for(Pedidos p : databasePedidos){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
    public boolean atualizaPedidos(Pedidos p){
        Pedidos existeP=listarPedidos(p.getId());
        if(existeP!=null){
            existeP.setPizzas(p.getPizzas());
            existeP.setCliente(p.getCliente());
            
            return true;
        }
        return false;
    }
    
    public boolean deletarPedidos(Pedidos p){
        Pedidos existeP=listarPedidos(p.getId());
        if(existeP!=null){
            databasePedidos.remove(p);
            return true;
        }
        return false;
    }
    
    public String listarTodasPedidos(){
        String report="";
        for(Pedidos p: databasePedidos){
            report+=p.getId()+"\n";
            report+=p.getPizzas()+"\n";
            report+=p.getCliente()+"\n";
        }
        return report;
    }

}
