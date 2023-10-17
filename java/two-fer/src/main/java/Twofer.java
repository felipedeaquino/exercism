public class Twofer {
    public String twofer(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            return "One for you, one for me.";
        } else {
            return String.format("One for %s, one for me.", name);
        }
    }
}
