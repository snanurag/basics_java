package lld.chess;

public enum Move {
    CROSS{
        public boolean validSteps(int i, int j, int x, int y){
            return false;
        }
    },
    STRAIGHT{
        public boolean validSteps(int i, int j, int x, int y){
            return false;
        }
    },
    L{
        public boolean validSteps(int i, int j, int x, int y){
            return false;
        }
    },
    ALL_DIR{
        public boolean validSteps(int i, int j, int x, int y){
            return false;
        }
    },
    ONE_UP{
        public boolean validSteps(int i, int j, int x, int y){
            return false;
        }
    },
    ;

    public boolean validSteps(int i, int j, int x, int y){
        return false;
    }

}
