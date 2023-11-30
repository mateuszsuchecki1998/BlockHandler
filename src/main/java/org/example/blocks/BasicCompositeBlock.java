package org.example.blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*todo: 1. przetworzyć na abstrakcyjną,
        2. dodać wystarczająco dużo klas rozszerzających BasicCompositeBlock
        3. mozna się pochylić nad wzorcem Builder lub Factory*/
public class BasicCompositeBlock implements CompositeBlock {

    private List<Block> blocks = new ArrayList<>();

    public BasicCompositeBlock(Block... blocks){
        this.blocks.addAll(Arrays.asList(blocks));
    }

    public BasicCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return blocks.stream().map(block -> block.getColor() + ", ").collect(Collectors.joining());
    }

    @Override
    public String getMaterial() {
        return blocks.stream().map(block -> block.getMaterial() + ", ").collect(Collectors.joining());
    }


    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String toString() {
        return "CompositeBlock build with: " +
            Arrays.toString(blocks.toArray());
    }
}
