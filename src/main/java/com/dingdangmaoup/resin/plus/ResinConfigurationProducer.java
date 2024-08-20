package com.dingdangmaoup.resin.plus;

import com.intellij.javaee.appServers.run.configuration.J2EEConfigurationProducer;

public class ResinConfigurationProducer extends J2EEConfigurationProducer {
  public ResinConfigurationProducer() {
    super(ResinConfigurationType.getInstance());
  }
}
