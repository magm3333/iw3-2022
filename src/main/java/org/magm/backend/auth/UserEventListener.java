package org.magm.backend.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserEventListener implements ApplicationListener<UserEvent>{

	@Override
	public void onApplicationEvent(UserEvent event) {
		if(event.getTypeEvent().equals(UserEvent.TypeEvent.LOGIN)) {
			handleLogin(event);
		}
		if(event.getTypeEvent().equals(UserEvent.TypeEvent.SEND_EMAIL_WITH_PASSWORD_RESTORED)) {
			handleSendMailWithPasswordrestored(event);
		}
		if(event.getTypeEvent().equals(UserEvent.TypeEvent.SEND_EMAIL_WITH_USERNAME)) {
			handleSendMailWithUserName(event);
		}
		
	}
	
	private void handleLogin(UserEvent event) {
		User user=(User) event.getSource();
		HttpServletRequest request=(HttpServletRequest) event.getExtraData();
		log.debug("Evento LOGIN user: '{}', host={}",user.getUsername(), request.getRemoteHost());
	}
	
	private void handleSendMailWithPasswordrestored(UserEvent event) {
		User user=(User) event.getSource();
		log.debug("Evento SEND_EMAIL_WITH_PASSWORD_RESTORED user: '{}', host={}",user.getUsername());
	}
	
	private void handleSendMailWithUserName(UserEvent event) {
		User user=(User) event.getSource();
		log.debug("Evento SEND_EMAIL_WITH_USERNAME user: '{}', host={}",user.getUsername());
	}


}
