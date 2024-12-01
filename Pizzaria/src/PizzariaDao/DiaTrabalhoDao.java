
package PizzariaDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pizzaria.DiaTrabalho;


public class DiaTrabalhoDao {
    private List<DiaTrabalho> databaseDiaTrabalho=new ArrayList();
    
    public void adicionarDiaTrabalho(DiaTrabalho d){
        databaseDiaTrabalho.add(d);
    }
        
    public List<LocalDate> listarTodosDiaTrabalho() {
        List<LocalDate> report = new ArrayList<>();
        
        for (DiaTrabalho data : databaseDiaTrabalho) {
            report.add(data.getData());
        }
        return report;
    }
    
    public boolean atualizarDataPorId(int id, LocalDate novaData) {
        for (DiaTrabalho dia : databaseDiaTrabalho) {
            if (dia.getId() == id) {
                dia.setData(novaData); 
                return true;          
            }
        }
        return false; 
    }
    
    public boolean deletarDiaTrabalhoPorId(int id) {
        for (DiaTrabalho dt : databaseDiaTrabalho) {
            if (dt.getId() == id) {
                dt.getPedidos().clear(); 
                databaseDiaTrabalho.remove(dt);
                return true; 
            }
        }
        return false;
    }
    
    public List<LocalDate> listarDiaTrabalho(int id) {
        List<LocalDate> report = new ArrayList<>();
        
        for (DiaTrabalho data : databaseDiaTrabalho) {
            if(data.getId()==id)
                report.add(data.getData());
        }
        return report;
    }
    
}
