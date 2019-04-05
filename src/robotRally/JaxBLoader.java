package robotRally;

import roboRally.MapType;
import roboRally.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;

public class JaxBLoader {

    public static void main(String[] args) throws JAXBException, IOException {
        try (InputStream stream = JaxBLoader.class.getResourceAsStream("../Layout/BarrensMap.tmx")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            MapType map = ((JAXBElement<MapType>) jaxbUnmarshaller.unmarshal(stream)).getValue();
            System.out.println(map);
        }
    }
}
