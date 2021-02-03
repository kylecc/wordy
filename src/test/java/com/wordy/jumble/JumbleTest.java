package com.wordy.jumble;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

public class JumbleTest {

    @Test
    public void testJumble() throws Exception {
        Set<String> dictionary = Jumble.loadDictionary("words.txt");
        Jumble jumble = new Jumble(dictionary);
        Assert.assertTrue(jumble.solve("cleet").contains("elect"));
        Assert.assertTrue(jumble.solve("droee").contains("erode"));
        Assert.assertTrue(jumble.solve("utotle").contains("outlet"));
        Assert.assertTrue(jumble.solve("rullap").contains("plural"));
        Assert.assertTrue(jumble.solve("cuthh").contains("hutch"));
        Assert.assertTrue(jumble.solve("tucol").contains("clout"));
        Assert.assertTrue(jumble.solve("emnoyk").contains("monkey"));
        Assert.assertTrue(jumble.solve("bmflue").contains("fumble"));
        Assert.assertTrue(jumble.solve("sabhr").contains("brash"));
        Assert.assertTrue(jumble.solve("lofdo").contains("flood"));
        Assert.assertTrue(jumble.solve("swerhd").contains("shrewd"));
        Assert.assertTrue(jumble.solve("paneph").contains("happen"));
    }

    @Test
    public void testPermute() {
        String word = "abcd";
        List<String> permutations = Jumble.buildPermutations(word);
        Assert.assertThat(permutations.size(), is(24));
        List<String> expectedPermutations = Arrays.asList(
                "abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                "dabc", "dacb", "dbac", "dbca", "dcab", "dcba");
        expectedPermutations.forEach(permutation -> Assert.assertTrue(permutations.contains(permutation)));
    }

}
