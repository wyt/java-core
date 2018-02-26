/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.wangyt.javase.nio.watch;

import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 文件监听服务.
 * 
 * @author WANG YONG TAO
 *
 */
public class WatchServiceTest {

  public static void main(String[] args) throws Exception {

    System.out.println("startup file listen...");

    // 获取文件系统的WatchService对象
    WatchService watchService = FileSystems.getDefault().newWatchService();

    // 为C:盘根路径注册监听
    WatchKey key01 = Paths.get("F:/wangyt/backup").register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
        StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);
    
    System.out.println("key01: " + key01);

    while (true) {
      // 获取下一个文件改动事件
      WatchKey key = watchService.take(); // ①
      System.out.println("key: " + key);
      for (WatchEvent<?> event : key.pollEvents()) {
        System.out.println(event.context() + " 文件发生了 " + event.kind() + "事件！");
      }
      // 重设WatchKey
      boolean valid = key.reset();
      // 如果重设失败，退出监听
      if (!valid) {
        break;
      }
    }
  }
}
