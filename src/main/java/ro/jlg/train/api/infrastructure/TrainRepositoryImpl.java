package ro.jlg.train.api.infrastructure;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ro.jlg.train.api.domain.train.Train;
import ro.jlg.train.api.domain.train.TrainRepository;

import java.util.List;

@Repository
@AllArgsConstructor


public class TrainRepositoryImpl implements TrainRepository {
    private MongoTemplate mongoTemplate;

    @Override
    public void save(final Train train){
        this.mongoTemplate.save(train);


    }
    @Override
    public void remove (final String trainId){
        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(trainId));
        this.mongoTemplate.remove(query,Train.class);
    }

    @Override
    public List<Train> getAll() {

        return this.mongoTemplate.findAll(Train.class);
    }
    @Override
    public Train getById(final String trainId){
        return this.mongoTemplate.findById(trainId, Train.class);
    }
}
