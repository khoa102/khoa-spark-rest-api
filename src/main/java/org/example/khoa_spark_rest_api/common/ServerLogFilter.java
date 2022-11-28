package org.example.khoa_spark_rest_api.common;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class ServerLogFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
//        if (event.getLoggerName().contains("com.j256.ormlite")) {
//            return FilterReply.DENY;
//        }
//        if (event.getLoggerName().contains("jdbc.JdbcConnectionSource")) {
//            return FilterReply.DENY;
//        }
//        if (event.getLoggerName().contains("jdbc.JdbcPooledConnectionSource")) {
//            return FilterReply.DENY;
//        }
//        if (event.getLoggerName().contains("org.eclipse.jetty")) {
//            return FilterReply.DENY;
//        }
//        if (event.getLoggerName().contains(".JettySparkServer") && event.getLevel().levelInt < Level.WARN_INT) {
//            return FilterReply.DENY;
//        }
//        if (event.getLoggerName().contains("com.jcabi.http")) {
//            return FilterReply.DENY;
//        }

        return FilterReply.NEUTRAL;
    }
}
