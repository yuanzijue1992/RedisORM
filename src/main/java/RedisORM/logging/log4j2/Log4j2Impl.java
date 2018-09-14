
package RedisORM.logging.log4j2;

import RedisORM.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.AbstractLogger;

/**
 * log4j2的实现
 */
public class Log4j2Impl implements Log {

  private final Log log;

  public Log4j2Impl(String clazz) {
    Logger logger = LogManager.getLogger(clazz);
    // 根据这部分可以推测出获得的logger可能存在两种情况，对于两种情况分别使用不同的适配器。
    if (logger instanceof AbstractLogger) {
      // Log4j2AbstractLoggerImpl适配器
      log = new Log4j2AbstractLoggerImpl((AbstractLogger) logger);
    } else {
      // Log4j2LoggerImpl适配器
      log = new Log4j2LoggerImpl(logger);
    }
  }

  @Override
  public boolean isDebugEnabled() {
    return log.isDebugEnabled();
  }

  @Override
  public boolean isTraceEnabled() {
    return log.isTraceEnabled();
  }

  @Override
  public void error(String s, Throwable e) {
    log.error(s, e);
  }

  @Override
  public void error(String s) {
    log.error(s);
  }

  @Override
  public void debug(String s) {
    log.debug(s);
  }

  @Override
  public void trace(String s) {
    log.trace(s);
  }

  @Override
  public void warn(String s) {
    log.warn(s);
  }

}
