package supermercado;

//Clase Producto de tipo POJO, en la que no se hereda nada de otras clases, interfaces o métodos
public class Producto {

    private String nomprod;
    private float cant;
    private float precioU;
    private float total; //Calculado cant * precioU  

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public float getCant() {
        return cant;
    }

    public void setCant(float cant) {
        this.cant = cant;
    }

    public float getPrecioU() {
        return precioU;
    }

    public void setPrecioU(float precioU) {
        this.precioU = precioU;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
