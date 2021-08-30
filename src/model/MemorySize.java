package model;

public class MemorySize {

    private int memorySize;

    public MemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "Espacio de memoria= " + memorySize +" kb";
    }
}
