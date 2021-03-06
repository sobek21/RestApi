package com.crud.tasks.service;

import com.crud.tasks.client.TrelloClient;
import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrelloService {

    private static final String SUBJECT = "Tasks : New Trello Card";

    @Autowired
    private TrelloClient trelloClient;

    @Autowired
    private SimpleEmailService emailService;

    @Autowired
    private AdminConfig adminConfig;

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();

    }
    public CreatedTrelloCard createdTrelloCard(final TrelloCardDto trelloCardDto) {

        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);

       Optional.ofNullable(newCard).ifPresent(card -> emailService.send(
               new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "New card:" + trelloCardDto.getName() + "has been create on your trello account"
               ,"")));

        return newCard;
    }
}
