package ejercicio3XML;


import serializacion2.Product;

import java.util.ArrayList;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        //instanciamos un objeto de la clase que va a escribir el xml
        EscrituraXML escrituraXML = new EscrituraXML();

        //instanciamos un objeto de la clase con los metodos para recoger las variables de codigo, descricion y precio
        MethosSeparateProductos methosSeparateProductos = new MethosSeparateProductos();

        //hacemos un arraylist de productos que es igual al metodo que lee el fichero donde está el objeto productos
        ArrayList <Product> products = escrituraXML.readObject("C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/ejercicio3xml/produtos.dat");

        /**
         * variables con el codigo, descricion y precio que son iguales a metodos que nos devuelven los atributos de los produtos
         */
        String [] codigo = methosSeparateProductos.getCodigoProductos(products);
        String [] descricion = methosSeparateProductos.getDescricionProductos(products);
        double [] prezo = methosSeparateProductos.getPrezoProductos(products);

        //llamamos al metodo que escribe en un fichero xml a partir de los atributos anteriores
        escrituraXML.writeXMLfromSerialize(codigo, descricion, prezo, "productos.xml");

    }
}

