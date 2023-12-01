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
        var redBrick_redStone = new BasicCompositeBlock(redBrick, redStone);
        var blackWood_redStone = new BasicCompositeBlock(blackWood, redStone);
        var yellowSand_brownStone_blackBrick = new BasicCompositeBlock(yellowSand, brownStone, blackBrick);
        var yellowSand_redBrick_redStone = new BasicCompositeBlock(yellowSand, redBrick_redStone);


        //WALL Zakładam, że Wall może byc zbudowany z więcej niż jednego materiału
        Wall wall = new Wall(greyStone, blackStone, blackWood, blackStone, blackWood_redStone, redBrick, yellowSand_redBrick_redStone);


        // TESTS for Wall: Structure ->
        // FindBlockByColor()
        var tmpColor = "Red";
        System.out.println("\nAny _" + tmpColor + "_ color Block found in wall:");
        Optional<Block> redBlock = wall.findBlockByColor(tmpColor);
        redBlock.ifPresentOrElse(
                color -> System.out.println("-> " + color),
                () -> System.out.println("Block not found.")
        );

        // FindBlocksByMaterial()
        var tmpMaterial = "Stone";
        System.out.println("\nAll _" + tmpMaterial + "_ material Block found in wall:");
        List<Block> blocksByMaterial = wall.findBlocksByMaterial(tmpMaterial);
        blocksByMaterial.forEach((material) -> System.out.println("-> " + material));

        // count(),
        System.out.println("\nMethod -> count()");
        System.out.println("Total number of blocks in the wall: " + wall.count());

        //TESTS for CompositeBlock: Block -> getBlocks
        System.out.println("\nCompositeBlock yellowSand_brownStone_blackBrick -> getBlocks()");
        List<Block> allBlocks = yellowSand_brownStone_blackBrick.getBlocks();
        allBlocks.forEach(block -> System.out.println("->" + block));

        System.out.println("\nCompositeBlock yellowSand_redBrick_redStone -> getBlocks()");
        List<Block> allBlocks2 = yellowSand_redBrick_redStone.getBlocks();
        allBlocks2.forEach(block -> System.out.println("->" + block));
    }
}