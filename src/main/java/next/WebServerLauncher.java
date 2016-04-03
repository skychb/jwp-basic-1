package next;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServerLauncher {
	
	private static final Logger logger = LoggerFactory.getLogger(WebServerLauncher.class);

	
	public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
       
        logger.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());
        //if(logger.isInfoEnabled) - 문자 연산하는 부분ㅇ ㅣ많아져
        // 위같이 하면 문자열의 합이 일어나지 않고 메소드가 그냥 전달이 된다. 위의 조건을 알아서 체크해준다는 얘
        // 인자가 여러개면 {} 추가하믄되 
        tomcat.start();
        tomcat.getServer().await();
    }
}
