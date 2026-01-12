package Editorium;

@FunctionalInterface
public interface PartRunner {
	public Part[] runParts(Part part, int number, Editor editor);
}
