package org.senla.komar.spring.processor.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.senla.komar.spring.exception.TemplateFillException;
import org.senla.komar.spring.processor.TemplateProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */
@Service
@RequiredArgsConstructor
public class TemplateProcessorImpl implements TemplateProcessor {

  private final Configuration freemarkerConfig;

  public String getHtmlFromFtl(String fileNameTemplate, Map<String, Object> messageData) {
    try {
      Template template = freemarkerConfig.getTemplate(fileNameTemplate);
      return FreeMarkerTemplateUtils.processTemplateIntoString(template, messageData);
    } catch (IOException | TemplateException e) {
      throw new TemplateFillException("Exception occurred when filling out the template");
    }
  }
}
