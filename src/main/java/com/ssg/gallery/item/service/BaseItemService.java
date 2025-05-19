package com.ssg.gallery.item.service;

import com.ssg.gallery.item.dto.ItemRead;
import com.ssg.gallery.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BaseItemService implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    public List<ItemRead> findAll() {
        return List.of();
    }

    @Override
    public List<ItemRead> findAll(List<Integer> ids) {
        return List.of();
    }
}
