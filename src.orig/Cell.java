public class Cell {
    boolean currentGen, nextGen;

    public Cell(){
        setCurrentGen(false);
        setNextGen(false);
    }

    public Cell(boolean alive) {
        setCurrentGen(alive);
    }

    public void setCurrentGen(boolean alive) {
        currentGen = alive;
    }

    public boolean isAlive() {
        return currentGen;
    }

    public void setNextGen(boolean alive) {
        nextGen = alive;
    }

    public void advance() {
        this.currentGen = this.nextGen;
        this.nextGen = false;
    }

    public String toString() {
        if (currentGen == true) {
            return "1";
        } else {
            return "0";
        }
    }

}
