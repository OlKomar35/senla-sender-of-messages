package org.senla.komar.spring.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.servlet.FilterRegistration;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;
import org.senla.komar.spring.service.ChangingTemplateToPageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @author Olga Komar
 * <p>
 * Created at 20.08.2024
 */
@Service
public class ChangingTemplateToPageServiceImpl implements ChangingTemplateToPageService {

  @Value("${template.path}")
  private String pathTemplateDir;

  public String getHtmlFromFtl(String fileNameTemplate, Map<String, Object> messageData) {

    try {
      String projectRootPath = System.getProperty("user.dir");
      String separator = System.getProperty("file.separator");

      Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

      Path path = Paths.get(projectRootPath + separator + pathTemplateDir );

      configuration.setDirectoryForTemplateLoading(path.toFile());
      configuration.setDefaultEncoding("UTF-8");

      StringWriter stringWriter = new StringWriter();
      Template template = configuration.getTemplate(fileNameTemplate);
      template.process(messageData, stringWriter);
      return stringWriter.toString();
    } catch (IOException | TemplateException e) {
      throw new RuntimeException(e);
    }

  }

}
