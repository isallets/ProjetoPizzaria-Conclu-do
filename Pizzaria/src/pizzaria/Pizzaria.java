
package pizzaria;

import PizzariaDao.DiaTrabalhoDao;
import PizzariaDao.PedidosDao;
import PizzariaDao.PizzaDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
@author Isabelle Lopes
@author Isabelly Andrade
*/

public class Pizzaria {
    public static void main(String[] args) {
        PizzaDao pizzadao = new PizzaDao();
        PedidosDao pedidosdao = new PedidosDao();
        DiaTrabalhoDao diatrabalhodao = new DiaTrabalhoDao();


        //criar pizzas
        Pizza pizza1 = new PizzaCalabresa(8);
        Pizza pizza2 = new PizzaNapolitana(3);

        pizzadao.adicionarPizza(pizza1);
        pizzadao.adicionarPizza(pizza2);

        System.out.println("***Cardápio de Pizzas***\n" + pizzadao.listarTodasPizzas());
       /*
        //deletar pizzas
        System.out.println("***Exclua uma Pizza do Cardápio***\n" + pizzadao.listarTodasPizzas());

        Pizza pizzasDE=pizzadao.listarPizzaPorId(2);

        if(pizzadao.deletarPizza(pizzasDE))
        System.out.println("Excluido com sucesso!!");
        else 
        System.out.println("Exclusao nao realizada...");

        //atualizar pizzas -- apenas as quantidades
        System.out.println("***Atualize a quantidade de uma Pizza do Cardápio***\n" + pizzadao.listarTodasPizzas());

        Pizza pizzaUP=new PizzaCalabresa(5);
        pizzadao.atualizaPizza(pizzaUP);
        System.out.println("*Pizza com a quantidade atualizada!!*\n" + pizzadao.listarTodasPizzas());
        */
        
        //criar cliente
        Cliente cliente1 = new Cliente(1, "Carlos");

        Cliente cliente2 = new Cliente(2, "Roberto");
        //pedidos
        Pedidos pedidos1 = new Pedidos(1);
        Pedidos pedidos2 = new Pedidos(2);

        //criar pedidos
        pedidos1.adicionarCliente(cliente1);
        pedidos1.adicionarPizza(pizza1);
        pedidos1.adicionarPizza(pizza1);
        pedidosdao.adicionarPedidos(pedidos1);

        pedidos2.adicionarCliente(cliente2);
        pedidos2.adicionarPizza(pizza2);
        pedidos2.adicionarPizza(pizza1);
        pedidosdao.adicionarPedidos(pedidos2);

        //listar pedidos
        System.out.println("***Lista de Pedidos:*** \n" + pedidosdao.listarTodasPedidos());
        /*
        //deletar pedidos
        Pedidos pedidosDE=pedidosdao.listarPedidos(2);

        if(pedidosdao.deletarPedidos(pedidosDE)){
            System.out.println("Excluido com sucesso!!");
            System.out.println(pedidosdao.listarTodasPedidos());
        }
        else 
            System.out.println("Exclusao nao realizada...");

        //atualizar pedidos
        Pedidos pedidosUP = new Pedidos(1, pedidos2.getPizzas() , cliente2);
        pedidosdao.atualizaPedidos(pedidosUP);
        System.out.println("***Pedido atualizado***\n" + pedidosdao.listarPedidos(1));
        
        
        //listar pedidos por cliente
        System.out.println("***Pedidos do Cliente***");
        for (Pedidos pedido : pedidosdao.listarPedidosPorCliente(cliente1)) {
            System.out.println("\n" + pedido.getCliente()+",\nPedido ID: "+ pedido.getId() + ", \nPizzas: " + pedido.getPizzas());
        }
        
        System.out.println("***Pedidos do Cliente***");
        for (Pedidos pedido : pedidosdao.listarPedidosPorCliente(cliente2)) {
            System.out.println("\n" + pedido.getCliente()+",\nPedido ID: "+ pedido.getId() + ", \nPizzas: " + pedido.getPizzas());
        }
        */
        
        //cria um data
        LocalDate novaData1 = LocalDate.of(2024, 11, 28);
        LocalDate novaData2 = LocalDate.of(2024, 11, 29);

        DiaTrabalho diaTrabalho1 = new DiaTrabalho(20241128, novaData1);
        DiaTrabalho diaTrabalho2 = new DiaTrabalho(20241129, novaData2);

        //adiciona os pedidos na datas
        diaTrabalho1.adicionarPedido(pedidos2);
        diatrabalhodao.adicionarDiaTrabalho(diaTrabalho1);
        diaTrabalho2.adicionarPedido(pedidos2);
        diaTrabalho2.adicionarPedido(pedidos1);
        diatrabalhodao.adicionarDiaTrabalho(diaTrabalho2);
       
        //lista os pedidos de um dia específico
        System.out.println("\n***Pedidos do dia***\n" + diaTrabalho2.getData() + ":\n");
            for (Pedidos pedido : diaTrabalho2.getPedidos()) {
                System.out.println("\n*Pedidos Completos:*\n" + pedido.getId() + "," + pedido.getPizzas() + "Cliente:" + pedido.getCliente());
        }

        //listar as datas
        System.out.println("\n***Datas com Pedidos***");

        List<LocalDate> datas = diatrabalhodao.listarTodosDiaTrabalho();

        for (LocalDate data : datas) {
            System.out.println("Data: " + data);       
        }
        /*
        //deletar dia trabalho
        System.out.println("\n***Exclua um Dia Trabalhado***");

        List<LocalDate> diasTrabalhoDE = diatrabalhodao.listarTodosDiaTrabalho();
   
        for (LocalDate data : diasTrabalhoDE) {
            System.out.println("Data: " + data);       
        }
        diatrabalhodao.deletarDiaTrabalhoPorId(20241128);

        System.out.println("\nDias restantes:");
        diatrabalhodao.listarTodosDiaTrabalho().forEach(System.out::println);
 
        System.out.println("\n***Pedidos do dia***\n" + diaTrabalho1.getData() + ":\n");
            for (Pedidos pedido : diaTrabalho1.getPedidos()) {
                System.out.println("\n*Pedidos Completos:*\n" + pedido.getId() + "," + pedido.getPizzas() + "Cliente:" + pedido.getCliente());
        }
    
        //atualizar dia trabalho
        boolean diasTrabalhoUP = diatrabalhodao.atualizarDataPorId(20241129, LocalDate.of(2024, 12, 1));
            if (diasTrabalhoUP) {
                System.out.println("Data atualizada com sucesso!");
            }else {
                System.out.println("Dia de trabalho não encontrado...");
        }
            
         System.out.println("***Pedidos do dia***\n" + diaTrabalho2.getData() + ":\n");
            for (Pedidos pedido : diaTrabalho2.getPedidos()) {
                System.out.println("\n*Pedidos Completos:*\n" + pedido.getId() + "," + pedido.getPizzas() + "Cliente:" + pedido.getCliente());
        }   
        */  
    
    }

} 





