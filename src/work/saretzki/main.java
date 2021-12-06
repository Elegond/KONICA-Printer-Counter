package work.saretzki;

import java.io.File;
import java.io.IOException;

public class main {
	public static printer p2, p1, p3;
	public static Boolean debug = false;
	private static File cfgDatei = new File(".//config.cfg");

	public static void main(String[] args) throws IOException {
		System.out.println("Printer Counter v0.0.1");
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("--debug") || args[i].equalsIgnoreCase("-d")) {
				debug = true;
			}

		} // Ende der Startparameter Schleife private int dp1Feld = 175, dp2Feld = 171;

		config cfg = new config(cfgDatei);
		p1 = new printer(cfg.getP1());
		p1.setLast(p1.getInt(290)  + p1.getInt(319));
		p1.reset();
		p1.setLastC(p1.getInt(293) + p1.getInt(322));
		p1.resetC();
		p2 = new printer(cfg.getP2());
		p2.setLast(p2.getInt(175) + p2.getInt(204));
		p2.reset();
		p3 = new printer(cfg.getP3());
		p3.setLast( p3.getInt(188) + p3.getInt(196));
		p3.reset();
		gui g = new gui();
		try {
			System.out.println("Sleeping");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}

		while (g.isShowing()) {

			p1.c(cfg.getP1());
			p1.setLast(p1.getInt(290)  + p1.getInt(319));
			p1.setLastC(p1.getInt(293) + p1.getInt(322));
			
			p2.c(cfg.getP2());
			p2.setLast( p2.getInt(175) + p2.getInt(204));
			
			p3.c(cfg.getP3());
			p3.setLast( + p3.getInt(188)  + p3.getInt(196));
			
			System.out.println(p1.getD());
			System.out.println(p1.getDC());
			System.out.println(p2.getD());
			System.out.println(p3.getD());
			g.re();
			try {
				System.out.println("Sleeping");
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	

}