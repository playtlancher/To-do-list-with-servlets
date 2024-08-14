package mappers;

import models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User mapToUser(ResultSet resultSet) throws SQLException {
        User user = null;

        while (resultSet.next()) {
            user = new User();
            user.setName(resultSet.getString(1));
            user.setEmail(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setId(resultSet.getInt(4));
        }
        return user;
    }
}
