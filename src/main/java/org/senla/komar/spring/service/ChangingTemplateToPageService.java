package org.senla.komar.spring.service;

import freemarker.template.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */

public interface ChangingTemplateToPageService {
  String getHtmlFromFtl(String fileNameTemplate, Map<String, Object> messageData);
}
