package projetorpgcsl;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome,"Guerreiro",150,20);
        poderes.add(new Poder("Golpe Feroz","Ataque poderoso com chance de crítico",25,0,0.2));
        poderes.add(new Poder("Berserk","Aumenta ataque temporariamente",0,0,0));
        poderes.add(new Poder("Investida","Ataque rápido que pode atordoar",20,0,0.15));
        poderes.add(new Poder("Defesa Firme","Reduz dano recebido",0,0,0));
        poderes.add(new Poder("Ataque Giratório","Ataca todos os inimigos",15,0,0.1));
    }

    @Override
    public void atacar(Personagem alvo, int indicePoder) {
        if(indicePoder>=0 && indicePoder<poderes.size()){
            poderes.get(indicePoder).usar(this, alvo);
        } else {
            System.out.println("Poder inválido!");
        }
    }
}