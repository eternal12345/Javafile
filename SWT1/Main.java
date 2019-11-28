//Main.java
package test;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import test.IShape;
import test.Board;
import test.Circle;
import test.Pentagon;
import test.Rect;
import test.Star;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;







public class Main {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	private static GC gcMain = null;
	private static int shapeType = 1;
	public static int startX;
	public static int startY;
	public static int Lastwidth = 0;
	public static int Lastheight = 0;
	private static boolean LeftButtonDown = false;
	private Text text;
	private Text text_1;
	private Text text_2;
	
	public static void main(String[] args) {
		
		Display display = Display.getDefault();
		Shell shell;
		shell = new Shell();
		
		
		
		
		
		
		
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		gcMain = new GC(shell);
		
		Board board = new Board();
		Display display = Display.getDefault();
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(396, 20, 98, 30);
		button.setText("\u5706\u5F62\u7C7B");
		
		button.addSelectionListener(new SelectionAdapter() {
		 
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				shapeType = 4;
				
			}
			
		
		});
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(37, 71, 76, 20);
		label.setText("\u6837\u5F0F");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(37, 100, 76, 20);
		lblNewLabel.setText("\u5BBD\u5EA6");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(37, 128, 76, 20);
		lblNewLabel_1.setText("\u989C\u8272");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(143, 71, 73, 26);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(143, 100, 73, 26);
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(143, 128, 73, 26);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(24, 20, 98, 30);
		btnNewButton.setText("\u77E9\u5F62");
		btnNewButton.addSelectionListener(new SelectionAdapter() {
		 
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				shapeType = 1;
				
			}
			
		
		});
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(143, 20, 98, 30);
		btnNewButton_1.setText("\u4E94\u8FB9\u5F62");
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
		 
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				shapeType = 2;
				
			}
			
		
		});
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(273, 20, 98, 30);
		btnNewButton_2.setText("\u4E94\u89D2\u5F62");
		
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
		 
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				shapeType = 3;
				
			}
			
		
		});


		
		shell.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseDown(MouseEvent e) {
				shell.setCursor(new Cursor(null,SWT.CURSOR_CROSS));
				startX = e.x;
				startY = e.y;
				LeftButtonDown = true;
			}
			public void mouseUp(MouseEvent e) {
				if(e.button == 1) {
				IShape shape;
				shell.setCursor(new Cursor(null,SWT.CURSOR_CROSS));
				/* 将鼠标光标改为十字(按下的情况)*/
				int width = e.x - startX;
				int height = e.y - startY;
				gcMain.setLineStyle(SWT.LINE_DOT);
				gcMain.setForeground(shell.getBackground());
				gcMain.drawRectangle(startX,startY,width,height);
				gcMain.setLineStyle(SWT.LINE_SOLID);
				gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				String s = text.getText();
				
				int n = 0;
				n = Integer.parseInt(s);
				if(n==0)
					gcMain.setLineStyle(SWT.LINE_SOLID);
				else {
					gcMain.setLineStyle(SWT.LINE_DOT);
				}
				String ss = text_1.getText();
				int nu = 0;
				nu = Integer.parseInt(ss);
				gcMain.setLineWidth(nu);
				String k = new String();
				k = "red";
				
				String ssss = text_2.getText();
			
				
				if(ssss.equals(k))
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_RED));
				else {
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
				}
				
				
				switch(shapeType) {
				
				case 1:
					shape = new Rect(startX, startY, width,height,gcMain);
					break;
				case 2:
					shape = new Pentagon(startX, startY, width,height,gcMain);
					break;
					
				case 3:
					shape = new Star(startX, startY, width,height,gcMain);
					break;
				case 4:
					shape = new Circle(startX, startY, width,height,gcMain);
					break;
				default:
					shape = new Rect(startX, startY, width,height,gcMain);
				
				}
				
//				System.out.print(shapeType);
//				Star ashape;
//				ashape = new Star(startX, startY, width,height,gcMain);
//				ashape.draw();
				shape.draw();
				
				
				board.insertShape(shape);
				board.refresh();  //  处理有虚线的情况
				LeftButtonDown = false;
				}

			}
			
//			public void mouseMove(MouseEvent arg0) {
//				if(LeftButtonDown) {
//					gcMain.setLineStyle(SWT.LINE_DOT);
//					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
//					gcMain.drawRectangle(startX,startY,arg0.x - startX, arg0.y - startY);
//					gcMain.setLineStyle(SWT.BORDER_SOLID);
//				}
//			}
				
			
		});
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if(LeftButtonDown) {
					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX,startY,Lastwidth,Lastheight);
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
					gcMain.drawRectangle(startX,startY,arg0.x - startX, arg0.y - startY);
					Lastwidth = arg0.x - startX;
					Lastheight = arg0.y - startY;
					gcMain.setLineStyle(SWT.BORDER_SOLID);
				}
			}
		});
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board.refresh();
			}
		});		
		shell.setSize(537, 358);
		shell.setText("SWT Application");
		
		
		
		
		
		

	}
}
