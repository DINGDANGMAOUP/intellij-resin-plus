package com.dingdangmaoup.resin.plus.resin;

import com.intellij.execution.ExecutionException;
import com.intellij.javaee.appServers.appServerIntegrations.ApplicationServer;
import com.intellij.openapi.diagnostic.Logger;
import com.dingdangmaoup.resin.plus.ResinPersistentData;
import com.dingdangmaoup.resin.plus.resin.configuration.JmxConfigurationStrategy;
import com.dingdangmaoup.resin.plus.resin.configuration.ResinConfigurationStrategy;
import org.jetbrains.annotations.Nullable;

/**
 * @author michael.golubev
 */
public class ResinPersistentDataHelper {

  private static final Logger LOG = Logger.getInstance(ResinPersistentDataHelper.class);

  private final ApplicationServer myApplicationServer;

  public ResinPersistentDataHelper(ApplicationServer applicationServer) {
    myApplicationServer = applicationServer;
  }

  @Nullable
  public ResinPersistentData getPersistentData() {
    return myApplicationServer != null ? (ResinPersistentData)myApplicationServer.getPersistentData() : null;
  }

  @Nullable
  public ResinInstallation getInstallation() {
    try {
      return getInstallationOrError();
    }
    catch (ExecutionException e) {
      LOG.debug(e);
      return null;
    }
  }

  @Nullable
  public ResinInstallation getInstallationOrError() throws ExecutionException {
    ResinPersistentData persistentData = getPersistentData();
    return persistentData != null ? ResinInstallation.create(persistentData.RESIN_HOME) : null;
  }

  @Nullable
  ResinConfigurationStrategy getStrategy() {
    ResinInstallation installation = getInstallation();
    return installation == null ? null : ResinConfigurationStrategy.getForInstallation(installation);
  }

  @Nullable
  public JmxConfigurationStrategy getJmxStrategy() {
    ResinConfigurationStrategy strategy = getStrategy();
    return strategy instanceof JmxConfigurationStrategy ? (JmxConfigurationStrategy)strategy : null;
  }

  public boolean hasJmxStrategy() {
    return getJmxStrategy() != null;
  }
}
