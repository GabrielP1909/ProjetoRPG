package projetorpgcsl;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Personagem> personagens = new ArrayList<>();

    public void iniciar() {
        int escolha=0;
        do{
            System.out.println("\n===== RPG CSL =====");
            System.out.println("Deseja jogar?");
            System.out.println("1) Sim");
            System.out.println("2) Não");
            System.out.print("Escolha: ");
            if(scanner.hasNextInt()){
                escolha=scanner.nextInt();
                scanner.nextLine();
                if(escolha==1) menuPrincipal();
                else if(escolha==2) System.out.println("Obrigado por jogar!");
            }else{
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }while(escolha!=1 && escolha!=2);
    }

    private void menuPrincipal(){
        int opcao=0;
        do{
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1) Criar personagem");
            System.out.println("2) Listar personagens");
            System.out.println("3) Batalhar");
            System.out.println("4) Exibir status");
            System.out.println("5) Gerenciar inventário");
            System.out.println("6) Encerrar");
            System.out.print("Escolha: ");
            if(scanner.hasNextInt()){
                opcao=scanner.nextInt();
                scanner.nextLine();
                switch(opcao){
                    case 1: criarPersonagem(); break;
                    case 2: listarPersonagens(); break;
                    case 3: batalha(); break;
                    case 4: exibirStatus(); break;
                    case 5: gerenciarInventario(); break;
                    case 6: System.out.println("Encerrando jogo..."); break;
                    default: System.out.println("Opção inválida!"); break;
                }
            }else{
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }while(opcao!=6);
    }

    private void criarPersonagem(){
        System.out.print("Nome do personagem: ");
        String nome = scanner.nextLine();
        int escolhaClasse=0;
        do{
            System.out.println("Escolha a classe:");
            System.out.println("1) Guerreiro");
            System.out.println("2) Mago");
            System.out.println("3) Arqueiro");
            System.out.println("4) Assassino");
            System.out.println("5) Clérigo");
            if(scanner.hasNextInt()){
                escolhaClasse=scanner.nextInt();
                scanner.nextLine();
                Personagem p=null;
                switch(escolhaClasse){
                    case 1: p=new Guerreiro(nome); break;
                    case 2: p=new Mago(nome); break;
                    case 3: p=new Arqueiro(nome); break;
                    case 4: p=new Assassino(nome); break;
                    case 5: p=new Clerigo(nome); break;
                    default: System.out.println("Classe inválida"); continue;
                }
                p.inventario.adicionarItem(new Item("Poção Pequena","cura",20));
                personagens.add(p);
                System.out.println("Personagem criado: "+p.nome+" ("+p.classe+")");
                break;
            }else{
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }while(true);
    }

    private void listarPersonagens(){
        if(personagens.isEmpty()) System.out.println("Nenhum personagem criado.");
        else for(Personagem p:personagens) p.exibirStatus();
    }

    private void exibirStatus(){
        if(personagens.isEmpty()) System.out.println("Nenhum personagem criado.");
        else personagens.get(0).exibirStatus();
    }

    private void gerenciarInventario(){
        if(personagens.isEmpty()){ System.out.println("Crie um personagem primeiro."); return; }
        Personagem p=personagens.get(0);
        p.inventario.listarItens();
    }

    private void batalha(){
        if(personagens.isEmpty()){ System.out.println("Crie um personagem primeiro."); return; }
        Personagem p=personagens.get(0);
        Inimigo inimigo = Inimigo.gerarAleatorio();
        System.out.println("\n===== BATALHA =====");
        System.out.println(p.nome+" VS "+inimigo.nome);

        while(p.estaVivo() && inimigo.estaVivo()){
            System.out.println("\nSua vida: "+p.vida+" | Vida inimigo: "+inimigo.vida);
            System.out.println("Escolha ação:");
            System.out.println("1) Usar poder");
            System.out.println("2) Usar item");
            int escolha=scanner.nextInt();
            scanner.nextLine();
            if(escolha==1){
                System.out.println("Escolha o poder:");
                for(int i=0;i<p.poderes.size();i++){
                    System.out.println((i+1)+") "+p.poderes.get(i).getNome());
                }
                int idx=scanner.nextInt()-1;
                scanner.nextLine();
                p.atacar(inimigo,idx);
            }else if(escolha==2){
                p.inventario.listarItens();
                System.out.print("Escolha índice do item: ");
                int idx=scanner.nextInt()-1;
                scanner.nextLine();
                Item it=p.inventario.usarItem(idx);
                if(it!=null) it.usar(p);
                else System.out.println("Índice inválido");
            }

            if(inimigo.estaVivo()) inimigo.atacar(p,0);
        }

        if(p.estaVivo()){
            System.out.println("Você venceu a batalha!");
            p.inventario.adicionarItem(new Item("Poção de Cura","cura",30));
        }else System.out.println("Você perdeu a batalha!");
    }
}