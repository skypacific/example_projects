package com.joongang.sbtest02.controller;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EwsController {

    @GetMapping("/ews/user/inbox")
    public String ewsUser() {
        StringBuilder resBody = new StringBuilder();
        resBody.append("[EWS-Inbox]<br/>");

        // TODO Exchange에 접속한다.
        
        String useremail = "yourname@yourdomain.com";  // 여기에 실제 사용자 이메일주소를 넣는다.
        String password = "*****"; // 여기에 실제 사용자 암호를 넣는다.
        try {
            ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2007_SP1);
            ExchangeCredentials credentials = new WebCredentials(useremail, password);
            service.setCredentials(credentials);
            service.autodiscoverUrl(useremail);
            
            // TODO 받은편지함을 읽는다

            Folder inbox = Folder.bind(service, WellKnownFolderName.Inbox);
            ItemView view = new ItemView(10);
            FindItemsResults<Item> findResults = service.findItems(inbox.getId(), view);
            for (Item item : findResults.getItems()) {
                resBody.append(item.getSubject());
                resBody.append("<br/>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resBody.toString();
    }
}