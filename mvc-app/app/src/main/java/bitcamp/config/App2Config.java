package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
    value="bitcamp.app2",
    excludeFilters = @Filter(type= FilterType.REGEX, pattern = "bitcamp.web.app1.*")
)
public class App2Config {

}
