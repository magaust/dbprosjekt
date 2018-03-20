package database;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class NamedParameterStatement {
    private PreparedStatement statement;
    private Map<String, Integer> parameterIndexMap;

    public NamedParameterStatement(String statement, Connection conn) throws SQLException {
        parameterIndexMap = new HashMap<>();
        StringBuilder preparedStatement = new StringBuilder();
        int i0 = 0, i1 = -1;
        int paramNumber = 1;
        while ((i0 = statement.indexOf(':', i1 + 1)) > 0) {
            preparedStatement.append(statement.subSequence(i1 + 1, i0));
            preparedStatement.append('?');
            i1 = statement.indexOf(':', i0 + 1);
            String parameter = statement.substring(i0 + 1, i1);
            parameterIndexMap.put(parameter, paramNumber++);
        }

        preparedStatement.append(statement.subSequence(i1 + 1, statement.length()));

        this.statement = conn.prepareStatement(preparedStatement.toString());
    }

    public void setInt(String parameter, int value) throws SQLException {
        statement.setInt(parameterIndexMap.get(parameter), value);
    }

    public void setDouble(String parameter, double value) throws SQLException {
        statement.setDouble(parameterIndexMap.get(parameter), value);
    }

    public void setString(String parameter, String value) throws SQLException {
        statement.setString(parameterIndexMap.get(parameter), value);
    }

    public void setDate(String parameter, Date value) throws SQLException {
        statement.setDate(parameterIndexMap.get(parameter), value);
    }

    public PreparedStatement getStatement() {
        return statement;
    }
}

