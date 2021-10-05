package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Controller.ClienteDAO;
import Model.Cliente;

public class Main {

	private static Scanner e;

	public static void main(String[] args) {
		
        e = new Scanner(System.in);
        ClienteDAO cd = new ClienteDAO();
        ArrayList<Cliente> clientes;
        Iterator<Cliente> it;
        
        int cod, op, numCampo, resp;
        String nome, cpf, ident;
        Cliente c = null, 
        		cliente = null;
		
		do {
            System.out.println("1-casdastrar");
            System.out.println("2-alterar");
            System.out.println("3-excluir");
            System.out.println("4-consultar");
            System.out.println("5-relatório");
            System.out.println("6 -Sair");
            System.out.println("opção: ");
            op = e.nextInt();
            e.skip("\n");
            try {
                switch (op) {
	                case 1:
	                    // Achamos o próximo código.
	                    cod = cd.proximoCodigo();
	
	                    System.out.println("Digite o nome:");
	                    nome = e.nextLine();
	                    System.out.println("Digite o cpf:");
	                    cpf = e.nextLine();
	                    System.out.println("Digite a identidade:");
	                    ident = e.nextLine();
	                    
	                    Cliente cli = new Cliente(cod, nome, cpf, ident);
	                    
	                    cd.incluir(cli);
	                    break; 
	                case 7:
	                	int cont = 1002;
	                    // Achamos o próximo código.
//	                    cod = cd.proximoCodigo();
	                	Cliente clic;
	                    while(cont < 2001) {
	                    	clic = new Cliente(cont, cont+"", cont+"", cont+"");
	                    	cd.incluir(clic);
	                    	cont++;
	                    }
	                    break; 
                    case 2:
                        System.out.println("Qual o código do cliente que você deseja alterar?");
                        cod = e.nextInt();
                        
                        clientes = cd.listar();
                        it = clientes.iterator();
                        c = null; 
                        cliente = null;
                        while(cliente == null && it.hasNext()){
                        	c = (Cliente)it.next();
                        	
                        	if(c.getCodigo() == cod){
                        		cliente = c; 
                        	}
                        }
                        
                        if(cliente != null){
                            System.out.println("--==[Dados Cadastrados]==--");
                            System.out.println("Código        : " + cliente.getCodigo());
                            System.out.println("1 - Nome      : " + cliente.getNome());
                            System.out.println("2 - C.P.F.    : " + cliente.getCpf());
                            System.out.println("3 - Identidade: " + cliente.getIdentidade());
                            System.out.println("\n\n");
                        }
                        
                        System.out.println("Qual número do campo que deseja alterar?");
                        numCampo = e.nextInt();
                        e.skip("\n");
                        
                        switch(numCampo){
                            case 1:
                                System.out.println("Digite o novo nome: ");
                                nome = e.nextLine();
                                
                                cliente.setNome(nome);
                                break;
                            case 2:
                                System.out.println("Digite o novo C.P.F.: ");
                                cpf = e.nextLine();

                                cliente.setCpf(cpf);
                                break;
                            case 3:
                                System.out.println("Digite a nova identidade: ");
                                ident = e.nextLine();
                                
                                cliente.setIdentidade(ident);
                        }
                        
                        // Mostra os dados do cliente já com a alteração.
                        if(cliente != null){
                            System.out.println("--==[Dados Cadastrados]==--");
                            System.out.println("Código        : " + cliente.getCodigo());
                            System.out.println("1 - Nome      : " + cliente.getNome());
                            System.out.println("2 - C.P.F.    : " + cliente.getCpf());
                            System.out.println("3 - Identidade: " + cliente.getIdentidade());
                            System.out.println("\n\n");
                            
                            cd.alterar(cliente);
                        }
                        break;
                    case 3:
                        System.out.println("Qual o código do cliente que você deseja excluir?");
                        cod = e.nextInt();
                        
                        clientes = cd.listar();
                        it = clientes.iterator();
                        c = null; 
                        cliente = null;
                        while(cliente == null && it.hasNext()){
                        	c = (Cliente)it.next();
                        	
                        	if(c.getCodigo() == cod){
                        		cliente = c; 
                        	}
                        }
                        
                        if(cliente != null){
                            System.out.println("--==[Dados Cadastrados]==--");
                            System.out.println("Código    : " + cliente.getCodigo());
                            System.out.println("Nome      : " + cliente.getNome());
                            System.out.println("C.P.F.    : " + cliente.getCpf());
                            System.out.println("Identidade: " + cliente.getIdentidade());
                            System.out.println("\n\n");

                            System.out.println("Confirma exclusão? (1-sim/2-não)");
                            resp = e.nextInt();
                            if(resp == 1){
                            	cd.apagar(cliente);
                                System.out.println("Exclusão efetuada com sucesso.");
                            }
                            else{
                                System.out.println("Exclusão não efetuada.");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Qual o código do cliente que você deseja consultar?");
                        cod = e.nextInt();
                        
                        clientes = cd.listar();
                        it = clientes.iterator();
                        c = null; 
                        cliente = null;
                        while(cliente == null && it.hasNext()){
                        	c = (Cliente)it.next();
                        	
                        	if(c.getCodigo() == cod){
                        		cliente = c; 
                        	}
                        }
                        
                        if(cliente != null){
                            System.out.println("--==[Dados Cadastrados]==--");
                            System.out.println("Código    : " + cliente.getCodigo());
                            System.out.println("Nome      : " + cliente.getNome());
                            System.out.println("C.P.F.    : " + cliente.getCpf());
                            System.out.println("Identidade: " + cliente.getIdentidade());
                            System.out.println("\n\n");
                        }
                        break;
                    case 5:
                        clientes = cd.listar();
                        it = clientes.iterator();
                        c = null; 
                        cliente = null;

                        System.out.println("\n\n--==[Relatório de Clientes]==--\n");
                        while(cliente == null && it.hasNext()){
                        	c = (Cliente)it.next();
                        	
                            System.out.println("Código    : " + c.getCodigo());
                            System.out.println("Nome      : " + c.getNome());
                            System.out.println("C.P.F.    : " + c.getCpf());
                            System.out.println("Identidade: " + c.getIdentidade());
                            System.out.println("\n");
                        }
                        System.out.println("--=****************************=--\n\n");
                }
            } catch (Exception ex) {
                System.out.println("ERRO NO BANCO: " + ex);
            }
        } while (op != 6);
		
		cd.fecharConexao();
	}
}
