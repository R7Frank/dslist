package com.r7frank.dslist.services;

import com.r7frank.dslist.dto.GameDTO;
import com.r7frank.dslist.dto.GameMinDTO;
import com.r7frank.dslist.entities.Game;
import com.r7frank.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    public List<GameMinDTO> findAll() {
         List<Game> result = gameRepository.findAll();
         List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
         return dto;
    }
}
