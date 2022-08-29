//package pl.sdaacademy.ConferenceRoomReservationSystem.reservation;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.time.LocalDateTime;
//
//@Entity
//public class Reservation {
//
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    private String id;
//
//    @NotNull(groups = AddReservation.class)
//    private LocalDateTime startDate;
//    @NotNull(groups = AddReservation.class)
//    private LocalDateTime endDate;
//
//    @Size(min = 2,max = 20, groups = {AddReservation.class, UpdateReservation.class})
//    private String reservationName;
//
//    @ManyToOne
//    private ConfereceRoom
//}
//interface AddReservation{}
//interface UpdateReservation {}
