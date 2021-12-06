package work.saretzki;

import java.io.IOException;
import java.util.Map;


import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class printer {
	private int last = 0;
	private int first = 0;
	private long time;
	private int s = 0;
	private long timeC;
	private int sC = 0;
	private int lastC;
	private int firstC = 0;
	private Elements imports;

	public printer(String ip) {
		c(ip);

	}

	public int getInt(int f) {

		return (Integer.parseInt(imports.get(f).ownText()));
	}

	public void c(String ip) {
		System.out.println("\nConnecting to " + ip + "...");
		Response res;
		try {
			res = Jsoup.connect("http://" + ip + "/wcd/ulogin.cgi")
					.data("func", "PSL_LP0_TOP", "AuthType", "None", "TrackType", "None", "PswcForm", "HtmlFlash",
							"Mode", "Public", "ViewMode", "Html", "BrowseMode", "Low", "Lang", "De")
					.method(Method.POST).execute();
			Map<String, String> loginCookies = res.cookies();

			Document doc = Jsoup.connect("http://" + ip + "/wcd/system_counter.xml").cookies(loginCookies).get();

			System.out.println(loginCookies.toString());
			imports = doc.getAllElements();

			if (main.debug) {
				System.out.println("\nElemente von " + ip + ": " + imports.size());
				int i = 0;
				for (Element link : imports) {
					System.out.println(i + "  " + link.ownText());
					i++;

				}
			}

		} catch (IOException e) {
			//JOptionPane.showMessageDialog(null, e.getMessage() + " " + ip, "Inane error", JOptionPane.ERROR_MESSAGE);
			
		}
	}

	public int getD() {
		/*
		 * if (s == last) {
		 * 
		 * if (time < System.currentTimeMillis()) { first = last; } } else { s = last;
		 * time = System.currentTimeMillis() + 300000; }
		 */
		return last - first;
	}

	public int getLast() {
		return last;
	}

	public int getFirst() {
		return first;
	}

	public void setLast(int f) {
		last = f;
	}

	public boolean reset() {
		first = last;
		return true;
	}

	/* Color */
	public int getDC() {
		/*
		 * if (sC==lastC) { if(timeC<System.currentTimeMillis()) { firstC=lastC; } }else
		 * { sC=lastC; timeC=System.currentTimeMillis()+300000; }
		 */
		return lastC - firstC;
	}

	public boolean resetC() {
		firstC = lastC;
		return true;
	}

	public int getLastC() {
		return lastC;
	}

	public int getFirstC() {
		return firstC;
	}

	public void setLastC(int f) {
		lastC = f;
	}

}
