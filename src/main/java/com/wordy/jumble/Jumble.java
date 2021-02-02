package com.wordy.jumble;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Jumble {

    private final Set<String> dictionary;

    public Jumble() {
        dictionary = Collections.emptySet();
    }

    public Jumble(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> solve(String letters) {
        List<String> permutations = buildPermutations(letters);
        return permutations.stream().filter(dictionary::contains).collect(Collectors.toList());
    }

    protected List<String> buildPermutations(String letters) {
        boolean[] used = new boolean[letters.length()];
        List<String> results = new LinkedList<>();
        permute(letters, new StringBuilder(), used, results);
        return results.stream().distinct().collect(Collectors.toList());
    }

    private void permute(String letters, StringBuilder sb, boolean[] used, List<String> results) {
        if(sb.length() == letters.length()) {
            results.add(sb.toString());
            return;
        }
        for(int i = 0; i < letters.length(); ++i) {
            if(used[i]) continue;
            used[i] = true;
            sb.append(letters.charAt(i));
            permute(letters, sb, used, results);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void prettyPrint(String letters, List<String> matchesList) {
        if(matchesList.isEmpty()) {
            System.out.println("No matches found for letters: " + letters + "!");
        } else {
            String matches = String.join(", ", matchesList);
            System.out.println("Possible matches for letters: " + letters + ": " + matches);
        }
    }

    private static Set<String> loadDictionary() throws Exception {
        return Files.lines(Paths.get("words.txt"))
                .filter(word -> !word.contains("'"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) throws Exception {
        Set<String> dictionary = loadDictionary();
        Jumble jumble = new Jumble(dictionary);
        List<String> words = Arrays.asList("cleet", "droee", "utotle", "rullap", "cuthh", "tucol", "emnoyk", "bmflue");
        words.forEach(word -> prettyPrint(word, jumble.solve(word)));
    }

}
