//package com.social;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.codec.ServerSentEvent;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//
//import com.social.services.LikeService;
//
//@RestController
//public class SSEController {
//
//    private final LikeService likeService; // Assumi che tu abbia un servizio per gestire i like delle ricette
//
//    @Autowired
//    public SSEController(LikeService likeService) {
//        this.likeService = likeService;
//    }
//
//    @GetMapping("/sse-like-updates")
//    public Flux<ServerSentEvent<Integer>> getLikeUpdates() {
//        return Flux.create(sink -> {
//            likeService.subscribeToLikeUpdates(update -> {
//                ServerSentEvent<Integer> event = ServerSentEvent.builder(update.getLikeCount())
//                        .event("like-update")
//                        .id(update.getRecipeId().toString())
//                        .build();
//                sink.next(event);
//            });
//            // Quando il sink non è più necessario, puoi chiuderlo per liberare le risorse
//            sink.onDispose(() -> {
//                // Eventuale codice per gestire la chiusura del sink
//            });
//        });
//    }
//}