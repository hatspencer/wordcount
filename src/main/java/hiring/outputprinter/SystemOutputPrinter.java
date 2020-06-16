package hiring.outputprinter;

public class SystemOutputPrinter implements OutputPrinter {

	@Override
	public void print(String s) {
		System.out.print(s);
	}

}
