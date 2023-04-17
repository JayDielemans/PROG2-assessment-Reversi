public class Player {

    String name;
    Mark markColor;
    int score;

    public Player(String name, Mark markColor) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.markColor = markColor;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public Mark getMarkColor() {
        return markColor;
    }

    public void changeMarkColor() {
        if (markColor == Mark.BLACK) {
            this.markColor = Mark.WHITE;
        } else {
            this.markColor = Mark.BLACK;
        }
    }

    public void registerWin() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
