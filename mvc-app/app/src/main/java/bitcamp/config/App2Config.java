package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@EnableWebMvc
@ComponentScan(
    value = "bitcamp.app2",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "bitcamp.web.app1.*")
)
public class App2Config implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver vr = new InternalResourceViewResolver(
        "/WEB-INF/jsp2/",
        ".jsp"
    );
    return vr;
  }

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
    UrlPathHelper urlPathHelper = new UrlPathHelper();
    //url 안에 들어간 세미콜론을 제거하지 말라는 규칙을 urlPathHelper에 추가
    urlPathHelper.setRemoveSemicolonContent(false);
    //그 규칙을 가진 urlPathHelper를 configurer에 등록
    configurer.setUrlPathHelper(urlPathHelper);
  }
}
