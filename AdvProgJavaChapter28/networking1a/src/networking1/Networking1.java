package networking1;

import javax.swing.JLabel;
import javafx.scene.layout.VBox;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;

import javax.swing.JApplet;
import java.net.URL;
import java.net.MalformedURLException;
import java.applet.AppletContext;
import java.awt.BorderLayout;

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Prof. Carl B. Struck
 */
public class Networking1 extends JApplet
{
    private HashMap<String, URL> websiteMap;
    private ArrayList<String> titlesArrayList;
    private JList list;
    
    VBox vBox;

    public void init()
    {
        
        websiteMap = new HashMap();
        titlesArrayList = new ArrayList();

        grabHtmlInfo();
        
        add( new JLabel( "What website do you want to visit"), BorderLayout.NORTH );
       
        list = new JList( titlesArrayList.toArray() );
        list.addListSelectionListener( e -> getWebsite(e) );
        
        //add( new JScrollPane(list), BorderLayout.SOUTH);
        add(list, BorderLayout.SOUTH);
    }
    
    /**
     * 
     */
    public void grabHtmlInfo()
    {
        String title;
        String address;
        URL url;
        
        int index = 0;
        
        title = getParameter("title" + index);
        
        while (title != null)
        {
            address = getParameter("address" + index);
            
            try
            {
                url = new URL("address");
                websiteMap.put(title, url);
                titlesArrayList.add(title);
            }
            catch (MalformedURLException ex)
            {
                ex.printStackTrace();
            }
            
            index++;
            title = getParameter("title" + index);
        }
    }
    
    /**
     * 
     * @param e 
     */
    public void getWebsite(ListSelectionEvent e)
    {
        Object selectedItem = list.getSelectedValue();
        URL newDocument = websiteMap.get(selectedItem);
        AppletContext browser = getAppletContext();
        browser.showDocument(newDocument);
    }
}
