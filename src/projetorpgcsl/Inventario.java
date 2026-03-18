package projetorpgcsl;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens = new ArrayList<>();

    public void adicionarItem(Item i) {
        itens.add(i);
    }

    public void listarItens() {
        if(itens.isEmpty()) System.out.println("Inventário vazio");
        else {
            for(int i=0;i<itens.size();i++){
                System.out.print((i+1)+")"+itens.get(i).getNome()+" ");
            }
            System.out.println();
        }
    }

    public Item usarItem(int indice){
        if(indice>=0 && indice<itens.size()) return itens.remove(indice);
        return null;
    }
}