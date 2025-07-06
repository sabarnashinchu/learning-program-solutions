public class ExcelDocument implements Document {
    @SuppressWarnings("override")
    public void open() {
        System.out.println("Opening Excel document...");
    }
}
