////////////////////////////////////////////////////////////////////
// [GIUSEPPE] [ZATTA] [1143326]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public final class MenuItem implements AbstractItem {

    private String nome;
    private double prezzo;
    private ItemType tipo;
    
    public MenuItem(ItemType Tipo ,String Nome, double Prezzo) throws RestaurantBillException {
        tipo = Tipo;
        if (Prezzo == 0) {
            throw new RestaurantBillException("Prezzo non valido");
        }
        if (Nome ==  null || Nome == "") {
            throw new RestaurantBillException("Nome non valido");
        }
        prezzo = Prezzo;
        nome = Nome;
    }
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }
    
    @Override
    public ItemType getTipo() {
        return tipo;
    }

}
