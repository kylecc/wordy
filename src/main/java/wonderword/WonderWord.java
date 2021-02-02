package wonderword;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class WonderWord {

    private final List<String> board;
    private final char[][] grid;
    private final List<String> words;
    private final int[][] directions = new int[][] {
            { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 },
            { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }
    };

    public WonderWord(List<String> board, List<String> words) {
        this.board = board;
        grid = buildGrid();
        this.words = words;
    }

    public String solve() {
        List<Stack<int[]>> startEndCoordinates = words.stream().map(this::find).collect(Collectors.toList());
        crossOutFoundWords(startEndCoordinates);
        return combineRemainingLetters();
    }

    private Stack<int[]> find(String word) {
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                char firstLetter = word.charAt(0);
                if(grid[i][j] != firstLetter) continue;
                Stack<int[]> coordinates = new Stack<>();
                boolean found = find(word, i, j, 0, -1, coordinates);
                if(found) return coordinates;
            }
        }
        throw new RuntimeException("Word not found in puzzle: \"" + word + "\"!");
    }

    private boolean find(String word, int row, int col, int index, int direction, Stack<int[]> coordinates) {
        if(!isValidCoordinates(row, col)) return false;
        if(grid[row][col] != word.charAt(index)) return false;
        coordinates.push(new int[] { row, col });
        if(index >= word.length() - 1) return true;
        char c = grid[row][col];
        grid[row][col] = '!';
        boolean found = false;
        for(int d = 0; d < directions.length; ++d) {
            int newRow = row + directions[d][0];
            int newCol = col + directions[d][1];
            if(direction == -1 || d == direction) {
                found = find(word, newRow, newCol, index + 1, d, coordinates);
                if(found) break;
            }
        }
        grid[row][col] = c;
        if(!found) coordinates.pop();
        return found;
    }

    private boolean isValidCoordinates(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }

    private void crossOutFoundWords(List<Stack<int[]>> startEndCoordinatesList) {
        for(Stack<int[]> startEndCoordinates : startEndCoordinatesList) {
            while(!startEndCoordinates.isEmpty()) {
                int[] coordinate = startEndCoordinates.pop();
                grid[coordinate[0]][coordinate[1]] = '!';
            }
        }
    }

    private String combineRemainingLetters() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) {
            for (int i = 0; i < row.length; ++i) {
                if (row[i] != '!') sb.append(row[i]);
            }
        }
        return sb.toString();
    }

    private char[][] buildGrid() {
        char[][] grid = new char[board.size()][];
        for(int i = 0; i < grid.length; ++i) {
            grid[i] = new char[board.get(i).length()];
            for(int j = 0; j < grid[i].length; ++j) {
                grid[i][j] = board.get(i).charAt(j);
            }
        }
        return grid;
    }

    private final static List<String> BOARD = Arrays.asList(
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
            "CANALSDSRAGLBPH"
    );

    private final static List<String> WORDS = Arrays.asList(
            "ANGLER", "BAIT", "BASS", "BOAT", "BUCKET", "BURBOT",
            "CANALS", "CANOE", "CARP", "CHARTER", "CORK", "CRUISER",
            "DOCK", "EELS", "FINS", "FIRST", "GARS", "GILLS", "INSECT",
            "LAKE", "LICENSE", "LINES", "LURED", "MAPS", "NETS", "PERCH",
            "PICKEREL", "PIKE", "REEL", "REPELLENT", "RIVERS", "SALMON", "SAUGER",
            "SHORE", "SMALLMOUTH", "SMELT", "STEELHEAD", "STURGEON", "SUCKER", "SUNSCREEN",
            "TROUT", "WATER", "WAYPOINTS", "WETLANDS", "WHITEFISH", "WORMS", "YELLOW"
    );

    public static void main(String[] args) {
        String solution = new WonderWord(BOARD, WORDS).solve();
        System.out.println("Solution: " + solution);
    }
}
