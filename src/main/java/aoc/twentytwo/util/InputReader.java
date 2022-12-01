package aoc.twentytwo.util;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

public class InputReader {
    private final Path path;

    public InputReader(String filename){
        // obtain a handle on the file and store its path
        path = new File(filename).toPath();
    }
    // pass through the underlying stream of this class
    public Stream<String> stream() throws java.io.IOException{
        return Files.lines(path);
    }
    public List<String> asList() throws java.io.IOException{
        return this.stream().collect(Collectors.toList());
    }
    // tokenize the file and return a list of the tokens
    public List<String> tokenize(String regex) throws java.io.IOException{
        List<String> result = new ArrayList<>();

        String file = this.stream().collect(Collectors.joining());
        Pattern tokenizer = Pattern.compile(regex);
        Matcher matcher = tokenizer.matcher(file);

        while(matcher.find()){
            result.add(matcher.group());
        }

        return result;

    }
    // delimit the file around a token other than newlines.
    public List<String> delimitOn(String token) throws java.io.IOException{
        Pattern regex = Pattern.compile(token);
        String file = this.stream().collect(Collectors.joining());

        return List.of(regex.split(file));

    }

}
