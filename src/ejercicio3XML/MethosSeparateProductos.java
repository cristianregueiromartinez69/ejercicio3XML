package ejercicio3XML;

import serializacion2.Product;

import java.util.ArrayList;

/**
 * Clase auxiliar para recoger en arrays, los atributos del objeto producto
 * @author cristian
 * @version 1.0
 */
public class MethosSeparateProductos {

    /**
     * función para recoger en un array de strings, los codigos de los productos
     * @param productos un array de objetos de tipo producto
     * @return el array de codigos
     */
    public String [] getCodigoProductos(ArrayList <Product> productos) {

        //declaramos un array de codigos de los productos igual al tamaño del arraylist
        String [] codigoProductos = new String [productos.size()];

        /**
         * bucle para recorrer el arrayList
         * vamos añadiendo al array de Strings, el codigo de los productos
         */
        for (int i = 0; i < productos.size(); i++) {
            codigoProductos[i] = productos.get(i).getCodigo();
        }
        return codigoProductos;
    }
    /**
     * función para recoger en un array de strings, las descriciones de los productos
     * @param productos un array de objetos de tipo producto
     * @return el array de descricion
     */
    public String [] getDescricionProductos(ArrayList <Product> productos) {

        //declaramos un array de descriciones de los productos igual al tamaño del arraylist
        String [] descricionProductos = new String [productos.size()];

        /**
         * bucle para recorrer el arrayList
         * vamos añadiendo al array de Strings, las descriciones de los productos
         */
        for (int i = 0; i < productos.size(); i++) {
            descricionProductos[i] = productos.get(i).getDescripcion();
        }
        return descricionProductos;
    }

    /**
     * función para recoger en un array de strings, los precios de los productos
     * @param productos un array de objetos de tipo producto
     * @return el array de precios
     */
    public double [] getPrezoProductos(ArrayList <Product> productos) {

        //declaramos un array de descriciones de los productos igual al tamaño del arraylist
        double [] prezoProdutos = new double[productos.size()];

        /**
         * bucle para recorrer el arrayList
         * vamos añadiendo al array de Strings, los precios de los productos
         */
        for (int i = 0; i < productos.size(); i++) {
            prezoProdutos[i] = productos.get(i).getPrecio();
        }
        return prezoProdutos;
    }


}
