package ro.jlg.train.api.domain.train;

import java.util.List;

public interface TrainRepository {

    void save(final Train train );

    void remove (final String trainId);

    List<Train>getAll();

    Train getById(final String trainId);


}
