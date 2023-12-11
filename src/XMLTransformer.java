/**
 * This is a helper tool for reformatting the "ugly" XML string.
 *
 * Note: Parts of this code were adapted from an online source.
 * Original Source: https://www.baeldung.com/java-pretty-print-xml
 * GitHub Repository: https://github.com/eugenp/tutorials/tree/master/xml-2
 * This seemed to be the simplest XML formatter which I could find!
 */

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XMLTransformer {

    /**
     * Convert an XML string into a "Pretty Printed" XML string.
     *
     * @param xmlString        The XML string to be reformatted.
     * @param indent           The number of spaces to use for indentation.
     * @param ignoreDeclaration Whether to omit the XML declaration.
     * @return The pretty-printed XML string.
     */
    public static String prettyPrintByTransformer(String xmlString, int indent, boolean ignoreDeclaration) {
        try {
            InputSource src = new InputSource(new StringReader(xmlString));
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);

            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, ignoreDeclaration ? "yes" : "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            Writer out = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(out));
            return out.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error occurs when pretty-printing XML:\n" + xmlString, e);
        }
    }
}
