package org.example.blocks;

/*todo: 1. przetworzyć na abstrakcyjną,
        2. dodać wystarczająco dużo klas rozszerzających BasicBlock
        3. mozna się pochylić nad wzorcem Builder lub Factory*/
public class BasicBlock implements Block {
    private String color;
    private String material;

    public BasicBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return String.format("BasicBlock: %s%s", color, material);
    }
}
