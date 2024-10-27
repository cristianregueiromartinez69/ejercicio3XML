package ejercicio3XML;

import serializacion2.Product;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase escritura xml donde realizamos 2 metodos. Escribimos en el xml y leemos de un archivo donde está el objeto producto
 * @author cristian
 * @version 1.0
 */
public class EscrituraXML {

    /**
     * función que escribe en un xml
     * @param codigo el codigo del producto
     * @param descricion la descricion del producto
     * @param prezo el precio del producto
     * @param pathXMLFile el path donde estará el xml
     */
    public void writeXMLfromSerialize(String [] codigo, String descricion [], double [] prezo, String pathXMLFile) {
        try {
            /**
             * igual que en el ejercicio 1 de xml, instanciamos objetos necesarios para la creacion y escritura del xml
             */
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(pathXMLFile));
            xmlStreamWriter.writeStartDocument();


            xmlStreamWriter.writeCharacters("\n");

            xmlStreamWriter.writeStartElement("produtos");
            xmlStreamWriter.writeCharacters("\n");
            /**
             * bucle para escribir en el archivo xml
             * hacemos que i sea menor que el tamaño del array de codigo
             */
            for(int i = 0; i < codigo.length; i++) {
                /**
                 * Abrimos etiquetas con startElement
                 * escribimos dentro de ellas con writechars
                 * cerramos etiquetas con endElement
                 */
                xmlStreamWriter.writeStartElement("producto");
                xmlStreamWriter.writeCharacters("\n");

                xmlStreamWriter.writeStartElement("codigo");
                xmlStreamWriter.writeCharacters(codigo[i]);
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");

                xmlStreamWriter.writeStartElement("descricion");
                xmlStreamWriter.writeCharacters(descricion[i]);
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");

                /**
                 * IMPORTANTE
                 * tenemos que hacer casteo de los precios ya que en el xml escribimos en texto
                 */
                xmlStreamWriter.writeStartElement("prezo");
                xmlStreamWriter.writeCharacters(String.valueOf(prezo[i]));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeCharacters("\n");

            }
            /**
             * MUY IMPORTANTE, YA QUE SI NO NO VA A ESCRIBIR EN EL ARCHIVO
             * cerramos el documento con writeEndDocument
             * cerramos el xml con close()
             */
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.close();

            /**
             * capturamos excepciones por si ocurre algun problema durante el transcurso de la escritura o acceso a un fichero
             */
        } catch (IOException ioEX) {
            System.out.println("Ups, no se ha podido acceder al archivo xml");
        } catch (XMLStreamException xmlEX) {
            System.out.println("Ups, no se ha podido operar con el archivo xml");
        }
    }


    /**
     * función que devuelve un arraylist de productos a raíz de la lectura de un fichero que contiene objetos de tipo producto
     * @param path el path del archivo
     * @return el arraylist de ripo productos
     */
    public ArrayList <Product> readObject(String path) {
        //declaramos el array de productos
        ArrayList <Product> products = new ArrayList <> ();
        //establecemos un objeto producto en null
        Product auxProduct = null;
        try {
            //llamamos al objeto de la clase ObjectInputStream para leer el producto del archivo
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

            /**
             * Mientras haya lectura en el fichero, añadimos los objetos al arrayList
             */
            while ((auxProduct = (Product) ois.readObject()) != null) {
                products.add(auxProduct);
            }
            //cerramos el objeto
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("llegaste al final del fichero");
        }

        return products;
    }
}