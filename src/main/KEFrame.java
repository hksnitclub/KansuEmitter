package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

@SuppressWarnings("serial")
public class KEFrame extends JFrame implements ActionListener {
	public String version = "Beta2.1"; // バージョン情報
	public String viewversion_text = "関数えみったーVer." + version;

	public static void main(String[] args) throws IOException {
		//String path = ""
		File newdir = new File("./Addons");
		File newfile = new File("./Addons/Addlist.txt");
		newdir.mkdir();
		try {
			newfile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(String[] args) throws IOException {
		File list = new File("./Addons/Addlist.txt");
		FileReader filereader = new FileReader(list);
		BufferedReader br = new BufferedReader(filereader);

		String str4 = br.readLine();
		
		br.close();
	}

	JMenuBar menubar = new JMenuBar();
	JPanel p = new JPanel();
	JMenu menu1 = new JMenu("メニュー");
	JMenu menu2 = new JMenu("ヘルプ");
	JMenuItem menuitem11 = new JMenuItem("終了する");
	JMenuItem menuitem21 = new JMenuItem("バージョン情報");
	JMenuItem menuitem22 = new JMenuItem("連絡先");
	JMenuItem menuitem23 = new JMenuItem("入力ヘルプ");
	JTextField text = new JTextField("入力して下さい");
	JTextField text2 = new JTextField("入力して下さい");
	JTextField text3 = new JTextField("入力して下さい");
	JTextField text4 = new JTextField("入力してください");
	String str = text.getText();
	String str2 = text2.getText();
	String str3 = text3.getText();
	JButton button = new JButton("出力");
	String[] combodata = { "選んでください", "二次元座標", "[HTML]リンク", "[HTML]iframe", "", "デバッグ用" };
	JComboBox combo = new JComboBox(combodata);

	public KEFrame() {
		super("KansuEmitter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(280, 225);
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
		menuitem22.addActionListener(this);
		menuitem23.addActionListener(this);
		getContentPane().add(p, BorderLayout.CENTER);
		setVisible(true);
		p.add(menubar);
		menubar.add(menu1);
		menu1.add(menuitem11);
		menubar.add(menu2);
		menu2.add(menuitem21);
		menu2.add(menuitem22);
		menu2.add(menuitem23);
		p.add(text);
		p.add(text2);
		p.add(text3);
		p.add(text4);
		p.add(button);
		p.add(combo);
	}

	public void actionPerformed(ActionEvent e) {
		String data = (String) combo.getSelectedItem();
		JLabel frame = new JLabel("frame");
		if (e.getSource() == button) {
			if (data == "選んでください") {

				JOptionPane.showMessageDialog(frame, "処理が選択されていません。");
			} else {
				if (data == "二次元座標") {
					Clipboard(text.getText() + "," + text2.getText());
				}
				if (data == "[HTML]リンク") {
					Clipboard("<a href=" + '"' + text.getText() + '"' + '>' + text2.getText() + "</iframe>");
				}
				if (data == "[HTML]iframe") {
					Clipboard("<iframe src=" + '"' + text.getText() + '"' + " width=" + text2.getText() + " height="
							+ text3.getText() + ">" + text4.getText() + "</iframe>");
				}
				if (data == "デバッグ用") {
					Clipboard("text=" + text.getText() + "text2=" + text2.getText() + "text3=" + text3.getText()
							+ "text4=" + text4.getText());
				}
				JOptionPane.showMessageDialog(frame, "構文がコピーされました");

			}
		}
		if (e.getSource() == menuitem11) {
			System.exit(0);
		}
		if (e.getSource() == menuitem21) {
			JOptionPane.showMessageDialog(this, viewversion_text);
		}
		if (e.getSource() == menuitem22) {
			JOptionPane.showMessageDialog(this, "SkypeID:LoopLine201 までどうぞ");
		}
		if (e.getSource() == menuitem23) {
			if (data == "選んでください") {
				Dialog("処理が選択されていません。");
			}
			if (data == "二次元座標") {
				Dialog("上からX座標、Y座標です。下二つは使いません。");
			}
			if (data == "[HTML]リンク") {
				Dialog("上からリンク先URL、テキストです。下二つは使いません。");
			}
			if (data == "[HTML]iframe") {
				Dialog("上から埋め込むページのパス、幅、高さ、iframeが非対応のブラウザでアクセスされたときに表示されるテキストです。");
			}
			if (data == "デバッグ用") {
				Dialog("開発者用です。");
			}
		}
	}

	public void Dialog(String text) {
		JOptionPane.showMessageDialog(this, text);
	}

	public static void Clipboard(String select) { // 構文コピーメソッド
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection(select);
		clipboard.setContents(selection, selection);
	}
}
/* このプログラムを修正してくれた電車君とﾔｷﾆｷ、助言をしてくれた零阪父に感謝。 */
