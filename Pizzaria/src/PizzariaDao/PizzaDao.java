
package PizzariaDao;

import java.util.ArrayList;
import java.util.List;
import pizzaria.Pizza;

public class PizzaDao{
    private List<Pizza> databasePizza=new ArrayList();
    
    public void adicionarPizza(Pizza p){
        databasePizza.add(p);
    }

    public List<Pizza> getDatabasePizza() {
        return databasePizza;
    }

    public void setDatabasePizza(List<Pizza> databasePizza) {
        this.databasePizza = databasePizza;
    }
    
    public Pizza listarPizzaPorId(int id){
        for(Pizza p : databasePizza){
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
    public boolean atualizaPizza(Pizza p){
        Pizza existeP=listarPizzaPorId(p.getId());
        if(existeP!=null){
            existeP.setPreco(p.getPreco());
            existeP.setIngredientes(p.getIngredientes());
            existeP.setQuantidade(p.getQuantidade());
            return true;
        }
        return false;
    }
    
    public boolean deletarPizza(Pizza p){
        Pizza existeP=listarPizzaPorId(p.getId());
        if(existeP!=null){
            databasePizza.remove(p);
            return true;
        }
        return false;
    }
    
    public String listarTodasPizzas(){
        String report="";
        for(Pizza p: databasePizza){
            report+=p.getId()+"\n";
            report+=p.getNome()+"\n";
            report+=p.getIngredientes()+"\n";
            report+=p.getPreco()+"\n";
            report+=p.getQuantidade() +"\n";
        }
        return report;
    }
    
  

}
