package clipboardwrapper;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ClipboardWrapper {
	private Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
	private StringSelection selection;
	private CopiedTextParser cTParser = new CopiedTextParser();
	
	public ClipboardWrapper() {
		
	}
	
	public void copyToClipBoard(String text) {
		selection = new StringSelection(cTParser.parseCopiedText(text));
		clipBoard.setContents(selection, null);
		System.out.println("This is copied text "+ cTParser.parseCopiedText(text));
	}
	
	public static void main(String [] args) {
		String txt  = "this is test text2";
		ClipboardWrapper cw = new ClipboardWrapper();
		cw.copyToClipBoard(txt.strip());
		
		
	}
	
	
}
