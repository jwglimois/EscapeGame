# Project Title: EscapeGame

EscapeGame is a logical game. The goal is to find the secret number. The player can have up to 10 rounds. The player begins by choosing 3 play modes: Challenger, Defender, and Duel.

* Mode Challenger: 
    The computer sets a 4-digit number and asks the player to guess.
    The player enters his 4-digit number. 
    The computer gives a hint to the player with the following symbols:
      •	+ : The right number should be plus
      •	- : The right number should be minus
      •	= : The right number equals to the give one. 

* Mode Defender: 
    The player sets a 4-digit number and asks the computer to guess.
    The computer enters his 4-digit number. 
    The player gives a hint to the computer with the same symbols above.

* Mode Duel: 
    The player and the computer takes turns to play. The first one to find the secret number wins. 

## Getting Started

The game works only with Windows Console. To lanch the game, you can press Windows Key + R to open the Command Prompt (cmd) and type "java -jar YourPathWhereYouStoreTheGame" as the example as follows. Then, presse "Enter". 

```
java -jar C:\Users\Jia-Wen\Desktop\EscapeGame.jar
```

### Prerequisites

To run a Java program in your Command Prompt, first, you need to have JDK (Java Development Toolkit) installed. You can download the last version on the website of Oracle: https://www.oracle.com/technetwork/java/javase/downloads/index.html. Secondly, you need to configurate your environment variable so that Command Prompt can find where JDK has been installed. You can refer to this web page for the configuration : https://javatutorial.net/set-java-home-windows-10

Finally, for the quality of the game, we strongly recommand that you run the game with Windows 8 or 10. 

### Installing

Download the game from Github: https://github.com/jwglimois/EscapeGame/blob/master/out/artifacts/EscapeGame_jar/EscapeGame.jar

Once entering to this web page, you click on "Download". You can save it to your repository.

## Running the tests

The unit tests have been done mainly for InputChecker and Computer Classes. Check the repository where you can find the test files: https://github.com/jwglimois/EscapeGame/tree/master/test/com/oc/jiawen


## Deployment

To deploy this game on a live system, make sure to have JDK installed and environment variable configured for Java programs.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit5](https://junit.org/junit5/) - Used to generate unit tests


## Versioning

Version 1.0 04/10/2019, in Paris
We use [Git](https://git-scm.com/) for versioning. For the version available, see our last projet on: https://github.com/jwglimois/EscapeGame.

## Author

* **Jia-Wen GLIMOIS** 

## License

This game is an open source projet without license.
