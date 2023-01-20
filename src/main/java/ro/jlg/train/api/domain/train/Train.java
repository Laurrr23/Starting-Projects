package ro.jlg.train.api.domain.train;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@AllArgsConstructor
@Getter
@Document
public class Train {
    @Id
    private String id;
    private String departure;
    private String destination;
    private LocalDateTime departureTime;
    private int numberOfSeats;


    public void update(
            final String newDeparture,
            final String newDestination,
            final LocalDateTime newDepartureTime,
            final int newNumberoFSeats
    ){
        this.departure = newDeparture;
        this.departureTime = newDepartureTime;
        this.destination = newDestination;
        this.numberOfSeats = newNumberoFSeats;

    }
    public void reservedSeat() throws Exception{
        if(this.numberOfSeats < 0){
            throw new Exception("Train has no available seats");
        }
        this.numberOfSeats--;
    }
}
