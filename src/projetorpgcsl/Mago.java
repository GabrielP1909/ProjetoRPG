package projetorpgcsl;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome,"Mago",100,25);
        poderes.add(new Poder("Bola de Fogo","Ataque mágico potente",30,0,0.15));
        poderes.add(new Poder("Explosão Arcana","Ataque em área",20,0,0.25));
        poderes.add(new Poder("Relâmpago","Ataque rápido e certeiro",22,0,0.2));
        poderes.add(new Poder("Curar","Recupera parte da vida",0,25,0));
        poderes.add(new Poder("Barreira","Reduz dano recebido",0,0,0));
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