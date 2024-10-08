package com.dingdangmaoup.resin.plus.ui;

import com.intellij.javaee.appServers.appServerIntegrations.ApplicationServer;
import com.intellij.javaee.appServers.run.configuration.ApplicationServerSelectionListener;
import com.intellij.javaee.appServers.run.configuration.CommonModel;
import com.intellij.openapi.options.SettingsEditor;
import com.dingdangmaoup.resin.plus.ResinModelBase;
import com.dingdangmaoup.resin.plus.resin.ResinPersistentDataHelper;
import org.jetbrains.annotations.Nullable;

/**
 * @author michael.golubev
 */
public abstract class ResinRunConfigurationEditorBase extends SettingsEditor<CommonModel> implements ApplicationServerSelectionListener {

  @Override
  public void serverSelected(@Nullable ApplicationServer server) {
    serverChanged(server);
  }

  @Override
  public void serverProbablyEdited(@Nullable ApplicationServer server) {
    serverChanged(server);
  }

  private void serverChanged(@Nullable ApplicationServer server) {
    setJmxPortVisible(new ResinPersistentDataHelper(server).hasJmxStrategy());
  }

  protected final void updateJmxPortVisible(ResinModelBase model) {
    setJmxPortVisible(model.hasJmxStrategy());
  }

  protected abstract void setJmxPortVisible(boolean visible);
}
