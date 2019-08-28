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
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
    public StringArrayTypeHandler() {
        super();
    }
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType)
            throws SQLException {

        Connection conn = ps.getConnection();
        Array array = conn.createArrayOf("varchar", parameter);
        ps.setArray(i, array);

    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return getArray(resultSet.getArray(s));
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return getArray(resultSet.getArray(i));
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return getArray(callableStatement.getArray(i));
    }

    private String[] getArray(Array array) {
        if (array == null) {
            return null;
        }
        try {
            return (String[]) array.getArray();
        } catch (Exception e) {
        }
        return null;
    }
}
