public class WordMatch {
    private final String word;
    public WordMatch(String word) {
        this.word = word;
    }
    public int scoreGuess(String guess) {
        if (guess == null || guess.isEmpty()) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        else if (guess.length() > word.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        else {
            int score = 0;
            for (int i = 0; i < word.length() - guess.length() +1; i++) {
                if (word.substring(i, i + guess.length()).equals(guess)) {
                    score += 1;
                }
                //System.out.println("Current Score: " + score);
                //System.out.println("Word: " + word.substring(i, i + guess.length()));
            }
            score *= (int) Math.pow(guess.length(), 2);
            return score;
        }
    }
    public String findBetterGuess(String guess1, String guess2) {
        if (scoreGuess(guess1) > scoreGuess(guess2)) {
            return guess1;
        }
        else if (scoreGuess(guess2) > scoreGuess(guess1)){
            return guess2;
        }
        else {
            if (guess1.compareTo(guess2) < 0) {
                return guess2;
            }
        }
        return guess1;
    }
}
