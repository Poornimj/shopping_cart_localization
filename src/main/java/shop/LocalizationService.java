package shop;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LocalizationService {

    public static Map<String, String> getStrings(String language) {
        Map<String, String> map = new HashMap<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT `key`, value FROM localization_strings WHERE language=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, language);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                map.put(rs.getString("key"), rs.getString("value"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}