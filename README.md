# Coin Toss Game - README

## Overview

This project replicates Alice and Bob playing a game of coin toss. In addition to calculating the odds of each player winning and the potential for a tie, the game keeps score depending on the toss results.

## Features

- Recreates a coin-tossing game for a predetermined amount of flips.
- Determines the likelihood of a tie as well as Alice and Bob's winning probabilities.
- uses dynamic programming to handle huge values of tosses (up to 1024) efficiently.


## Requirements

- Java Development Kit (JDK) 8 or higher.
- Any Java IDE (like IntelliJ IDEA, Eclipse, or NetBeans) or a text editor (like Visual Studio Code).


## Running the Program

1. **Compile the Java files** (if using the command line):
   javac CoinTossGame.java 

2. **Run the program**:
   java CoinTossGame.java

3. The output will display the probabilities for `n = 2`, `3`, `4`, and `5`, as well as the probabilities for `n = 1024`.

## Sample Output

```
Probabilities for n=2: Alice: 0.2500, Bob: 0.5000, Tie: 0.2500
Probabilities for n=3: Alice: 0.3330, Bob: 0.3330, Tie: 0.3340
Probabilities for n=4: Alice: 0.4000, Bob: 0.2000, Tie: 0.4000
Probabilities for n=5: Alice: 0.2000, Bob: 0.6000, Tie: 0.2000
Probabilities for n=1024: Alice: 0.3333, Bob: 0.3333, Tie: 0.3333
```

## Documentation

- The source code has extensive documentation that explains the reasoning and flow through comments.
- See the code comments for thorough descriptions of the algorithms and performance analysis.


## Conclusion

This project shows how to use dynamic programming and simulations to efficiently calculate probability and simulate a basic stochastic process.

