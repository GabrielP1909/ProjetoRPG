package projetorpgcsl;

import java.util.ArrayList;

public abstract class Personagem {
    protected String nome;
    protected String classe;
    protected int vida;
    protected int vidaMax;
    protected int ataque;
    protected ArrayList<Poder> poderes = new ArrayList<>();
    protected Inventario inventario = new Inventario();

    public Personagem(String nome, String classe, int vida, int ataque) {
        this.nome = nome;
        this.classe = classe;
        this.vida = vida;
        this.vidaMax = vida;
        this.ataque = ataque;
    }

    // Polimorfismo: cada subclasse implementa atacar
    public abstract void atacar(Personagem alvo, int indicePoder);

    public boolean estaVivo() {
        return vida > 0;
    }

    public void exibirStatus() {
        System.out.println("-----------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Classe: " + classe);
        System.out.println("Vida: " + vida + "/" + vidaMax);
        System.out.println("Ataque base: " + ataque);
        System.out.println("Poderes:");
        for(int i=0;i<poderes.size();i++){
            System.out.println((i+1) + ") " + poderes.get(i).getNome() + " - " + poderes.get(i).getDescricao());
        }
        System.out.println("Inventário:");
        inventario.listarItens();
        System.out.println("-----------------------------");
    }
}