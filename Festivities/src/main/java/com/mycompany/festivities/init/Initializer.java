/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.festivities.init;

import com.mycompany.festivities.model.Festivity;
import com.mycompany.festivities.model.Storage;
import com.mycompany.festivities.util.Util;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletContextEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author keihell
 */
public class Initializer implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String home = System.getProperty("user.home");
        java.nio.file.Path path = java.nio.file.Paths.get(home);
        String file = path+File.separator+"festivities.xml";
        System.out.println("Initializing REST API....");
        System.out.println("Loading Festivities XML File file....");
        
        File festivitiesFile = new File(file);
        try{
            readXMLFile(festivitiesFile);
        }catch(Exception ex){
            System.out.println("There was an error while loading Festivities XML File...");
            System.out.println(ex);
            System.exit(1);
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void readXMLFile(File xmlFile) throws Exception{
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            NodeList list = document.getElementsByTagName("festivity");
            for(int i=0; i<list.getLength();i++){
                Node node = list.item(i);
                NodeList atributes = node.getChildNodes();
                Festivity festivity = new Festivity();
                for(int j=0;j<atributes.getLength();j++){
                    Node atribute = atributes.item(j);
                    switch(atribute.getNodeName()){
                        case "name":
                            festivity.setName(atribute.getTextContent());
                            break;
                        case "place":
                            festivity.setPlace(atribute.getTextContent());
                            break;
                        case "start":
                            festivity.setStart(Util.turnStringDateToDate(atribute.getTextContent()));
                            break;
                        case "end":
                            festivity.setEnd(Util.turnStringDateToDate(atribute.getTextContent()));
                            break;
                        default:
                            System.out.println("Invalid tag found "+atribute.getNodeName());
                            break;
                    }
                }
                Storage.addFestivity(festivity);
            }
        }catch(ParserConfigurationException | SAXException | IOException mex){
            throw new Exception(mex);
        }
    }
}
