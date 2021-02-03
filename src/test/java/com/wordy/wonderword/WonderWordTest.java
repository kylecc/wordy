package com.wordy.wonderword;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class WonderWordTest {

    @Test
    public void testWonderWord1() {
        List<String> board = Arrays.asList(
                "SSKTCESNIREKCUS",
                "STTCCHARTERSRBW",
                "WMUNOTSMELTPOOH",
                "HSARIDUSCGOARTC",
                "IDELGONOANTMOSA",
                "TNELLEPERASBRLN",
                "EAENCMOYPTREELO",
                "FLEIRYONAURPTIE",
                "ITLTEKCUBWITAGC",
                "SESLGBAITCVSWRS",
                "HWLOUKLSKHERUNP",
                "NOMLASUEESRIIEE",
                "WSUNSCREENSFSKR",
                "DAEHLEETSEIAAIC",
                "CANALSDSRAGLBPH");
        List<String> words = Arrays.asList(
                "ANGLER", "BAIT", "BASS", "BOAT", "BUCKET", "BURBOT",
                "CANALS", "CANOE", "CARP", "CHARTER", "CORK", "CRUISER",
                "DOCK", "EELS", "FINS", "FIRST", "GARS", "GILLS", "INSECT",
                "LAKE", "LICENSE", "LINES", "LURED", "MAPS", "NETS", "PERCH",
                "PICKEREL", "PIKE", "REEL", "REPELLENT", "RIVERS", "SALMON", "SAUGER",
                "SHORE", "SMALLMOUTH", "SMELT", "STEELHEAD", "STURGEON", "SUCKER", "SUNSCREEN",
                "TROUT", "WATER", "WAYPOINTS", "WETLANDS", "WHITEFISH", "WORMS", "YELLOW");

        String solution = new WonderWord(board, words).solve();
        Assert.assertThat(solution, is("HOOKS"));
    }

    @Test
    public void testWonderWord2() {
        List<String> board = Arrays.asList(
                "PNJAMSNSEGASUAS",
                "HIONIONSSSPIESS",
                "CSNSMDWTLRARHIH",
                "ARIEIAUAESALSTE",
                "SELDANSSPACEAEL",
                "HPGRAPEFRUITUMV",
                "EPIEIRPVECHCQSI",
                "WEPNVCELLEECSSN",
                "SPRESAOSEBBLTIG",
                "CUREDRNGRAPESEO",
                "TAEMARAAROEEATK",
                "JUICEOBPABHKANE",
                "AUSWATERBSEMILS",
                "REGLESSURBOTTLE",
                "SEHSIDARUTABAGA");
        List<String> words = Arrays.asList(
                "AREA", "BARBECUE", "BARREL", "BEANS", "BEETS", "BOTTLE",
                "BRUSSEL", "CARROTS", "CASHEWS", "CURED", "ESCAROLE", "GRAPEFRUIT",
                "GRAPES", "HORSERADISH", "ITEMS", "JAMS", "JARS", "JUGS", "JUICE", "KETCHUP",
                "LEEK", "LEMON", "LIMES", "MEAT", "ONIONS", "PARSNIPS", "PEANUTS", "PEPPERS", "PIES",
                "PINEAPPLE", "PRESERVE", "RADISHES", "RUTABAGA", "SALAMI", "SALSA", "SAUCE", "SAUSAGES",
                "SHELVING", "SODA", "SPACE", "SQUASH", "TOMATO", "TURNIPS", "VENISON", "WATER");
        String solution = new WonderWord(board, words).solve();
        Assert.assertThat(solution, is("WINE"));
    }

}
