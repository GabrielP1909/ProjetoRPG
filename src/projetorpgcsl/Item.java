package projetorpgcsl;

public class Item {
    private String nome;
    private String tipo; // "cura" ou "ataque"
    private int efeito;

    public Item(String nome, String tipo, int efeito) {
        this.nome = nome;
        this.tipo = tipo;
        this.efeito = efeito;
    }

    public String getNome() {
        return nome;
    }

    public void usar(Personagem p) {
        if(tipo.equals("cura")) {
            p.vida += efeito;
            if(p.vida > p.vidaMax) p.vida = p.vidaMax;
            System.out.println(p.nome + " recuperou " + efeito + " de vida!");
        } else if(tipo.equals("ataque")) {
            p.ataque += efeito;
            System.out.println(p.nome + " aumentou ataque em " + efeito + "!");
        }
    }
}