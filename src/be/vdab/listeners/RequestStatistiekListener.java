package be.vdab.listeners;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestStatistiekListener implements ServletContextListener, ServletRequestListener {
    private static final String STATISTIEK = "statistiek";
    private final static Set<String> UITGESLOTEN_EXTENSIES = new CopyOnWriteArraySet<>(Arrays.asList("png","gif","jpg","css","js","ico"));

    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void requestInitialized(ServletRequestEvent event) {
        /*if (event.getServletRequest() instanceof HttpServletRequest) {
          HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
          // get URI
          String url = request.getRequestURI();
          // Check of uitgesloten is
          boolean verwerkRequest = true;
          int laatstePuntIndex = url.lastIndexOf('.');
          if (laatstePuntIndex != -1) {
            String extensie = url.substring(laatstePuntIndex + 1).toLowerCase();
            if (UITGESLOTEN_EXTENSIES.contains(extensie)) {
              verwerkRequest = false;
            }
          }
          // check of URL mapping is
          if (verwerkRequest) {
            int index = url.indexOf(";jsessionid=");
            if (index != -1) {
              url = url.substring(0, index);
            }
            // put URI in map samen met count
            @SuppressWarnings("unchecked")
            ConcurrentHashMap<String, AtomicInteger> statistiek = (ConcurrentHashMap<String, AtomicInteger>) request.getServletContext().getAttribute(STATISTIEK);
            AtomicInteger aantalReedsAanwezig = statistiek.putIfAbsent(url, new AtomicInteger(1));
            if (aantalReedsAanwezig != null) {
              aantalReedsAanwezig.incrementAndGet();
            }
          }
        }*/
      } 

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
       // event.getServletContext().setAttribute(STATISTIEK,new ConcurrentHashMap<String, AtomicInteger>());
      }
	
}
