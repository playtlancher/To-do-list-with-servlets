package mappers;

import Classes.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
