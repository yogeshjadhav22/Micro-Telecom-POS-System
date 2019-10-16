import java.awt.*;
import javax.swing.*;
import java.awt.print.*;

public class PrintableDocument1 implements Printable {
	private Component compent;
	
	public static void printComponent(Component c) {
		new PrintableDocument1(c).print();
	}
	
	public PrintableDocument1(Component compent) {
		this.compent = compent;
	}
	
	public void print() {
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(this);
		if(printJob.printDialog())
			try {
			printJob.print();
		}
		catch(PrinterException pe) {
			System.out.println("Error printing: " + pe);
		}
	}
	
	public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
		if (pageIndex > 0) {
			return(NO_SUCH_PAGE);
		}
		else {
			Graphics2D graph = (Graphics2D)g;
			graph.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
					
			disableBuffering(compent);
			compent.paint(graph);
			enableBuffering(compent);
			return(PAGE_EXISTS);
		}
	}
	
	public static void disableBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(false);
	}
	
	public static void enableBuffering(Component c) {
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(true);
	}
}

