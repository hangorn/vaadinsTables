package es.horus.plantillas.VaadinHtmlunit;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TableIT {
	
	@Test
	public void tableClick() throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {
	    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38)) {
			HtmlPage page = webClient.getPage("http://localhost:8080/VaadinHtmlunit/");
	    	webClient.setAjaxController(new NicelyResynchronizingAjaxController());
			DomElement e = null;
			for (int k=0;k<100;k++) {
				Thread.sleep(100);
				e = page.getFirstByXPath("//div[@id='tableid']//table[@class='v-table-table']//tr[3]");
				if (e!=null) break;
			}
	        e.click();
	    }
	}

}
