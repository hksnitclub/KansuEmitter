package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KEFrame extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JTextField text = new JTextField("パスを入力して下さい");
	String str = text.getText();
	JButton button = new JButton("出力");
	public KEFrame() {
		super("KansuEmitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		text.setPreferredSize(new Dimension(200, 25));
		text.setVisible(true);
		button.addActionListener(this);
		getContentPane().add(p, BorderLayout.CENTER);
		setVisible(true);
		p.add(text);
		p.add(button);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == button) {
			/*ボタンをおした時
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable transferable = clipboard.getContents(null);
			if (transferable != null) {
				try {
					text.setText(transferable.getTransferData(DataFlavor.stringFlavor).toString());
				} catch (UnsupportedFlavorException | IOException e1) {
					text.setText(e1.getMessage());
				}
			}
		}*/
			
		//copyToClipboad("Desktop.getDesktop().open();");
		Clipboard("Desktop.getDesktop().open(" + text.getText() + ");");
	}
	/*public void JTextField() {
		JPanel panelBase = new JPanel();
		JTextField text = new JTextField("パスを入力して下さい");
		text.setMargin(new Insets(5, 10, 5, 10));
		text.setSize(50,10);
		text.setVisible(true);
		String str = text.getText();
	}*/
}
public static void Clipboard(String select) {
	Clipboard clipboard = Toolkit.getDefaultToolkit()
			.getSystemClipboard();
	StringSelection selection = new StringSelection(select);
	clipboard.setContents(selection, selection);
}}
