def isValidMove(board, col, row):
    c = 1
    for i in range(col-1, -1, -1):
        if board[i] == row:
            return False                #Rooks Move
        if board[i] == row - c:
            return False                #above knights move
        if board[i] == row + c:
            return False                #below knights move
        c += 1
    return True

def SolvenQueen(board, col, size):
    if col == size:
        return True
    for i in range(size):
        if isValidMove(board, col, i):
            board[col] = i
            if SolvenQueen(board, col+1, size):
                return True
    board[col] = None
    return False

def nQueen(size):
    board = [None]*size
    if SolvenQueen(board, 0, size):
        print("The Queens Have been placed")
        print(board)
        a = [[" . " for i in range(size)] for j in range(size)]
        for i in range(size):
            a[board[i]][i] = ' Q '
        for i in range(size):
            print(a[i])
        return True
    else:
        print("No Solution Possible")
        return False

if __name__ == '__main__':
    # assert nQueen(3) == False
    # assert nQueen(4) == True
    # board = [None]*4
    # assert SolvenQueen(board, 0 ,4)
    size = int(input("Enter size of board : "))
    nQueen(size)
