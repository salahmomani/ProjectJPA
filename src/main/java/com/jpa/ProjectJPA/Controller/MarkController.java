package com.jpa.ProjectJPA.Controller;

import com.jpa.ProjectJPA.DTO.MarkRequestDTO;
import com.jpa.ProjectJPA.DTO.MarkResponseDTO;
import com.jpa.ProjectJPA.Mapper.MarkMapper;
import com.jpa.ProjectJPA.Model.Mark;
import com.jpa.ProjectJPA.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {
    private final MarkService markService;
    private final MarkMapper markMapper;

    @Autowired
    public MarkController(MarkService markService, MarkMapper markMapper) {
        this.markService = markService;
        this.markMapper = markMapper;
    }


    @PostMapping("/add")
    public void add(@RequestBody MarkRequestDTO dto) {
        Mark saved = markService.addMark(dto);
         markMapper.toDTO(saved);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        markService.delete(id);
    }

    @GetMapping("/all")
    public List<MarkResponseDTO> findAll() {
        return markService.findAll().stream().map(markMapper::toDTO).toList();
    }
}
