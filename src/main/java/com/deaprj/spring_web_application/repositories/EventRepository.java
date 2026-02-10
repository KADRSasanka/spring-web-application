package com.deaprj.spring_web_application.repositories;

import com.deaprj.spring_web_application.models.EventStatus;
import com.deaprj.spring_web_application.models.Events;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
@Repository
public interface EventRepository extends JpaRepository<Events, Long> {

//    // Find by event code (useful for unique events)
//    Optional<Events> findByEventCode(String eventCode);
//
//    // Find events by status (UPCOMING, ONGOING, COMPLETED)
//    List<Events> findByStatus(EventStatus status);
//
//    // Find events by venue
//    List<Events> findByVenue(String venue);
//
//    // Find events by project chair (user id)
//    List<Events> findByProjectChairId(Long projectChairId);
//
//    // Search by event name (partial match)
//    List<Events> findByEventNameContainingIgnoreCase(String keyword);

    List<Events> findTop6ByOrderByCreatedAtDesc();

    long countByStatus(EventStatus status);

    Page<Events> findAllByOrderByCreatedAtDesc(Pageable pageable);

    List<Events> findByEventNameContainingIgnoreCaseOrEventCodeContainingIgnoreCaseOrVenueContainingIgnoreCase(
            String eventName, String eventCode, String venue);

}
