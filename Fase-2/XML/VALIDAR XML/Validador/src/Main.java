import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import static validador.ValidadorDTD.validarConDTD;
/**
 * @see https://www.jc-mouse.net/
 * @author mouse
 */
public class Main {

    public static void main(String[] args) {
        try {
            validador.ValidadorXSD.ValidarConXSD("/validador/ClasificacionGeneral.xsd", "ClasificacionGeneral_XSD.xml" );
            validador.ValidadorDTD.validarConDTD("C:\\Users\\1GDAW06\\Desktop\\VALIDAR XML\\Validador\\src\\validador/ClasificacionGeneral_DTD.xml");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}