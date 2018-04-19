package questsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class FileReader {
	
	public static Quest ReadFiles (String fileName) {
		try {
			File searchedFile = new File("save/" + fileName + ".xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        UserHandler uh = new UserHandler();
	        saxParser.parse(searchedFile, uh);
	        return uh.returnQuest();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Kann File nicht finden. Programm wird beendet...");
			System.exit(1);
		} catch (SAXException e) {
			e.printStackTrace();
			System.err.println("Unbekannter Fehler beim Parsen.");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Fehler beim schreiben in die Datei.");
			System.exit(1);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.err.println("Fehler beim konfigurieren des Parsers.");
			System.exit(1);
		}
		return null;
	}
	
}
