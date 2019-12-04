package com.ishani.isanjaalwebservice.database.Mapper;

import org.skife.jdbi.v2.BuiltInArgumentFactory;
import org.skife.jdbi.v2.ResultSetMapperFactory;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class BeanMapperSnakeCaseFactory implements ResultSetMapperFactory {

    @SuppressWarnings("rawtypes")
	@Override
    public boolean accepts(Class type, StatementContext ctx) {
        return !BuiltInArgumentFactory.canAccept(type);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public ResultSetMapper mapperFor(Class type, StatementContext ctx) {
        return new BeanMapperSnakeCase(type);
    }
}
