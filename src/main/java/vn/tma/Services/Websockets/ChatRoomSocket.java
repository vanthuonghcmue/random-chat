package vn.tma.Services.Websockets;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat_room/{roomId}/{username}")
@ApplicationScoped
public class ChatRoomSocket {
    @Inject
    Logger log;
    Map<String, List<Session>> sessions = new ConcurrentHashMap();

    public ChatRoomSocket() {}

    @OnOpen
    public void onOpen(Session session, @PathParam("roomId") String roomId, @PathParam("username") String username) {
        List<Session> roomSessions = (List)this.sessions.get(roomId);
        if (roomSessions == null) {
            roomSessions = new ArrayList();
            this.sessions.put(roomId, roomSessions);
        }

        ((List)roomSessions).add(session);
        log.info("Session " + session.getId() + " joined room " + roomId);
    }

    @OnClose
    public void onClose(Session session, @PathParam("roomId") String roomId, @PathParam("username") String username) {
        List<Session> roomSessions = (List)this.sessions.get(roomId);
        roomSessions.remove(session);
        this.broadcast(roomId, "User " + username + " left");
        log.info("User " + username + " left");
    }

    @OnError
    public void onError(Session session, @PathParam("roomId") String roomId, @PathParam("username") String username, Throwable throwable) {
        List<Session> roomSessions = (List)this.sessions.get(roomId);
        roomSessions.remove(session);
        this.broadcast(roomId, "User " + username + " left");
    }

    @OnMessage
    public void onMessage(String message, @PathParam("roomId") String roomId, @PathParam("username") String username) {
        log.info(username);

        if (message.equalsIgnoreCase("_ready_")) {
            this.broadcast(roomId, "User " + username + " joined");
            log.info("Unable to send message: " + username);

        } else {
            this.broadcast(roomId, ">> " + username + ": " + message);
            log.info("Unable to send message: " + username + ": " + message);

        }
    }

    private void broadcast(String roomId, String message) {
        List<Session> roomSessions = (List)this.sessions.get(roomId);
        if (roomSessions != null) {
            Iterator var5 = roomSessions.iterator();

            while(var5.hasNext()) {
                Session session = (Session)var5.next();
                session.getAsyncRemote().sendObject(message, (result) -> {
                    if (result.getException() != null) {
                        log.info("Unable to send message: " + result.getException());
                    }

                });
            }
        } else {
            log.error("Error: no sessions found for room " + roomId);
        }

    }
}
