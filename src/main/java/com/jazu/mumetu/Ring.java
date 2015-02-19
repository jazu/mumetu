package com.jazu.mumetu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean
public class Ring implements Serializable{

	private static final long serialVersionUID = -3509567695781675199L;
	
	private List<String> pages;
	
	private String selectedPage;
	
	public Ring() {
		pages = new ArrayList<String>();
		pages.add("projects");
		pages.add("cv");
		pages.add("contact");
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
