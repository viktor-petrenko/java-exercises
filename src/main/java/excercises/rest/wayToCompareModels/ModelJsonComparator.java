package excercises.rest.wayToCompareModels;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ModelJsonComparator {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ComparisonResult compare(Model actualModel, Model expectedModel) {
        try {
            // Convert models to JSON nodes
            JsonNode actualNode = objectMapper.valueToTree(actualModel);
            JsonNode expectedNode = objectMapper.valueToTree(expectedModel);

            boolean isEquals = actualNode.equals(expectedNode);
            return new ComparisonResult(isEquals, getDifferences(actualNode, expectedNode));
        } catch (Exception e) {
            throw new RuntimeException("Error comparing models", e);
        }
    }

    private static String getDifferences(JsonNode actualNode, JsonNode expectedNode) {
        if (actualNode.equals(expectedNode)) {
            return "No differences found.";
        } else {
            StringBuilder differences = new StringBuilder();
            differences.append("Differences found: \n");
            differences.append("Actual: ").append(actualNode.toPrettyString()).append("\n");
            differences.append("Expected: ").append(expectedNode.toPrettyString()).append("\n");
            return differences.toString();
        }
    }

}