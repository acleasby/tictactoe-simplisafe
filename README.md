This README provides instructions for building and running the TicTacToe game using Docker.

## Purpose

This project implements a TicTacToe game player.  Moves are randomly generated on a 4x4 board and play
continues until the game is won or no more moves are available.

The primary implementation class is `TicTacToe` where the board is generated
and managed.  The game is driven from the `Main` class, which is responsible for creating the game, generating
the moves, and checking for win conditions.

## Prerequisites
- [Docker](https://www.docker.com/get-started) installed on your system
- Basic knowledge of Docker commands

## Building the Docker Image
To build the Docker image for the TicTacToe game, follow these steps:
1. Clone this repo to your local machine
2. Navigate to the root directory of the project
3. Build the Docker image with the following command:
``` bash
docker build -t tictactoe .
```
This command builds a Docker image and tags it as `tictactoe`.  The image build process will compile the code
and run the unit tests.

## Running the TicTacToe Game
Once the Docker image is built, you can run the TicTacToe game using:
``` bash
docker run tictactoe
```

Game output including moves, outcome, and final board will be shown in the terminal.  Games
are random, and you may wish to run several games to see various outcomes.
