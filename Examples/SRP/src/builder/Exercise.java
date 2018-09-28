package builder;

import java.util.ArrayList;

class CodeBuilder {

    public ArrayList<String> fields = new ArrayList<>();
    private final String newLine = System.lineSeparator();

    public CodeBuilder(String className) {
        fields.add(String.format("public class %s%s{%s", className, newLine, newLine));
    }

    public CodeBuilder addField(String name, String type) {
        if (!name.isEmpty() && !type.isEmpty()) {
            String field = String.format("  public %s %s;%s", type, name, newLine);
            fields.add(field);
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String field : fields)
            sb.append(field);
        sb.append(String.format("}%s", newLine));
        return sb.toString();
    }

}

class Demo8 {
    public static void main(String[] args) {
        CodeBuilder cb = new CodeBuilder("Person")
                .addField("name", "String")
                .addField("age", "int");
        System.out.println(cb);
    }
}