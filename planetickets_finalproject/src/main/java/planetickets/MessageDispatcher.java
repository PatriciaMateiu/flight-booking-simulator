package planetickets;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

@Component
public class MessageDispatcher {
	private final SimpMessagingTemplate template;

	public MessageDispatcher(SimpMessagingTemplate template) {
		this.template = template;
	}

	public void sendToClient(String message) {
		this.template.convertAndSend("/queue/flight", message);
	}
	
	/*@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String greeting(String message) throws Exception{
		Thread.sleep(1000);
		return new String("Hello, " +  HtmlUtils.htmlEscape(message) + "!");
	}*/

}
