package com.wordy.jumble;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Jumble {

    private final Set<String> dictionary;

    public Jumble(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> solve(String letters) {
        List<String> permutations = buildPermutations(letters);
        return permutations.stream().filter(dictionary::contains).collect(Collectors.toList());
    }

    protected static List<String> buildPermutations(String letters) {
        boolean[] used = new boolean[letters.length()];
        List<String> results = new LinkedList<>();
        permute(letters, new StringBuilder(), used, results);
        return results.stream().distinct().collect(Collectors.toList());
    }

    private static void permute(String letters, StringBuilder sb, boolean[] used, List<String> results) {
        if(sb.length() == letters.length()) results.add(sb.toString());
        else {
            for(int i = 0; i < letters.length(); ++i) {
                if(used[i]) continue;
                used[i] = true;
                sb.append(letters.charAt(i));
                permute(letters, sb, used, results);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static Set<String> loadDictionary(String fileName) throws Exception {
        return Files.lines(Paths.get(fileName))
                .filter(word -> !word.contains("'"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

}
