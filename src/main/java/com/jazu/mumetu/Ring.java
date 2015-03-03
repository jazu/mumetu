package com.jazu.mumetu;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean
public class Ring implements Serializable{

	private static final long serialVersionUID = -3509567695781675199L;
	
	private List<String> pages;
	
	private String selectedPage;
	
	public Ring() {
		//we do this here instead of the xhtml file because primefaces ring component only takes values from an arraylist
		pages = new ArrayList<String>();
		pages.add("projects");
		pages.add("cv");
		pages.add("contact");
	}

	public void growl() {
		//Growl overlay messages for different pages
		FacesContext fc = FacesContext.getCurrentInstance();
		//get current instance information
		String vId= fc.getViewRoot().getViewId();
		//check if the viewId starts with page name
		if(vId.startsWith("/projects")) {
			FacesMessage message = new FacesMessage
					//get current instance locale
					(getMessageResourceString("messages", "projectsgrowl", null, fc.getViewRoot().getLocale()));
			fc.addMessage("title", message);
		} else if (vId.startsWith("/quickmenu")) {
			FacesMessage message = new FacesMessage
					(getMessageResourceString("messages", "quickmenugrowl", null, fc.getViewRoot().getLocale()));
			fc.addMessage(vId, message);
		} /* else if (vId.startsWith("/contact")) {
			FacesMessage message = new FacesMessage
					(getMessageResourceString("messages", "contactsgrowl", null, fc.getViewRoot().getLocale()));
			fc.addMessage("title", message);
		} */
		
	}

	public static String getMessageResourceString(String bundleName, String key, Object params[], Locale locale) {
		//helper method to access messages.properties files from java classes
        String text;
        ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale);

        try {
            text = bundle.getString(key);
        } catch (MissingResourceException e) {
            text = "?? key " + key + " not found ??";
        }

        if (params != null) {
            MessageFormat mf = new MessageFormat(text, locale);
            text = mf.format(params, new StringBuffer(), null).toString();
        }
      //  System.out.println(text);
        return text;
    }

	public List<String> getPages() {
		return pages;
	}



	public void setPages(List<String> pages) {
		this.pages = pages;
	}



	public String getSelectedPage() {
		return selectedPage;
	}



	public void setSelectedPage(String selectedPage) {
		this.selectedPage = selectedPage;
	}
	
}
