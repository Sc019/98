def isSafe(board, row, col, n):
    # Check the column on the left
    for i in range(col):
        if board[row][i] == 1:
            return False

    # Check the upper diagonal on the left
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    # Check the lower diagonal on the left
    for i, j in zip(range(row, n), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    return True

def solveNQueens(board, col, n):
    if col == n:
        return True  # All Queens are placed

    for i in range(n):
        if isSafe(board, i, col, n):
            board[i][col] = 1  # Place the Queen

            # Recur to place the rest of the Queens
            if solveNQueens(board, col + 1, n):
                return True

            # If placing a Queen in board[i][col] doesn't lead to a solution, backtrack
            board[i][col] = 0

    # If no Queen can be placed in this column, return False
    return False

def printSolution(board):
    n = len(board)
    for i in range(n):
        for j in range(n):
            print(board[i][j], end=" ")
        print()

def nQueens(n):
    board = [[0] * n for _ in range(n)]
    
    import time
    t1 = time.time()
    if not solveNQueens(board, 0, n):
        print("\nNo solution exists.")
    else:
        t2 = time.time()
        duration = (t2 - t1) * 1000  # Convert to milliseconds
        print("\nSolution:")
        printSolution(board)
        print(f"\nTime taken: {duration} milliseconds\n")

if __name__ == "__main__":
    n = int(input("\nEnter the board size (n): "))
    nQueens(n)
'''Enter the board size (n): 8

Solution:
0 0 0 0 0 0 0 1 
0 0 0 0 0 0 0 0 
0 0 0 0 0 1 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 
0 0 0 0 0 0 0 0 

Time taken: 34.08002853393555 milliseconds
'''