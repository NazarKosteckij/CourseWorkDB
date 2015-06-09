package com.sprhib.service;

import com.sprhib.dao.DAO;
import com.sprhib.model.Room;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Назар on 10.06.2015.
 */
public class RoomServiceImpl implements RoomService {

    @Autowired
    DAO dao;

    public void add(Room room) {
        dao.add(room);
    }

    public void update(Room room) {
        dao.update(room);
    }

    public Room get(int id) {

        return (Room) dao.get(id,Room.class);
    }

    public void delete(int id) {
        dao.delete(id, Room.class);
    }
    @SuppressWarnings("rawtypes")
    public List<Room> getAll() {
        Iterator<Object> iterator = dao.getAll(Room.class).iterator();
        List<Room> rooms = new ArrayList<>();
        while (iterator.hasNext()){
            rooms.add((Room) iterator.next());
        }
        return rooms;
    }
}
