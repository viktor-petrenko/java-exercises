package excercises.other.wayToCompareModels;

public class ComparisonResult {
    private final boolean isEquals;
    private final String differences;

    public ComparisonResult(boolean isEquals, String differences) {
        this.isEquals = isEquals;
        this.differences = differences;
    }

    public boolean isEquals() {
        return isEquals;
    }

    public String getDifferences() {
        return differences;
    }
}