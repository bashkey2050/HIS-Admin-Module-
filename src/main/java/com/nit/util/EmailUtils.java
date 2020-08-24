package com.nit.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.nit.model.AccountRequest;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender MailSender;
	
	
	
	public boolean sendUserAccUnlockEmail(AccountRequest req) {
		boolean isSent = false;
		try {

			MimeMessage mimeMsg = MailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);

			helper.setTo(req.getEmail());
			helper.setSubject("Unlock Your Account");
			helper.setText(getUnlockAccEmailBody(req),true);
			
			
			MailSender.send(mimeMsg);

			isSent = true;
		} catch (Exception e) {
                 e.printStackTrace();
		}
		return isSent;
	}
	
	private String getUnlockAccEmailBody(AccountRequest req) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}
		
		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", req.getFirstName());
		mailBody = mailBody.replace("{LNAME}", req.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", req.getUserPwd());
		mailBody = mailBody.replace("{EMAIL}", req.getEmail());

		return mailBody;
	}

}
