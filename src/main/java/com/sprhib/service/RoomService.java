package com.sprhib.service;

import com.sprhib.model.Day;
import com.sprhib.model.Room;

import java.util.List;

/**
 * Created by &#x41d;&#x430;&#x437;&#x430;&#x440; on 10.06.2015.
 */
public interface RoomService {
    public void add(Room room);
    public void update(Room room);
    public Room get(int id);
    public void delete(int id);
    public List<Room> getAll();

}
