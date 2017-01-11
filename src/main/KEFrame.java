package Main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KEFrame extends JFrame implements ActionListener {
	JPanel p = new JPanel();
	JTextField text = new JTextField("パスを入力して下さい");
	JTextField text2 = new JTextField("");
	JTextField text3 = new JTextField("");
	String str = text.getText();
	String str2 = text2.getText();
	String str3 = text3.getText();
	JButton button = new JButton("出力");
	String[] combodata = {"選んでください", "二次元座標", ""};
	JComboBox combo = new JComboBox(combodata);
	public KEFrame() {
		super("KansuEmitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,175);
		text.setPreferredSize(new Dimension(200, 25));
		text.setVisible(true);
		text2.setPreferredSize(new Dimension(200, 25));
		text2.setVisible(true);
		text3.setPreferredSize(new Dimension(200, 25));
		text3.setVisible(true);
		button.addActionListener(this);
		getContentPane().add(p, BorderLayout.CENTER);
		setVisible(true);
		p.add(text);
		p.add(text2);
		p.add(text3);
		p.add(button);
		p.add(combo);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == button) {
			String data = (String)combo.getSelectedItem();
			if (combo.getSelectedItem() == "選んでください") {
				JLabel frame = new JLabel("frame");
				JOptionPane.showMessageDialog(frame, "処理が選択されていません。");
			}
				else {
					if (combo.getSelectedItem() == "二次元座標") {
						Clipboard(text.getText() + "," + text2.getText());
					}
					JLabel frame = new JLabel("frame");
					JOptionPane.showMessageDialog(frame, "構文がコピーされました");
			}
		}
	}

			/*
			if (combo.getSelectedItem() == "ファイルを開く") {
				Clipboard("Desktop.getDesktop().open(¥"" + text.getText() + "¥");");
			}
			if (combo.getSelectedItem() == "圧縮する") {
				
			}
*/
public static void Clipboard(String select) {
	Clipboard clipboard = Toolkit.getDefaultToolkit()
			.getSystemClipboard();
	StringSelection selection = new StringSelection(select);
	clipboard.setContents(selection, selection);
}}
