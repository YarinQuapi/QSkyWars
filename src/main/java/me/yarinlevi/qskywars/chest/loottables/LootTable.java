package me.yarinlevi.qskywars.chest.loottables;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YarinQuapi
 **/
public class LootTable {
    @Getter private Map<LootTableItem, Integer> lootTableItems = new HashMap<>();
}
