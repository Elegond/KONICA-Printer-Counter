package work.saretzki;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.Properties;
import java.util.Scanner;

public class config {

	private Scanner s;
	private File cfg;
	private Formatter createCfg = null;
	private String p1 = "", p2 = "",p3="";
	private int p1Feld=0, p2Feld=0;
	private String dp1 = "192.168.1.190", dp2 = "192.168.1.189", dp3="192.168.1.228";


	public config(File cfg) {
		
		this.cfg = cfg;
		if (cfg.exists() && !(cfg.isDirectory())) {

			System.out.println("Config '" + cfg.getName() + "' gefunden");

			readConfig();

			System.out.println("Config '" + cfg.getName() + "' gelesen");
			writeConfig();
		} else {
			this.cfg = new File(".//config.cfg");
			// Config mit Standard werten erstellen
			System.err.println("Config '" + cfg.getAbsolutePath() + "' nicht gefunden");
			System.out.println();
			System.out.println("Probiere Config zu erstellen");
			writeConfig(dp1, dp2,dp3);
			System.out.println("Config erstellt");
		}
	}

	private void writeConfig() {
		writeConfig(p1, p2, p3);

	}

	private void writeConfig(String p1, String p2,String p3) {
		try {
			createCfg = new Formatter(cfg);
			createCfg.format("p1_ip: %s\np2_ip: %s\np3_ip: %s", p1, p2,  p3);
			createCfg.close();

			System.out.println("Config geschrieben");

			readConfig();

		} catch (FileNotFoundException e) {
			setUnsetData();
			System.err.println("Config Schreibfehler: " + e.toString());

		}

	}

	private void readConfig() {
		try {// try to use the scanner on "cfg"
			s = new Scanner(cfg);
			while (s.hasNext()) {
				String g = s.next();
				if (g.equalsIgnoreCase("p1_ip:")) {
					if (s.hasNext()) {
						p1 = s.next();
					}
				} else if (g.equalsIgnoreCase("p2_ip:")) {
					if (s.hasNext()) {
						p2 = s.next();

					}
				}  else if (g.equalsIgnoreCase("p3_ip:")) {
					if (s.hasNext()) {
						p3 = s.next();

					}
				} 
			}

			System.out.println("Config = p1:"+p1+" p2:"+p2+" p3:"+p3);

			/* Set required Data if not found */
			setUnsetData();

			s.close();
		} catch (FileNotFoundException e) {
			setUnsetData();
			System.err.println("Config Lesefehler: " + e.toString());
		}

	}

	private void setUnsetData() {

		if (p2.length() < 5 || p1.length() < 5||p3.length() < 5) {
			if (p1.length() < 5) {
				p1 = dp1;
			}
			if (p2.length() < 5) {
				p2 = dp2;
			}
			if (p3.length() < 5) {
				p3 = dp3;
			}
			writeConfig();
		}
	}

	public String getP1() {
		return p1;
	}

	public String getP2() {
		return p2;
	}
	public String getP3() {
		return p3;
	}
}
