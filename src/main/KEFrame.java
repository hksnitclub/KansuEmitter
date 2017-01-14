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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KEFrame extends JFrame implements ActionListener {
	public String version = "Beta2.00"; //バージョン情報
	public String viewversion_text = "関数えみったーVer." + version;


	JMenuBar menubar = new JMenuBar();
	JPanel p = new JPanel();
	JMenu menu1 = new JMenu("メニュー");
	JMenu menu2 = new JMenu("ヘルプ");
	JMenuItem menuitem11 = new JMenuItem("終了する");
	JMenuItem menuitem21 = new JMenuItem("バージョン情報");
	JMenuItem menuitem22 = new JMenuItem("連絡先");
	JTextField text = new JTextField("入力して下さい");
	JTextField text2 = new JTextField("入力して下さい");
	JTextField text3 = new JTextField("入力して下さい");
	JTextField text4 = new JTextField("入力してください");
	String str = text.getText();
	String str2 = text2.getText();
	String str3 = text3.getText();
	JButton button = new JButton("出力");
	String[] combodata = {"選んでください", "二次元座標", "[HTML]リンク", "[HTML]iframe"};
	JComboBox combo = new JComboBox(combodata);
	public KEFrame() {
		super("KansuEmitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);
		text.setPreferredSize(new Dimension(200, 25));
		text.setVisible(true);
		text2.setPreferredSize(new Dimension(200, 25));
		text2.setVisible(true);
		text3.setPreferredSize(new Dimension(200, 25));
		text3.setVisible(true);
		text4.setPreferredSize(new Dimension(200, 25));
		text4.setVisible(true);
		button.addActionListener(this);
		menuitem11.addActionListener(this);
		menuitem21.addActionListener(this);
		getContentPane().add(p, BorderLayout.CENTER);
		setVisible(true);
		p.add(menubar);
		menubar.add(menu1);
		menu1.add(menuitem11);
		menubar.add(menu2);
		menu2.add(menuitem21);
		menu2.add(menuitem22);
		p.add(text);
		p.add(text2);
		p.add(text3);
		p.add(text4);
		p.add(button);
		p.add(combo);

	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == button) {
			String data = (String)combo.getSelectedItem();
			if (data == "選んでください") {
				JLabel frame = new JLabel("frame");
				JOptionPane.showMessageDialog(frame, "処理が選択されていません。");
			}
				else {
					if (data == "二次元座標") {
						Clipboard(text.getText() + "," + text2.getText());
					}
					if (data == "[HTML]リンク") {
						Clipboard("<a href=text.getText)" + '"' + text.getText() + '"' + '>');
					}
					if (data == "[HTML]iframe") {
						Clipboard("<iframe src=" + '"' + text.getText() + '"' + " width=" + text2.getText() + " height=" + text3.getText() + ">" + text4.getText() + "</iframe>");
					}
					JLabel frame = new JLabel("frame");
					JOptionPane.showMessageDialog(frame, "構文がコピーされました");

			}
		}
		if (e.getSource() == menuitem11) {
			System.exit(0);
		}
		if (e.getSource() == menuitem21) {
			JLabel frame = new JLabel("frame");
			JOptionPane.showMessageDialog(this, viewversion_text);
		}
	}

	public void menuitem21Action(ActionEvent e2) {

	}

			/*
			if (combo.getSelectedItem() == "ファイルを開く") {
				Clipboard("Desktop.getDesktop().open( + text.getText() + "¥");");
			}
			if (combo.getSelectedItem() == "圧縮する") {

			}
*/
	public static void Clipboard(String select) { //構文コピーメソッド
		Clipboard clipboard = Toolkit.getDefaultToolkit()
				.getSystemClipboard();
		StringSelection selection = new StringSelection(select);
		clipboard.setContents(selection, selection);
	}
}
/* このプログラムを修正してくれた電車君とﾔｷﾆｷ、助言をしてくれた零阪父に感謝。 */