import java.util.Random;

public class CoinTossGame {

    private Random random;

    public CoinTossGame() {
        this.random = new Random();
    }

    // Simulates coin tosses and returns the outcome as a string
    public String simulateCoinTosses(int n) {
        StringBuilder outcomes = new StringBuilder();
        for (int i = 0; i < n; i++) {
            outcomes.append(random.nextBoolean() ? 'H' : 'T');
        }
        return outcomes.toString();
    }

    // Calculates scores for Alice and Bob based on the outcomes
    public int[] calculateScores(String outcomes) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < outcomes.length() - 1; i++) {
            String pair = outcomes.substring(i, i + 2);
            if (pair.equals("HH")) {
                aliceScore++;
            } else if (pair.equals("HT")) {
                bobScore++;
            }
        }

        return new int[]{aliceScore, bobScore};
    }

    // Determines the winner based on scores
    public String determineWinner(int aliceScore, int bobScore) {
        if (aliceScore > bobScore) {
            return "Alice";
        } else if (bobScore > aliceScore) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    // Calculates probabilities for small values of n
    public double[] calculateProbabilities(int n, int simulations) {
        int aliceWins = 0;
        int bobWins = 0;
        int ties = 0;

        for (int i = 0; i < simulations; i++) {
            String outcomes = simulateCoinTosses(n);
            int[] scores = calculateScores(outcomes);
            String winner = determineWinner(scores[0], scores[1]);

            switch (winner) {
                case "Alice":
                    aliceWins++;
                    break;
                case "Bob":
                    bobWins++;
                    break;
                case "Tie":
                    ties++;
                    break;
            }
        }

        double[] probabilities = new double[3];
        probabilities[0] = (double) aliceWins / simulations; // P(A wins)
        probabilities[1] = (double) bobWins / simulations;   // P(B wins)
        probabilities[2] = (double) ties / simulations;       // P(tie)

        return probabilities;
    }

    // Calculates probabilities for large values of n using dynamic programming
    public double[] calculateLargeProbabilities(int n) {
        int[][] dp = new int[n + 1][2]; // dp[i][0] for Alice, dp[i][1] for Bob

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + (i > 2 ? dp[i - 2][0] : 0); // HH
            dp[i][1] = dp[i - 1][1] + (i > 1 ? 1 : 0); // HT
        }

        double total = dp[n][0] + dp[n][1];
        return new double[]{
            dp[n][0] / total, // P(A wins)
            dp[n][1] / total, // P(B wins)
            (1 - (dp[n][0] / total) - (dp[n][1] / total)) // P(tie)
        };
    }

    public static void main(String[] args) {
        CoinTossGame game = new CoinTossGame();
        int simulations = 10000;

        // Calculate probabilities for small values of n
        for (int n = 2; n <= 5; n++) {
            double[] probabilities = game.calculateProbabilities(n, simulations);
            System.out.printf("Probabilities for n=%d: Alice: %.4f, Bob: %.4f, Tie: %.4f%n", n, probabilities[0], probabilities[1], probabilities[2]);
        }

        // Calculate probabilities for large value of n
        int n = 1024;
        double[] largeProbabilities = game.calculateLargeProbabilities(n);
        System.out.printf("Probabilities for n=%d: Alice: %.4f, Bob: %.4f, Tie: %.4f%n", n, largeProbabilities[0], largeProbabilities[1], largeProbabilities[2]);
    }
}
