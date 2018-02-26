package cn.itcast.heima2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存系统模型
 * 
 * @author wangyt
 *
 */
public class L12_CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();

	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	/** 主要考虑取数据,通过key取数据 **/
	public Object getData(String key) {
		rwl.readLock().lock();
		Object value = null;
		try {
			value = cache.get(key);
			if (value == null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try {
					if (value == null) {
						// 实际失去queryDB();
						value = "查询数据库获取数据";
					}
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} finally {
			rwl.readLock().unlock();
		}
		return value;
	}
}
