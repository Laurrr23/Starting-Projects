package ro.jlg.train.api.application.DTO.Train;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class CreateTrainDto {
    private String departure;
    private String destination;
    private String departureTime;
    private int numberOfSeats;
}
