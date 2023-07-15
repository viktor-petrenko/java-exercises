import org.testng.IAlterSuiteListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AlterSuiteListener implements IAlterSuiteListener {
    private List<XmlSuite> allSuites = new ArrayList<>();

    @Override
    public void alter(List<XmlSuite> suites) {
        // Create a new suite for combining the suites of suites
        XmlSuite combinedSuite = new XmlSuite();
        combinedSuite.setName("Combined Suite");

        // Iterate over the suites of suites and combine them into the combined suite
        for (XmlSuite suite : suites) {
            // Add all the child suites to the combined suite
            combinedSuite.getChildSuites().addAll(suite.getChildSuites());

            // Add all the tests from each suite to the combined suite
            for (XmlTest test : suite.getTests()) {
                combinedSuite.addTest(test);
            }
        }

        // Replace the original suites with the combined suite
        suites.clear();
        suites.add(combinedSuite);
    }
}
