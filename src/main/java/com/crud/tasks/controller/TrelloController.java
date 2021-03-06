package com.crud.tasks.controller;

import com.crud.tasks.client.TrelloClient;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin(origins = "*")
public class TrelloController {

    @Autowired
    private TrelloClient trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.getTrelloBoards();

        //List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        //trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

        //zad3
        //trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getId() != null)
        //.filter(trelloBoardDto -> trelloBoardDto.getName() != null)
        //.filter(trelloBoardDto -> trelloBoardDto.getName().contains("kodilla"))
        // .forEach(System.out::println);


        //trelloBoards.forEach(trelloBoardDto -> {

        // System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

        //  System.out.println("This board contains lists: ");

        // trelloBoardDto.getLists().forEach(trelloList ->
        //    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

        //  });
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createNewCard(trelloCardDto);
    }
}
