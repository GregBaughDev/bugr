package config;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.dialect.PostgreSQL10Dialect;

import java.sql.Types;

public class PostgresSQL10ArrayDialect extends PostgreSQL10Dialect {
    public PostgresSQL10ArrayDialect() {
        super();
        this.registerHibernateType(Types.ARRAY, IntArrayType.class.getName());
    }
}
