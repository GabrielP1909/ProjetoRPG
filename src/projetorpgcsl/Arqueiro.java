package projetorpgcsl;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome,"Arqueiro",120,18);
        poderes.add(new Poder("Flecha Precisa","Ataque certeiro",22,0,0.2));
        poderes.add(new Poder("Chuva de Flechas","Ataca vários inimigos",15,0,0.1));
        poderes.add(new Poder("Flecha Venenosa","Dano contínuo no inimigo",10,0,0.15));
        poderes.add(new Poder("Tiro Duplo","Dispara duas flechas de uma vez",18,0,0.2));
        poderes.add(new Poder("Tiro Crítico","Alto dano com chance de crítico",25,0,0.25));
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