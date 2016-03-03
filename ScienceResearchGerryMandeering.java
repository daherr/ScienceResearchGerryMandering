import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;


/**
 * 
 */

/**
 * @author SJHSStudent
 *
 */
public class ScienceResearchGerryMandeering extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	private static final long serialVersionUID = 1; 
	private GridBagLayout layout;
	private JTextField myTextField; // variable for text box
	
	
	/**
	 * @param args
	 */
	public ScienceResearchGerryMandeering(){
		
		 super( "ScienceResearchGerryMandeering");
		 layout = new GridBagLayout();
		 // variable for the gridbag layout
		 JButton button;
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 GridBagConstraints c = new GridBagConstraints(); // creates a new GridBagRestraint
			// general constraints
			c.fill = GridBagConstraints.BOTH; // sets c to resize components BOTH vertically and horizontally
			// text field setup
		
			
			button = new JButton("Redictrict");
			button.setFont(new Font("TimesRoman", Font.ITALIC, 12)); // sets font, makes font italicized and font size
			button.addActionListener(this); // adds ActionListener to button to roll dice
			layout.setConstraints(button, c); // more button constraints
			button.setVisible(true);
			add(button); // adds button to frame

			myTextField = new JTextField("Please enter a county you would like to redistrict"); // creates new text field and sets text in textfield
			c.weightx = 1.0; // sets weight for text field to have more weight
			c.gridwidth = 5; // allocates 5 cells for text field
			c.gridwidth = GridBagConstraints.REMAINDER; // text field restraints
			layout.setConstraints(myTextField, c); // text field constraints
			myTextField.setEditable(true); // makes the text field not editable 
			add(myTextField);
			myTextField.addActionListener(this);
			setResizable(true); // makes the frame unresizable 
			setSize(500, 500); // sets the frame to the preferred size 
			 setVisible(true); // makes the frame visible
		 /*
		  * EXAMPLE ON HOW TO GOOGLE SEARCH
		  * 
		  *  String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
    String search = "stackoverflow";
    String charset = "UTF-8";

    URL url = new URL(google + URLEncoder.encode(search, charset));
    Reader reader = new InputStreamReader(url.openStream(), charset);
    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

    // Show title and URL of 1st result.
    System.out.println(results.getResponseData().getResults().get(0).getTitle());
    System.out.println(results.getResponseData().getResults().get(0).getUrl());
		  */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ScienceResearchGerryMandeering();
		/*
		 * NOTE TO ASK MR. WOYTEK: 
		 * Ask about if possible to read type from text field 
		 * 
		 * Enter name of a county- check
		 * find name of all voting districts / voting areas using queries
		 * find results from elections online in said voting districts / township using queries
		 * find GPS coordinates for said voting districts /  townships using queries
		 * Use distance formula to find the the shortest line between GPS coordinates *NOTE* API will do this for me if i learn and use it
		 * Draw a map on window to show township /  voting district boundaries
		 * ***NOTE*** MUST exclude state, city, and preferably unaffected boundaries
		 */
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
String google = "http://www.google.com/search?q=";
String search = "stackoverflow";
String charset = "UTF-8";
String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

Elements links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");

for (Element link : links) {
    String title = link.text();
    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

    if (!url.startsWith("http")) {
        continue; // Ads/news/etc.
    }

    System.out.println("Title: " + title);
    System.out.println("URL: " + url);
}
		*/
	String google = "http://www.google.com/search?q=";
	String search = myTextField.getText();
	String charset = "UTF-8";
	String userAgent = "Science Research SJHS (herr.david@rocketmail.com)";
	
	Elements links = null;
	try {
		links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");
	} catch (UnsupportedEncodingException e2) {
		e2.printStackTrace();
	} catch (IOException e2) {
		e2.printStackTrace();
	}
	
	for(Element link : links){
		String title = link.text();
		String url = link.absUrl("href");
		try {
			url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		};
		if(!url.startsWith("http")){
			continue;
		}
		
		System.out.println("Title: " + title);
		System.out.println("Url: " + url);
	}
		
	}

}
