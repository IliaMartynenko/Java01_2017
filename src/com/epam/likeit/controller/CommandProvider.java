package com.epam.likeit.controller;

import com.epam.likeit.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mts7072572 on 13.07.2017.
 */

  public final class CommandProvider {
        private final Map<CommandEnum, Command> repository = new HashMap<>();
        CommandProvider(){
            repository.put(CommandEnum.ADD_QUESTION, new AddQuestionCommand());
            repository.put(CommandEnum.BAN_USER, new BanUserCommand());
            repository.put(CommandEnum.DELETE_USER, new DeleteUserCommand());
            repository.put(CommandEnum.DELETE_QUESTION, new DeleteQuestionCommand());
            repository.put(CommandEnum.ADD_REVIEW, new AddReviewCommand());
            repository.put(CommandEnum.ADD_ANSWER, new AddAnswerCommand());
            repository.put(CommandEnum.DELETE_REVIEW, new DeleteReviewCommand());
            repository.put(CommandEnum.GET_ALL_REVIEWS, new GetAllReviewsCommand());
            repository.put(CommandEnum.GET_ALL_QUESTIONS, new GetAllQuestionsCommand());

        }
            Command getCommand(String name){
            CommandEnum commandName =null;
            Command command = null;
            try{
                commandName = CommandEnum.valueOf(name.toUpperCase());
                command = repository.get(commandName);
            }catch(IllegalArgumentException e){
                e.printStackTrace();

            }
            return command;
        }
    }


