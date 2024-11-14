package exercises.rest.wayToCompareModels;

import static org.assertj.core.api.Assertions.assertThat;

public class UserModelTest {
    public static void main(String[] args) {
        UserModel user1 = new UserModel(1L, "John Doe");
        UserModel user2 = new UserModel(1L, "John Doe");
        UserModel user3 = new UserModel(2L, "Jane Doe");

        System.out.println("user1 equals user2: " + user1.equals(user2)); // should be true
        System.out.println("user1 equals user3: " + user1.equals(user3)); // should be false

        // If you want to see the differences between user1 and user3
        ComparisonResult result = ModelJsonComparator.compare(user1, user3);
        System.out.println("Are user1 and user3 equal? " + result.isEquals());
        System.out.println("Differences:\n" + result.getDifferences());
    }

}
