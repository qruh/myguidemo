package swtPainting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ColorsDemo {
	
	Display display;
	Shell shell;
	
	public void showColorsDemo() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		shell.addListener(SWT.Paint, event -> drawRectangles(event));
		
		shell.setText("Colors");
		shell.setSize(360,120);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void drawRectangles(Event e) {
		
		GC gc = e.gc;
		
		Color c1 = new Color(e.display, 50,50,200);
		gc.setBackground(c1);
		gc.fillRectangle(10,15,90,60);
		
		Color c2 = new Color(e.display, 105,90,60);
		gc.setBackground(c2);
		gc.fillRectangle(130,15,90,60);
		
		Color c3 = new Color(e.display, 33,200,100);
		gc.setBackground(c3);
		gc.fillRectangle(250,15,90,60);
		
		c1.dispose();
		c2.dispose();
		c3.dispose();
	}
	public void showLineStyles() {
		display = new Display();
		shell = new Shell(display);
		
		shell.addListener(SWT.Paint, event -> drawLyrics(event));
		
		shell.setText("Line styles");
		shell.setSize(300,330);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void drawLyrics(Event e) {
		GC gc = e.gc;
		
		gc.setLineWidth(2);
		
		gc.setLineStyle(SWT.LINE_DASHDOT);
		gc.drawLine(20,40,250,40);
		
		gc.setLineStyle(SWT.LINE_DASH);
		gc.drawLine(20, 80, 250, 80);
		
		gc.setLineStyle(SWT.LINE_DASHDOTDOT);
		gc.drawLine(20, 120, 250, 120);
		
		gc.setLineStyle(SWT.LINE_SOLID);
		gc.drawLine(20, 160, 250, 160);
		
		gc.setLineStyle(SWT.LINE_DOT);
		gc.drawLine(20, 200, 250, 200);
		
		gc.setLineStyle(SWT.LINE_CUSTOM);
		gc.setLineDash(new int [] {1,4,5,4});
		gc.drawLine(20, 240, 250, 240);
	}
	public void showBasicShapes() {
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		shell.addListener(SWT.Paint, event -> drawShapes(event));
		
		shell.setText("Basic shapes");
		shell.setSize(430,300);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void drawShapes(Event e) {
		GC gc = e.gc;
		
		gc.setAntialias(SWT.ON);
		
		Color col = new Color(e.display, 150,150,150);
		gc.setBackground(col);
		
		gc.fillRectangle(20,20,120,80);
		gc.fillRectangle(180,20,80,80);
		gc.fillOval(290,20,120,70);
		
		gc.fillOval(20, 150, 80, 80);
		gc.fillRoundRectangle(150, 150, 100, 80, 25, 25);
		gc.fillArc(280, 150, 100, 100, 0, 115);
		
		col.dispose();
	}
	public void showPolygon() {
		display = new Display();
		shell = new Shell(display);
		
		shell.addListener(SWT.Paint, event -> drawPolygon(event));
		
		shell.setText("Polygon");
		shell.setSize(280,280);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void drawPolygon(Event e) {
		
		final int points[] = { 0, 85, 75, 75, 100, 10, 
	            125, 75, 200, 85, 150, 125, 160, 190, 100, 150, 
	            40, 190, 50, 125, 0, 85 };
		
		GC gc = e.gc;
		
		Color grayCol = new Color(e.display, 120,120,120);
		
		gc.setBackground(grayCol);
		gc.fillPolygon(points);
		
		grayCol.dispose();
	}
	public void showTransparentRectangles() {
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
			
		shell.addListener(SWT.Paint, event -> drawTransparentRect(event));
		
		shell.setText("Transparent rectangles");
		shell.setSize(590,120);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.sleep();
	}
	private void drawTransparentRect(Event e) {
		
		GC gc = e.gc;
		
		Color grayCol = new Color(e.display,150,150,150);
		gc.setBackground(grayCol);
		gc.fillRectangle(30,10,525,25);
		
			
		Color blueCol = new Color(e.display, 0,0,255);
		gc.setBackground(blueCol);
		
		for(int i = 1; i < 11; i++) {
			gc.setAlpha(i * 25);
			gc.fillRectangle(50 * i, 20,40,40);
		}
		grayCol.dispose();
		blueCol.dispose();
	}
	public void showDonut() {
		
		display = new Display();
		shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		
		shell.addListener(SWT.Paint, event -> drawDonut(event));
		
		shell.setText("Donut");
		shell.setSize(430,300);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
	private void drawDonut(Event e) {
		
		GC gc = e.gc;
		
		int w = e.width;
		int h = e.height;
		
		gc.setAntialias(SWT.ON);
		
		Transform tr = new Transform(e.display);
		tr.translate(w / 2, h / 2);
		gc.setTransform(tr);
		
		for(int rot = 0; rot < 36; rot++) {
			tr.rotate(5f);
			gc.setTransform(tr);
			gc.drawOval(-125, -40, 250, 80);
		}
		tr.dispose();
	}	
	public void showDrawingText() {
		display = new Display();
		shell = new Shell(display);
		
		shell.addListener(SWT.Paint, event -> drawLyricStyles(event));
		
		shell.setText("Soulmate");
		shell.setSize(380,300);
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();		
	}
	private void drawLyricStyles(Event e) {
		GC gc = e.gc;
		
		gc.setAntialias(SWT.ON);
		
		Font font = new Font(e.display, "Tahoma", 10, SWT.NORMAL);
		Color col = new Color(e.display,25,25,25);
		
		gc.setForeground(col);
		gc.setFont(font);
		
		gc.drawText("Most relationships seem so transitory", 20, 30);
		gc.drawText("They're good but not the permanent one", 20, 60);
	    gc.drawText("Who doesn't long for someone to hold", 20, 120);
	    gc.drawText("Who knows how to love without being told", 20, 150);
	    gc.drawText("Somebody tell me why I'm on my own", 20, 180);
	    gc.drawText("If there's a soulmate for everyone", 20, 210);
	    
	    col.dispose();
	    font.dispose();
	}
	public void showTextLayoutStyleColor() {
		display = new Display();
		shell = new Shell(display);
		
		Font font1 = new Font(display, "Tahoma", 14, SWT.BOLD);
		Font font2 = new Font(display, "MS Mincho", 20, SWT.ITALIC);
		Font font3 = new Font(display, "Arabic Transparent", 18, SWT.NORMAL);
		
		Color blue = display.getSystemColor(SWT.COLOR_BLUE);
		Color green = display.getSystemColor(SWT.COLOR_GREEN);
		Color yellow = display.getSystemColor(SWT.COLOR_YELLOW);
		Color gray = display.getSystemColor(SWT.COLOR_GRAY);
		
		TextLayout layout = new TextLayout(display);
		TextStyle style1 = new TextStyle(font1, yellow, blue);
		TextStyle style2 = new TextStyle(font2, green, null);
		TextStyle style3 = new TextStyle(font3, blue, gray);
		
		layout.setText("English 1234567890asdfasdfasdf");
		layout.setStyle(style1, 0, 6);
		layout.setStyle(style2, 8, 10);
		layout.setStyle(style3, 13, 21);
		
		shell.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		shell.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				layout.draw(event.gc, 10, 10);
			}
		});
		
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		font1.dispose();
		font2.dispose();
		font3.dispose();
		layout.dispose();
		display.dispose();
	}
}
























