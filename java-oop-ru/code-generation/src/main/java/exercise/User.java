package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
@Value
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
