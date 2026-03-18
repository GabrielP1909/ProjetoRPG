package projetorpgcsl;

import java.util.Random;

public class Inimigo extends Personagem {
    public Inimigo(String nome,int vida,int ataque){
        super(nome,"Inimigo",vida,ataque);
        poderes.add(new Poder("Ataque Básico","Ataque simples",ataque,0,0.1));
        poderes.add(new Poder("Ataque Forte","Ataque mais potente",ataque+5,0,0.2));
    }

    @Override
    public void atacar(Personagem alvo, int indicePoder){
        Random r = new Random();
        int i = r.nextInt(poderes.size());
        poderes.get(i).usar(this,alvo);
    }

    public static Inimigo gerarAleatorio(){
        Random r = new Random();
        int tipo = r.nextInt(8);
        switch(tipo){
            case 0: return new Inimigo("Goblin",50,8);
            case 1: return new Inimigo("Orc",80,12);
            case 2: return new Inimigo("Esqueleto",60,10);
            case 3: return new Inimigo("Lobo Selvagem",70,11);
            case 4: return new Inimigo("Troll",100,14);
            case 5: return new Inimigo("Dragão",200,25);
            case 6: return new Inimigo("Necromante",150,20);
            case 7: return new Inimigo("Gigante de Pedra",250,30);
            default: return new Inimigo("Goblin",50,8);
        }
    }
}