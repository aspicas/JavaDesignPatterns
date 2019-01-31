package structural.flyweight;

class FormattedTex {
    private String plainText;
    private boolean [] capitalize;

    public FormattedTex(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end) {
        for (int i = start; i <= end; ++i)
            capitalize[i] = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            sb.append(
                    capitalize[i] ? Character.toUpperCase(c) : c
            );
        }
        return sb.toString();
    }
}

class Demo27 {
    public static void main(String[] args) {
        FormattedTex ft = new FormattedTex("This is a brave new world");
        ft.capitalize(10, 15);
        System.out.println(ft.toString());
    }
}