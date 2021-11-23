public enum State {
    ALABAMA("AL"),
    ALASKA("AK"),
    ARIZONA("AZ");

    private String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
