public class WordFactory extends DocumentFactory {
    @SuppressWarnings("override")
    public Document createDocument() {
        return new WordDocument();
    }
}
