package Editorium;

public class Reader extends Part implements Runnable{
	private Editor editor;

	
	public Reader(Editor editor) {
		this.editor = editor;
	}
	
	public Reader() {
		
	}
	
	@Override
	public Editor getEditor() {
		return editor;
	}

	@Override
	public void setEditor(Editor editor) {
		this.editor = editor;
	}

	private void getMessage() {
		
		while(!this.editor.isStop()) {
			this.editor.getPart();
		}

	}

	@Override
	public void run() {
		getMessage();
		
	}
}
