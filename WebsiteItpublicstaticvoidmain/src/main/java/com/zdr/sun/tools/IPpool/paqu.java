package com.zdr.sun.tools.IPpool;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class paqu {
    private static Document doc = null;
    private static String Sdoc = null;

    public static String paqu(String url) {

	try {
	    doc = Jsoup.connect(url)
		    .header("user-agent",
			    "Mozilla/5.0 (Windows NT 10.0; WOW64) " + "AppleWebKit/537.36 (KHTML, like Gecko) "
				    + "Chrome/47.0.2526.106 BIDUBrowser/8.7 Safari/537.36")
		    .ignoreContentType(true).get();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Sdoc = doc.html();
	return Sdoc;

    }

    public String ip() {
	try {
	    doc = Jsoup.connect("http://pv.sohu.com/cityjson?ie=utf-8")
		    .header("user-agent",
			    "Mozilla/5.0 (Windows NT 10.0; WOW64) " + "AppleWebKit/537.36 (KHTML, like Gecko) "
				    + "Chrome/47.0.2526.106 BIDUBrowser/8.7 Safari/537.36")
		    .ignoreContentType(true).get();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	}
	Sdoc = doc.html();
	return Sdoc;
    }

}
