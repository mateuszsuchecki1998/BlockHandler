package org.example.structures;

import org.example.blocks.Block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks = new ArrayList<>();

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    public Wall(Block... blocks) {
        this.blocks.addAll(Arrays.asList(blocks));
    }

    // Pytanie: jeżeli compositeBlock posiada np. dwa bloki czarny i biały,
    // a chcę wyszukać bloków białych to powinienem go (compositeBlock) dodać do zwracanej listy?
    // Założyłem, że tak.
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().filter(block -> block.getColor().contains(color)).findAny();
    }

    // Pytanie: jeżeli compositeBlock posiada np. dwa bloki kamienne i piaszczyste,
    // a chcę wyszukać bloków piaszczystych to powinienem go (compositeBlock) dodać do zwracanej listy?
    // Założyłem, że tak.
    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().filter(block -> block.getMaterial().contains(material)).collect(Collectors.toList());
    }

    //Rozumiem, że CompositeBlock jest liczony jako 1 blok, a nie suma bloków wewnątrz.
    @Override
    public int count() {
        return blocks.size();
    }
}