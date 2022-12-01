package aoc.twentytwo.solutions;

import aoc.twentytwo.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem01A {
    public static void main(String[] args){
        try {
            InputReader input = new InputReader(args[0]);
            List<String> elves = input.delimitOn("\\n\\s*\\n");
            List<Integer> calories = new ArrayList<>();

            for(String elf : elves){
                calories.add(Arrays.stream(elf.split("\n")).mapToInt(Integer::valueOf).sum());
            }

            int max = Collections.max(calories);

            System.out.printf("Found a maximum calorie count of %d", max);


        }
        catch(java.io.IOException e){
            System.err.printf("An error occurred while accessing the input file:\n%s", e);
            System.out.println("\n\nMake sure the file exists and that its name is correct.");
        }

    }
}
