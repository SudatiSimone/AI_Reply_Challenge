package it.reply.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeOut {
    public Map<Integer, List<Cell>> paths;

    public SnakeOut() {
        this.paths = new HashMap<>();
    }
}
