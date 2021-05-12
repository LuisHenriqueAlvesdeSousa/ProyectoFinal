package validador;


import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
/**
 * @see https://www.jc-mouse.net/
 * @author mouse
 */
public class ValidadorXSD {

    public static void ValidarConXSD(String xsdfile, String xmlfile) {
        try {
            //URI del espacio de nombres del esquema XML del W3C. http://www.w3.org/2001/XMLSchema
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //Representa un conjunto de restricciones que se pueden verificar / aplicar en un documento XML
            //Un objeto de esquema generalmente se crea a partir de SchemaFactory
            Schema schema = factory.newSchema(ValidadorXSD.class.getResource(xsdfile));
            //verifica un documento XML contra el esquema XSD
            Validator validator = schema.newValidator();
            //Establece el ErrorHandler para recibir los errores encontrados durante la 
            //invocaci�n del m�todo de validaci�n.
            validator.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    mostrarError(exception);
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    mostrarError(exception);
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    mostrarError(exception);
                }

                private void mostrarError(SAXParseException exception) {
                    System.out.println("Linea: "
                            + String.format("%4s|", exception.getLineNumber())
                            + exception.getMessage());
                }
 
            });
            //Valida la entrada especificada. Debe ser un documento XML o un elemento XML y no debe ser nulo
            validator.validate(new StreamSource(ValidadorXSD.class.getResourceAsStream(xmlfile)));

        } catch (SAXException | IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}