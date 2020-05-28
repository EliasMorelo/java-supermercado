package supermercado;

import java.util.Random;
import javax.swing.JOptionPane;

public class SuperMercado {

    //Vector estatico de objetos, de tipo Producto
    static Producto[] vecProducto;
    static Random rnd = new Random();

    public static void registrarProductos(Producto prod) {
        prod.setNomprod(JOptionPane.showInputDialog("Ingrese el nombre del producto"));
        int cant = (int) (rnd.nextDouble() * 12 + 1);
        prod.setCant(cant);
        float precio = rnd.nextFloat() * 26000;
        prod.setPrecioU(precio);
        prod.setTotal(prod.getCant() * prod.getPrecioU());
    }

    public static void main(String[] args) {
        int opcion = 0, tam = 0;
        double totalRecaudado = 0,
                promedioRecaudo = 0;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer?"
                    + "\n1. Registrar tamaño del vector y productos de cada posición."
                    + "\n2. Mostrar todos los productos Ordenado Ascendentemente por Precio Unitario."
                    + "\n3. Mostrar estadísticas: Promedio recaudo, total recaudado."
                    + "\n4. Mostrar producto (Toda la información)"
                    + "\n5. Mostrar la cantidad de productos que tiene menor y mayor valor total del Promedio"
                    + "\n6. Salir"));
            switch (opcion) {
                case 1:
                    tam = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del vector"));
                    vecProducto = new Producto[tam];
                    for (int i = 0; i < vecProducto.length; i++) {
                        Producto prod = new Producto();
                        registrarProductos(prod);
                        vecProducto[i] = prod;
                    }
                    break;
                case 2:
                    Producto aux = new Producto();
                    for (int i = 0; i < vecProducto.length; i++) {
                        for (int j = 0; j < vecProducto.length; j++) {
                            if (vecProducto[i].getPrecioU() < vecProducto[j].getPrecioU()) {
                                aux = vecProducto[i];
                                vecProducto[i] = vecProducto[j];
                                vecProducto[j] = aux;
                            }
                        }
                    }
                    String mensaje = "";
                    for (int j = 0; j < vecProducto.length; j++) {
                        mensaje += "Nombre del producto: " + vecProducto[j].getNomprod()
                                + "\u2000 Cantidad del producto: " + vecProducto[j].getCant()
                                + "\u2000 Precio unitario: " + vecProducto[j].getPrecioU()
                                + "\u2000 Total: " + vecProducto[j].getTotal() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "PRODUCTOS\n\n" + mensaje);
                    break;
                case 3:
                    for (int i = 0; i < vecProducto.length; i++) {
                        totalRecaudado += vecProducto[i].getTotal();
                        promedioRecaudo += (totalRecaudado / vecProducto.length);
                    }
                    JOptionPane.showMessageDialog(null, "Cantidad total recaudada: " + totalRecaudado
                            + "\nPromedio Recaudo: " + promedioRecaudo);
                    break;
                case 4:
                    float valMa = 0,
                     valMe = 9999;
                    String mayor = "",
                     menor = "",
                     lista = "";
                    Producto prodMayor,
                     prodMenor;
                    for (int j = 0; j < vecProducto.length; j++) {
                        if (vecProducto[j].getCant() >= valMa) {
                            valMa = vecProducto[j].getCant();
                            prodMayor = vecProducto[j];
                            mayor = prodMayor.getNomprod();
                        }
                    }
                    for (int j = 0; j < vecProducto.length; j++) {
                        if (vecProducto[j].getCant() <= valMe) {
                            valMe = vecProducto[j].getCant();
                            prodMenor = vecProducto[j];
                            menor = prodMenor.getNomprod();
                        }

                    }
                    for (int j = 0; j < vecProducto.length; j++) {
                        lista += "Nombre del producto: " + vecProducto[j].getNomprod()
                                + "\u2000 Cantidad del producto: " + vecProducto[j].getCant()
                                + "\u2000 Precio unitario: " + vecProducto[j].getPrecioU()
                                + "\u2000 Total: " + vecProducto[j].getTotal() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "PRODUCTOS\n\n" + lista
                            + "TOTAL RECAUDADO: " + totalRecaudado + "\u2000 PROMEDIO RECAUDO: " + promedioRecaudo + "\n"
                            + "\nPRODUCTO CON MAYOR CANTIDAD DISPONIBLE: " + mayor
                            + "\nPRODUCTO CON MENOR CANTIDAD DISPONIBLE: " + menor);
                    break;
                case 5:
                    float totalMa = 0,
                     totalMe = 9999;
                    String mayorT = "",
                     menorT = "",
                     listaT = "";
                    Producto totalMayor,
                     totalMenor;
                    for (int j = 0; j < vecProducto.length; j++) {
                        if (vecProducto[j].getTotal() >= totalMa) {
                            totalMa = vecProducto[j].getTotal();
                            totalMayor = vecProducto[j];
                            mayorT="La cantidad de productos de mayor total en el promedio es: "+totalMayor.getCant();
                        }
                    }
                    for (int j = 0; j < vecProducto.length; j++) {
                        if (vecProducto[j].getCant() <= totalMe) {
                            totalMe = vecProducto[j].getCant();
                            totalMenor = vecProducto[j];
                            menorT="La cantidad de productos de menor total en el promedio es: "+totalMenor.getCant();
                        }

                    } 
                    
                    JOptionPane.showMessageDialog(null, mayorT+"\n"+menorT);
                    break;
            }
        } while (opcion <= 5);
    }

}
