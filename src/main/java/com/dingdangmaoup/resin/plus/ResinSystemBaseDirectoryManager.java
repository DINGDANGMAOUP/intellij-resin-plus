package com.dingdangmaoup.resin.plus;

import com.intellij.javaee.directoryManager.JavaeeSystemBaseDirectoryManagerProvider;
import com.intellij.javaee.directoryManager.SystemBaseDirectoryManager;
import org.jetbrains.annotations.NotNull;

public final class ResinSystemBaseDirectoryManager {
  @NotNull
  public static SystemBaseDirectoryManager getInstance() {
    return JavaeeSystemBaseDirectoryManagerProvider.getManagerInstance("resin");
  }
}
