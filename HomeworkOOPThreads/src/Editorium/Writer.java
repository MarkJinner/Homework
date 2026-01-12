package Editorium;

public class Writer extends Part implements Runnable{

	private String message;
	private Editor editor;
	
	public Writer(Editor editor) {
		this.editor = editor;
	}
	
	public Writer() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Editor getEditor() {
		return editor;
	}

	@Override
	public void setEditor(Editor editor) {
		this.editor = editor;
	}
	
	private void provideText() {
		
		for(int i = 0; i< this.editor.getMaxParts();i++) {
			
			this.editor.setPart((i+1)+"");
		}
		if(this.editor.getMaxWriters()==1) {
			this.editor.setStop(true);	
		}
//		
		
	}

	@Override
	public void run() {

		provideText();
		
	}
	
	

}
