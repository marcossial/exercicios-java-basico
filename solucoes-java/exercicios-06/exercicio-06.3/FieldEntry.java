public class FieldEntry {
    String name;
    String value;
    String type;

    public FieldEntry(String name, String value, String type) {
        this.name = name;
        this.value = value;
        this.type = type.toLowerCase();
    }
}
