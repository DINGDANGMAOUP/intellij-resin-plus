package com.dingdangmaoup.resin.plus.resin.configuration;

import com.intellij.javaee.appServers.deployment.DeploymentStatus;
import com.intellij.openapi.util.Ref;
import com.dingdangmaoup.resin.plus.ResinModelBase;
import com.dingdangmaoup.resin.plus.resin.WebApp;
import org.jetbrains.annotations.NotNull;

public interface JmxConfigurationStrategy {

  boolean deployWithJmx(ResinModelBase resinModel, WebApp webApp);

  boolean undeployWithJmx(ResinModelBase resinModel, WebApp webApp);

  @NotNull
  DeploymentStatus getDeployStateWithJmx(ResinModelBase resinModel, WebApp webApp, Ref<Boolean> isFinal);
}
