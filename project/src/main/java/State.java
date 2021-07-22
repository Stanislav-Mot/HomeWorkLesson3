public enum State {
    ALABAMA("AL"),
    ALASKA("AK"),
    ARIZONA("AZ"),
    ARKANSAS("AR"),
    CALIFORNIA("CA"),
    COLORADO("CO"),
    CONNECTICUT("CT"),
    MASSACHUSETTS("MA");

    private String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
