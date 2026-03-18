package projetorpgcsl;

public class Poder {
    private String nome;
    private String descricao;
    private int dano;
    private int cura;
    private double chanceCritico;

    public Poder(String nome, String descricao, int dano, int cura, double chanceCritico) {
        this.nome = nome;
        this.descricao = descricao;
        this.dano = dano;
        this.cura = cura;
        this.chanceCritico = chanceCritico;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void usar(Personagem usuario, Personagem alvo) {
        int danoFinal = dano;
        if(Math.random() < chanceCritico) {
            danoFinal *= 2;
            System.out.println("💥 CRÍTICO!");
        }
        if(danoFinal > 0) {
            alvo.vida -= danoFinal;
            System.out.println(usuario.nome + " usou " + nome + " em " + alvo.nome + " causando " + danoFinal + " de dano!");
            if(alvo.vida < 0) alvo.vida = 0;
        }
        if(cura > 0) {
            usuario.vida += cura;
            if(usuario.vida > usuario.vidaMax) usuario.vida = usuario.vidaMax;
            System.out.println(usuario.nome + " se curou " + cura + " de vida usando " + nome + "!");
        }
    }
}