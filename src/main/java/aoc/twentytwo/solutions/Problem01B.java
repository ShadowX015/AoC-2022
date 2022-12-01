package aoc.twentytwo.solutions;

import aoc.twentytwo.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Problem01B {
    public static void main(String[] args){
        try {
            InputReader input = new InputReader(args[0]);
            List<String> elves = input.delimitOn("\\n\\s*\\n");
            List<Integer> calories = new ArrayList<>();

            for(String elf : elves){
                calories.add(Arrays.stream(elf.split("\\s+")).mapToInt(Integer::valueOf).sum());
            }

            // sort the list into ascending order and then reverse it to obtain a list in descending order
            Collections.sort(calories);
            Collections.reverse(calories);

            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += calories.get(i);
            }

            System.out.printf("The sum of the calories carried by the top 3 elves is %d", sum);


        }
        catch(java.io.IOException e){
            System.err.printf("An error occurred while accessing the input file:\n%s", e);
            System.out.println("\n\nMake sure the file exists and that its name is correct.");
        }

    }
}
