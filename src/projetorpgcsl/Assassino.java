package projetorpgcsl;

public class Assassino extends Personagem {
    public Assassino(String nome) {
        super(nome,"Assassino",90,20);
        poderes.add(new Poder("Ataque Furtivo","Dano alto quando inimigo não atacou ainda",28,0,0.3));
        poderes.add(new Poder("Veneno Mortal","Dano por turno",10,0,0.2));
        poderes.add(new Poder("Dança das Lâminas","Ataca múltiplos inimigos",15,0,0.1));
        poderes.add(new Poder("Esquiva","Evita próximo ataque",0,0,0));
        poderes.add(new Poder("Golpe Crítico","Ataque certeiro com chance crítica",25,0,0.25));
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