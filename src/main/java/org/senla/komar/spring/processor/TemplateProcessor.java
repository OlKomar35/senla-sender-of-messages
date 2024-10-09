package org.senla.komar.spring.processor;

import java.util.Map;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */

public interface TemplateProcessor {
  String getHtmlFromFtl(String fileNameTemplate, Map<String, Object> messageData);
}
