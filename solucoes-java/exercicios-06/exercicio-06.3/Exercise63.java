import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<FieldEntry> entries = new ArrayList<>();

        System.out.println("--- Data Converter (JSON, XML, YAML) ---");
        System.out.println("Format: FIELD_NAME;VALUE;TYPE");
        System.out.println("Types: text, int, float, boolean, date");
        System.out.println("Type 'exit' to finish and generate files.\n");

        while (true) {
            System.out.print("Enter data: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            String[] parts = input.split(";");
            if (parts.length == 3) {
                entries.add(new FieldEntry(parts[0], parts[1], parts[2]));
            } else {
                System.out.println("Invalid format! Use: name;value;type");
            }
        }

        if (!entries.isEmpty()) {
            System.out.println("\n--- JSON OUTPUT ---");
            System.out.println(generateJSON(entries));

            System.out.println("\n--- XML OUTPUT ---");
            System.out.println(generateXML(entries));

            System.out.println("\n--- YAML OUTPUT ---");
            System.out.println(generateYAML(entries));
        }

        scanner.close();
    }

    private static String generateJSON(List<FieldEntry> entries) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int i = 0; i < entries.size(); i++) {
            FieldEntry e = entries.get(i);
            sb.append("  \"").append(e.name).append("\": ");

            // Format value based on type
            if (e.type.equals("text") || e.type.equals("date")) {
                sb.append("\"").append(e.value).append("\"");
            } else {
                sb.append(e.value); // Numbers and booleans don't use quotes
            }

            if (i < entries.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String generateXML(List<FieldEntry> entries) {
        StringBuilder sb = new StringBuilder("<root>\n");
        for (FieldEntry e : entries) {
            sb.append("  <").append(e.name).append(" type=\"").append(e.type).append("\">");
            sb.append(e.value);
            sb.append("</").append(e.name).append(">\n");
        }
        sb.append("</root>");
        return sb.toString();
    }

    private static String generateYAML(List<FieldEntry> entries) {
        StringBuilder sb = new StringBuilder("---\n");
        for (FieldEntry e : entries) {
            sb.append(e.name).append(": ");
            if (e.type.equals("text") || e.type.equals("date")) {
                sb.append("\"").append(e.value).append("\"\n");
            } else {
                sb.append(e.value).append("\n");
            }
        }
        return sb.toString();
    }
}
