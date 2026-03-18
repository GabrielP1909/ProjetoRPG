package projetorpgcsl;

public class Clerigo extends Personagem {
    public Clerigo(String nome) {
        super(nome,"Clérigo",110,15);
        poderes.add(new Poder("Cura","Recupera vida do aliado ou próprio",0,30,0));
        poderes.add(new Poder("Luz Sagrada","Dano + chance de atordoar",20,0,0.2));
        poderes.add(new Poder("Proteção Divina","Reduz dano recebido",0,0,0));
        poderes.add(new Poder("Martelo Sagrado","Ataque forte",25,0,0.2));
        poderes.add(new Poder("Oração","Recupera vida gradual por turnos",0,15,0));
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