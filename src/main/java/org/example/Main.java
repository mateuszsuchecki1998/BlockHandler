package org.example;

import org.example.blocks.BasicBlock;
import org.example.blocks.BasicCompositeBlock;
import org.example.blocks.Block;
import org.example.structures.Wall;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //BLOCKS
        Block redBrick = new BasicBlock("Red", "Brick");
        Block redStone = new BasicBlock("Red", "Stone");

        Block brownStone = new BasicBlock("Brown", "Stone");

        Block greyStone = new BasicBlock("Gray", "Stone");

        Block yellowSand = new BasicBlock("Yellow", "Sand");

        Block blackBrick = new BasicBlock("Black", "Brick");
        Block blackStone = new BasicBlock("Black", "Stone");
        Block blackWood = new BasicBlock("Black", "Wood");


        //COMPOSITE BLOCKS
        var redCompositeBlock = new BasicCompositeBlock(redBrick, redStone);
        var sandStoneBrickBlock = new BasicCompositeBlock(yellowSand, brownStone, blackBrick);
        var sandCompositeBlockBlock = new BasicCompositeBlock(yellowSand, redCompositeBlock);


        //WALL
        Wall wall = new Wall(greyStone, blackStone, blackWood, sandCompositeBlockBlock);


        //TESTS for Wall: Structure -> FindBlockByColor(), FindBlocksByMaterial(), count(),
        System.out.println("Method -> FindBlockByColor()");
            Optional<Block> redBlock = wall.findBlockByColor("Red");
            redBlock.ifPresentOrElse(
                    block -> System.out.println("Block found by color: " + block),
                    () -> System.out.println("Block not found by color")
            );

        System.out.println("\nMethod -> FindBlocksByMaterial()");
            List<Block> blocksByMaterial = wall.findBlocksByMaterial("Stone");
            System.out.println("Blocks found by material:");
            blocksByMaterial.forEach(System.out::println);

        System.out.println("\nMethod -> count()");
            System.out.println("Total number of blocks in the wall: " + wall.count());

        //TESTS for CompositeBlock: Block -> getBlocks
        System.out.println("\nCompositeBlock -> getBlocks()");
        List<Block> allBlocks = sandStoneBrickBlock.getBlocks();
            System.out.println("All blocks in the wall:");
            allBlocks.forEach(System.out::println);
    }
}