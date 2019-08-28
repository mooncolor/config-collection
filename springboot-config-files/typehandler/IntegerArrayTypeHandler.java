package cn.com.tcsec.saas.astp.core.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.*;

/**
 * 处理数组
 *
 * @author: xiongk@tcsec.com.cn
 * @create: 2018-04-28 15:02
 */
@MappedJdbcTypes(value = JdbcType.ARRAY, includeNullJdbcType = true)
public class IntegerArrayTypeHandler extends BaseTypeHandler<Integer[]> {

    private static final String TYPE_NAME_VARCHAR = "varchar";
    private static final String TYPE_NAME_INTEGER = "integer";
    private static final String TYPE_NAME_BOOLEAN = "boolean";
    private static final String TYPE_NAME_NUMERIC = "numeric";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer[] parameter, JdbcType jdbcType)
            throws SQLException {

//        if (parameter instanceof Integer[]) {
//            typeName = TYPE_NAME_INTEGER;
//        } else if (parameter instanceof String[]) {
//            typeName = TYPE_NAME_VARCHAR;
//        } else if (parameter instanceof Boolean[]) {
//            typeName = TYPE_NAME_BOOLEAN;
//        } else if (parameter instanceof Double[]) {
//            typeName = TYPE_NAME_NUMERIC;

        Connection conn = ps.getConnection();
        Array array = conn.createArrayOf("integer", parameter);
        ps.setArray(i, array);

    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getArray(resultSet.getArray(s));
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getArray(resultSet.getArray(i));
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getArray(callableStatement.getArray(i));
    }

    private Integer[] getArray(Array array) {
        if (array == null) {
            return null;
        }
        try {
            return (Integer[]) array.getArray();
        } catch (Exception e) {
        }
        return null;
    }
}
