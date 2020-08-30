Requirements:
1) Input from commandLine about piece to move
2) Display the board

Actor:
1) Players

UseCase:
1) Players taking turn to move pieces

Design:
1) ChessBoard class implementing Board interface
2) ChessBoard will have a mtrix of Square class 
3) Square class will have reference to Piece class
4) Piece interface -> all chess pieces will implement it
5) Player interface -> Players_Concrete
6) Game class -> Board and Players and History of Moves (Builder pattern) (Memento Pattern)
7) GameOrchestrator -> Reference to Game (SingleTon)   
8) Move class

