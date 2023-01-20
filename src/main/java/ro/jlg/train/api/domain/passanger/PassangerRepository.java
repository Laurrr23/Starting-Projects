package ro.jlg.train.api.domain.passanger;

import java.util.List;

public interface PassangerRepository {
    void save(final Passanger passanger);
    void remove (final String passangerId);
    List<Passanger>getAll();


    Passanger getById(String passasngerId);
}
