package com.wordy.jumble;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class JumbleTest {

    private final Jumble jumble = new Jumble();

    @Test
    public void testJumble() {
        String word = "abcd";
        List<String> permutations = jumble.buildPermutations(word);
        Assert.assertThat(permutations.size(), is(24));
        List<String> expectedPermutations = Arrays.asList(
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                "dabc", "dacb", "dbac", "dbca", "dcab", "dcba");
        expectedPermutations.forEach(permutation -> Assert.assertTrue(permutations.contains(permutation)));
    }

}
