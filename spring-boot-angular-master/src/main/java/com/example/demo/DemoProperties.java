package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("demo")
class DemoProperties {
  private String value;

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}
}
