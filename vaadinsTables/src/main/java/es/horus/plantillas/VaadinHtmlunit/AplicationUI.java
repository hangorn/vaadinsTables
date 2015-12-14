package es.horus.plantillas.VaadinHtmlunit;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

public class AplicationUI extends UI {
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Table table = new Table("This is my Table");
    	table.setId("tableid");
    	table.setSelectable(true);

    	table.addContainerProperty("First Name", String.class,  null);
    	table.addContainerProperty("Last Name",  String.class,  null);
    	table.addContainerProperty("Year",       Integer.class, null);

    	table.addItem(new Object[] {"Nicolaus","Copernicus",new Integer(1473)}, new Integer(1));
    	table.addItem(new Object[] {"Tycho",   "Brahe",     new Integer(1546)}, new Integer(2));
    	table.addItem(new Object[] {"Giordano","Bruno",     new Integer(1548)}, new Integer(3));
    	table.addItem(new Object[] {"Galileo", "Galilei",   new Integer(1564)}, new Integer(4));
    	table.addItem(new Object[] {"Johannes","Kepler",    new Integer(1571)}, new Integer(5));
    	table.addItem(new Object[] {"Isaac",   "Newton",    new Integer(1643)}, new Integer(6));

    	table.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				System.out.println("Item clicked: "+event.getItem().toString());
			}}
    	);
    	
    	setContent(table);
    }

    @WebServlet(urlPatterns = "/*", name = "AplicationServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = AplicationUI.class, productionMode = false)
    public static class AplicacionServlet extends VaadinServlet {
    }

    
    
}
