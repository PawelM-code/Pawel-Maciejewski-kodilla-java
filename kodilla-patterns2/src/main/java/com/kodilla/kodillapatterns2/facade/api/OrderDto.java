package com.kodilla.kodillapatterns2.facade.api;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    List<ItemDto> itemDtos = new ArrayList<>();

    public void addItem(final ItemDto itemDto){
        itemDtos.add(itemDto);
    }

    public List<ItemDto> getItemDtos() {
        return itemDtos;
    }
}
